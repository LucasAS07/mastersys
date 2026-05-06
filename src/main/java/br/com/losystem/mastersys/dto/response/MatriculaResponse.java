package br.com.losystem.mastersys.dto.response;

import br.com.losystem.mastersys.model.Matricula;
import br.com.losystem.mastersys.model.enums.StatusMatricula;

import java.time.LocalDate;

public record MatriculaResponse(
        Long id,
        LocalDate dataMtricula,
        Integer diaVencimento,
        LocalDate dataEncerramento,
        StatusMatricula status,
        AlunoMatriculaResponse aluno
) {
    public static MatriculaResponse fromEntity(Matricula matricula){
        return new MatriculaResponse(
                matricula.getId(),
                matricula.getDataMatricula(),
                matricula.getDiaVencimento(),
                matricula.getDataEncerramento(),
                matricula.getStatus(),
                new AlunoMatriculaResponse(
                        matricula.getAluno().getId(),
                        matricula.getAluno().getNome(),
                        matricula.getAluno().getEmail()
                )
        );
    }
}
