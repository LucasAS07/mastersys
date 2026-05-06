package br.com.losystem.mastersys.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record PlanoRequest(

        @NotBlank(message = "O nome é obrigatorio")
        @Size(max = 100, message = "O nome deve ter no maximo 100 caracteres")
        String nome,

        @NotNull(message = "O valor mensal é obrigatorio")
        BigDecimal valorMensal,

        @NotNull(message = "A modalidade é obrigatoria")
        Long modalidadeId
) {
}
