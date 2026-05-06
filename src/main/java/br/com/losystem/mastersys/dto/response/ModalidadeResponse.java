package br.com.losystem.mastersys.dto.response;

import br.com.losystem.mastersys.model.Modalidade;

public record ModalidadeResponse(
        Long id,
        String nome,
        Boolean ativo
) {

    public static ModalidadeResponse fromEntity(Modalidade modalidade) {
        return new ModalidadeResponse(
                modalidade.getId(),
                modalidade.getNome(),
                modalidade.getAtiva()
        );
    }
}
