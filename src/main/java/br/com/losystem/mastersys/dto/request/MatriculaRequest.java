package br.com.losystem.mastersys.dto.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record MatriculaRequest(

        @NotNull(message = "Dia do vencimento é obrigatorio")
        Integer diaVencimento,

        @NotNull(message = "Aluno é obrigatorio")
        Long alunoId
) {

}
