package br.com.losystem.mastersys.model;

import br.com.losystem.mastersys.model.enums.StatusMatricula;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_matricula")
    private LocalDate dataMatricula;

    @Column(name = "dia_vencimento")
    private Integer diaVencimento;

    @Column(name = "data_encerramento")
    private LocalDate dataEncerramento;

    @Enumerated(EnumType.STRING)
    private StatusMatricula status = StatusMatricula.ATIVA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public void prePersit() {
        if (dataMatricula == null) {
            dataMatricula = LocalDate.now();
        }
    }

}
