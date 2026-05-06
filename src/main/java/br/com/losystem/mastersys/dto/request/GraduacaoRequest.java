package br.com.losystem.mastersys.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record GraduacaoRequest(

        @NotBlank(message = "Nome é obrigatorio")
        @Size(max = 100, message = "O nome deve ter no maximo 100 caracteres")
        String nome,

        @NotNull(message = "Modalidade é obrigatorio")
        Long modalidadeId
) {}
