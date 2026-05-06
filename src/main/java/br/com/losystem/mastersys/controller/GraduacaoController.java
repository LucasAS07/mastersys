package br.com.losystem.mastersys.controller;

import br.com.losystem.mastersys.dto.request.GraduacaoRequest;
import br.com.losystem.mastersys.dto.response.GraduacaoResponse;
import br.com.losystem.mastersys.service.GraduacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/graduacoes")
@RequiredArgsConstructor
public class GraduacaoController {

    private final GraduacaoService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<GraduacaoResponse> listar() {
        return service.listar();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public GraduacaoResponse buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public GraduacaoResponse cadastrar(@RequestBody @Valid GraduacaoRequest graduacaoRequest) {
        return service.cadastrar(graduacaoRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public GraduacaoResponse atualizar(@PathVariable Long id, @RequestBody GraduacaoRequest graduacaoRequest) {
        return service.atualizar(id,graduacaoRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

}
