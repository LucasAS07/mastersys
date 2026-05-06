package br.com.losystem.mastersys.dto.request;

public record MatriculaModalidadeRequest(
        Long matriculaId,
        Long planoId,
        Long modalidadeId
) {
}
