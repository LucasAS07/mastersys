package br.com.losystem.mastersys.controller;

import br.com.losystem.mastersys.doc.AlunoControllerDoc;
import br.com.losystem.mastersys.dto.request.AlunoFiltroRequest;
import br.com.losystem.mastersys.dto.request.AlunoRequest;
import br.com.losystem.mastersys.dto.response.AlunoResponse;
import br.com.losystem.mastersys.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController implements AlunoControllerDoc {

    private final AlunoService alunoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AlunoResponse cadastrar(@RequestBody @Valid AlunoRequest alunoRequest) {
        return alunoService.cadastra(alunoRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<AlunoResponse> listar(AlunoFiltroRequest filtro, Pageable pageable) {
        return alunoService.listar(filtro,pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public AlunoResponse buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public AlunoResponse atualizar(@PathVariable Long id, @RequestBody @Valid AlunoRequest alunoRequest) {
        return alunoService.atualizar(id,alunoRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        alunoService.excluir(id);
    }

}
