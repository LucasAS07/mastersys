package br.com.losystem.mastersys.dto.response;

import br.com.losystem.mastersys.model.Modalidade;

public record ModalidadePlanoResponse(
        String nome
) {

    public static ModalidadePlanoResponse fromEntity(Modalidade modalidade) {
        return new ModalidadePlanoResponse(
                modalidade.getNome()
        );
    }
}
