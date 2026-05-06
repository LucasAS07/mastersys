package br.com.losystem.mastersys.dto.request;

import br.com.losystem.mastersys.model.Modalidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ModalidadeRequest(

        @NotBlank(message = "O nome é obrigatorio")
        @Size(max = 100, message = "O nome deve ter no maximo 100 caracteres")
        String nome) {

        public Modalidade toEntity(){
                Modalidade modalidade = new Modalidade();
                preencherModalidade(modalidade);
                return modalidade;
        }

        public void preencherModalidade(Modalidade modalidade) {
                modalidade.setNome(nome);
        }
}

