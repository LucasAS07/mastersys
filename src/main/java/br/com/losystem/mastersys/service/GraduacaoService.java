package br.com.losystem.mastersys.service;

import br.com.losystem.mastersys.dto.request.GraduacaoRequest;
import br.com.losystem.mastersys.dto.response.GraduacaoResponse;
import br.com.losystem.mastersys.exception.RegraNegocioException;
import br.com.losystem.mastersys.model.Graduacao;
import br.com.losystem.mastersys.model.Modalidade;
import br.com.losystem.mastersys.repository.GraduacaoRepository;
import br.com.losystem.mastersys.repository.ModalidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GraduacaoService {

    private final GraduacaoRepository repository;
    private final ModalidadeRepository modalidadeRepository;

    public GraduacaoResponse cadastrar(GraduacaoRequest request) {
        Modalidade modalidade = modalidadeRepository.findById(request.modalidadeId())
                .orElseThrow(() -> new RegraNegocioException("Modalidade não encontrada"));

        Graduacao graduacao = new Graduacao();
        graduacao.setNome(request.nome());
        graduacao.setModalidade(modalidade);

        Graduacao salva = repository.save(graduacao);

        return GraduacaoResponse.fromEntity(salva);
    }

    public List<GraduacaoResponse> listar() {
        return repository.findAll().stream().map(GraduacaoResponse::fromEntity).toList();
    }

    public GraduacaoResponse buscarPorId(Long id) {
        Graduacao graduacao = buscaEntidadePorId(id);
        return GraduacaoResponse.fromEntity(graduacao);
    }

    public GraduacaoResponse atualizar(Long id, GraduacaoRequest request) {
        Graduacao graduacao = buscaEntidadePorId(id);

        Modalidade modalidade = modalidadeRepository.findById(request.modalidadeId()).orElseThrow(
                () -> new RegraNegocioException("Modalidade não encontrada"));

        graduacao.setNome(request.nome());
        graduacao.setModalidade(modalidade);
        return GraduacaoResponse.fromEntity(repository.save(graduacao));
    }

    public void excluir(Long id) {
        Graduacao graduacao = buscaEntidadePorId(id);
        repository.delete(graduacao);
    }

    private Graduacao buscaEntidadePorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RegraNegocioException("Graduação não encontrada"));
    }
}
