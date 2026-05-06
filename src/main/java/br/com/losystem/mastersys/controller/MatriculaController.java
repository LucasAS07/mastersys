package br.com.losystem.mastersys.controller;

import br.com.losystem.mastersys.dto.request.MatriculaRequest;
import br.com.losystem.mastersys.dto.response.MatriculaResponse;
import br.com.losystem.mastersys.service.MatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<MatriculaResponse> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public MatriculaResponse buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MatriculaResponse cadastrar(@RequestBody MatriculaRequest request) {
        return service.cadastrar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public MatriculaResponse atualizar(@PathVariable Long id, @RequestBody MatriculaRequest request) {
        return service.atualizar(id,request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

}
