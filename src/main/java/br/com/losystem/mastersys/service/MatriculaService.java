package br.com.losystem.mastersys.service;

import br.com.losystem.mastersys.dto.request.MatriculaRequest;
import br.com.losystem.mastersys.dto.response.MatriculaResponse;
import br.com.losystem.mastersys.exception.RegraNegocioException;
import br.com.losystem.mastersys.model.Aluno;
import br.com.losystem.mastersys.model.Matricula;
import br.com.losystem.mastersys.repository.AlunoRepository;
import br.com.losystem.mastersys.repository.MatriculaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;

    public MatriculaResponse cadastrar(MatriculaRequest request) {
        Aluno aluno = alunoRepository.findById(request.alunoId()).orElseThrow(
                () -> new RegraNegocioException("Aluno não cadastrado")
        );

        Matricula matricula = new Matricula();
        matricula.setDiaVencimento(request.diaVencimento());
        matricula.setAluno(aluno);
        return MatriculaResponse.fromEntity(matriculaRepository.save(matricula));
    }

    public Page<MatriculaResponse> listar(Pageable pageable) {
        return matriculaRepository.findAll(pageable).map(MatriculaResponse::fromEntity);
    }

    public MatriculaResponse buscarPorId(Long id) {
        return MatriculaResponse.fromEntity(buscaEntidadePorId(id));
    }

    public MatriculaResponse atualizar(Long id, MatriculaRequest request) {
        Matricula matricula = buscaEntidadePorId(id);

        Aluno aluno = alunoRepository.findById(matricula.getAluno().getId())
                .orElseThrow(() -> new RegraNegocioException("Aluno não cadastrado"));

        matricula.setDiaVencimento(request.diaVencimento());
        matricula.setAluno(aluno);

        matriculaRepository.save(matricula);

        return MatriculaResponse.fromEntity(matricula);
    }

    public void excluir(Long id) {
        Matricula matricula = buscaEntidadePorId(id);
        matriculaRepository.delete(matricula);
    }

    private Matricula buscaEntidadePorId(Long id) {
        Matricula matricula = matriculaRepository.findById(id).orElseThrow(
                ()-> new RegraNegocioException("Matricula não encontrada")
        );
        return matricula;
    }
}
