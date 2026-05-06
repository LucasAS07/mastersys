package br.com.losystem.mastersys.dto.response;

import br.com.losystem.mastersys.model.Graduacao;

public record GraduacaoResponse(
        Long id,
        String nome,
        String modalidade
) {
    public static GraduacaoResponse fromEntity(Graduacao graduacao) {
        return new GraduacaoResponse(
                graduacao.getId(),
                graduacao.getNome(),
                graduacao.getModalidade().getNome()
        );
    }
}
