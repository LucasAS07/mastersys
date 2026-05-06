package br.com.losystem.mastersys.service;

import br.com.losystem.mastersys.dto.request.PlanoRequest;
import br.com.losystem.mastersys.dto.response.PlanoResponse;
import br.com.losystem.mastersys.exception.RegraNegocioException;
import br.com.losystem.mastersys.model.Modalidade;
import br.com.losystem.mastersys.model.Plano;
import br.com.losystem.mastersys.repository.ModalidadeRepository;
import br.com.losystem.mastersys.repository.PlanoRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlanoService {

    private final PlanoRepository planoRepository;
    private final ModalidadeRepository modalidadeRepository;

    public PlanoResponse cadastrar(PlanoRequest planoRequest) {
        Modalidade modalidade = buscaModalidadePorId(planoRequest);

        Plano plano = new Plano();
        plano.setNome(planoRequest.nome());
        plano.setValorMensal(planoRequest.valorMensal());
        plano.setModalidade(modalidade);
        return PlanoResponse.fromEntity(planoRepository.save(plano));
    }

    public Page<PlanoResponse> listar(Pageable pageable) {
        return planoRepository.findAll(pageable).map(PlanoResponse::fromEntity);
    }

    public PlanoResponse buscarPorID(Long id) {
        Plano plano = buscaEntidadePorId(id);
        return PlanoResponse.fromEntity(plano);
    }

    public PlanoResponse atualizar(Long id, PlanoRequest planoRequest) {
        Modalidade modalidade = buscaModalidadePorId(planoRequest);

        Plano plano = buscaEntidadePorId(id);
        plano.setNome(planoRequest.nome());
        plano.setValorMensal(planoRequest.valorMensal());
        plano.setModalidade(modalidade);

        return PlanoResponse.fromEntity(planoRepository.save(plano));
    }

    public void excluir(Long id) {
        Plano plano = buscaEntidadePorId(id);
        planoRepository.delete(plano);
    }

    private Plano buscaEntidadePorId(Long id) {
        return planoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Plano não encontrado"));
    }

    private @NonNull Modalidade buscaModalidadePorId(PlanoRequest planoRequest) {
        return modalidadeRepository.findById(planoRequest.modalidadeId()).orElseThrow(
                () -> new RegraNegocioException("Modalidade não encontrada")
        );
    }

}
