package br.com.losystem.mastersys.service;

import br.com.losystem.mastersys.dto.request.ModalidadeRequest;
import br.com.losystem.mastersys.dto.response.ModalidadeResponse;
import br.com.losystem.mastersys.exception.RegraNegocioException;
import br.com.losystem.mastersys.model.Modalidade;
import br.com.losystem.mastersys.repository.ModalidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModalidadeService {

    private final ModalidadeRepository modalidadeRepository;

    public ModalidadeResponse cadastrar(ModalidadeRequest modalidadeRequest) {
        Modalidade modalidade = modalidadeRepository.save(modalidadeRequest.toEntity());
        return ModalidadeResponse.fromEntity(modalidade);
    }

    public List<ModalidadeResponse> listar() {
        return modalidadeRepository.findAll().stream().map(ModalidadeResponse::fromEntity).toList();
    }

    public ModalidadeResponse buscarPorId(Long id) {
        Modalidade modalidade = buscarEntidadePorId(id);
        return ModalidadeResponse.fromEntity(modalidade);
    }

    public ModalidadeResponse atualizar(Long id, ModalidadeRequest modalidadeRequest) {
        Modalidade modalidade = buscarEntidadePorId(id);
        modalidadeRequest.preencherModalidade(modalidade);
        return ModalidadeResponse.fromEntity(modalidadeRepository.save(modalidade));
    }

    public void deletar(Long id) {
        Modalidade modalidade = buscarEntidadePorId(id);
        modalidadeRepository.delete(modalidade);
    }

    private Modalidade buscarEntidadePorId(Long id) {
        return modalidadeRepository.findById(id).orElseThrow(
                () -> new RegraNegocioException("Modalidade não encontrado"));
    }

}
