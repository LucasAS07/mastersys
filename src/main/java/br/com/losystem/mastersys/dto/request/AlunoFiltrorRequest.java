package br.com.losystem.mastersys.dto.request;

public record AlunoFiltrorRequest(
        String nome,
        String email,
        String celular,
        String cidade,
        String estado
) {
}
