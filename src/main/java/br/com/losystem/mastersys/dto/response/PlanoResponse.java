package br.com.losystem.mastersys.dto.response;

import br.com.losystem.mastersys.model.Plano;

import java.math.BigDecimal;

public record PlanoResponse(
        Long id,
        String nome,
        BigDecimal valorMensal,
        ModalidadePlanoResponse modalidade,
        Boolean ativo
) {
    public static PlanoResponse fromEntity(Plano plano){
        return new PlanoResponse(
                plano.getId(),
                plano.getNome(),
                plano.getValorMensal(),
                new ModalidadePlanoResponse(
                        plano.getModalidade().getNome()
                ),
                plano.getAtivo()
        );
    }
}
