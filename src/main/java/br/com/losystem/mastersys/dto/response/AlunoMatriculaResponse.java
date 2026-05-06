package br.com.losystem.mastersys.dto.response;

import br.com.losystem.mastersys.model.Aluno;

public record AlunoMatriculaResponse(
        Long id,
        String nome,
        String email
) {

    public static AlunoMatriculaResponse fromEntity(Aluno aluno) {
        return new AlunoMatriculaResponse(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail()
        );
    }

}
