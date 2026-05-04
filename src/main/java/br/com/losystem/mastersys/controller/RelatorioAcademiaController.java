package br.com.losystem.mastersys.controller;

import br.com.losystem.mastersys.projection.AlunosPorCidadeProjection;
import br.com.losystem.mastersys.projection.FaturamentoMensalProjection;
import br.com.losystem.mastersys.projection.FaturasEmAbertoProjection;
import br.com.losystem.mastersys.repository.RelatorioAcademiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
@RequiredArgsConstructor
public class RelatorioAcademiaController {

    private final RelatorioAcademiaRepository relatorioAcademiaRepository;

    @GetMapping("/faturamento-mensal")
    public List<FaturamentoMensalProjection> faturamentoMensal() {
        return relatorioAcademiaRepository.faturamentoMensal();
    }

    @GetMapping("/alunos-por-cidade")
    public List<AlunosPorCidadeProjection> alunosPorCidade() {
        return relatorioAcademiaRepository.alunosPorCidade();
    }

    @GetMapping("/faturas-em-aberto")
    public List<FaturasEmAbertoProjection> faturamentoEmAberto() {
        return relatorioAcademiaRepository.faturasEmAberto();
    }

}
