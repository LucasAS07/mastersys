package br.com.losystem.mastersys.controller;

import br.com.losystem.mastersys.dto.request.ModalidadeRequest;
import br.com.losystem.mastersys.dto.response.ModalidadeResponse;
import br.com.losystem.mastersys.service.ModalidadeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modalidades")
@RequiredArgsConstructor
public class ModalidadeController {

    private final ModalidadeService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ModalidadeResponse> listar() {
        return service.listar();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ModalidadeResponse buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ModalidadeResponse cadastrar(@RequestBody @Valid ModalidadeRequest modalidade) {
        return service.cadastrar(modalidade);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public ModalidadeResponse atualizar(@PathVariable Long id, @RequestBody ModalidadeRequest modalidadeRequest) {
        return service.atualizar(id,modalidadeRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}
