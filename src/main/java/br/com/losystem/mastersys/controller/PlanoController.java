package br.com.losystem.mastersys.controller;

import br.com.losystem.mastersys.dto.request.PlanoRequest;
import br.com.losystem.mastersys.dto.response.PlanoResponse;
import br.com.losystem.mastersys.service.PlanoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/planos")
public class PlanoController {

    private final PlanoService planoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PlanoResponse cadastrar(@RequestBody PlanoRequest planoRequest) {
        return planoService.cadastrar(planoRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<PlanoResponse> listar(Pageable pageable) {
        return planoService.listar(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PlanoResponse buscarPorId(@PathVariable Long id) {
        return planoService.buscarPorID(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public PlanoResponse atualizar(@PathVariable Long id, @RequestBody PlanoRequest planoRequest) {
        return planoService.atualizar(id,planoRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        planoService.excluir(id);
    }

}
