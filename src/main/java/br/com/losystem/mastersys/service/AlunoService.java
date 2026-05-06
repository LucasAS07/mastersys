package br.com.losystem.mastersys.service;

import br.com.losystem.mastersys.dto.request.AlunoFiltroRequest;
import br.com.losystem.mastersys.dto.request.AlunoRequest;
import br.com.losystem.mastersys.dto.response.AlunoResponse;
import br.com.losystem.mastersys.exception.RegraNegocioException;
import br.com.losystem.mastersys.model.Aluno;
import br.com.losystem.mastersys.repository.AlunoRepository;
import br.com.losystem.mastersys.specification.AlunoSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AlunoService {

    public final AlunoRepository alunoRepository;

    public AlunoResponse cadastra(AlunoRequest alunoRequest) {
        if (alunoRequest.email() != null && alunoRepository.existsByEmail(alunoRequest.email())) {
            throw new RegraNegocioException("Já existe um aluno com esse e-mail");
        }

        Aluno aluno = alunoRequest.toEntity();
        Aluno alunoSalvo = alunoRepository.save(aluno);

        return AlunoResponse.fromEntity(alunoSalvo);
    }

    public Page<AlunoResponse> listar(AlunoFiltroRequest filtro, Pageable pageable) {
        return alunoRepository.findAll(AlunoSpecification.comFiltros(filtro),pageable).map(AlunoResponse::fromEntity);
    }

    public AlunoResponse buscarPorId(Long id) {
        Aluno aluno = buscarEntidadePorId(id);
        return AlunoResponse.fromEntity(aluno);
    }

    public AlunoResponse atualizar(Long id, AlunoRequest alunoRequest) {
        Aluno aluno = buscarEntidadePorId(id);
        alunoRequest.preencher(aluno);
        Aluno alunoAtualizado = alunoRepository.save(aluno);
        return AlunoResponse.fromEntity(alunoAtualizado);
    }

    public void excluir(Long id) {
        Aluno aluno = buscarEntidadePorId(id);
        alunoRepository.delete(aluno);
    }

    private Aluno buscarEntidadePorId(Long id) {
        return alunoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Aluno não encontrado"));
    }

}
