package br.com.losystem.mastersys.doc;

import br.com.losystem.mastersys.dto.request.AlunoFiltrorRequest;
import br.com.losystem.mastersys.dto.request.AlunoRequest;
import br.com.losystem.mastersys.dto.response.AlunoResponse;
import br.com.losystem.mastersys.exception.ErroResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Alunos", description = "Operações para cadastro, consulta, atualização, exclusão e filtragem de alunos")
public interface AlunoControllerDoc {

    @Operation(
            summary = "Cadastrar aluno",
            description = "Cria um novo aluno no sistema de academia",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Aluno cadastrado com sucesso"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Erro de validação ou regra de negócio",
                            content = @Content(schema = @Schema(implementation = ErroResponse.class))
                    )
            }
    )
    AlunoResponse cadastrar(@RequestBody
                            @Valid
                            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                    description = "Dados nescessários para cadastrar um aluno",
                                    required = true,
                                    content = @Content(schema = @Schema(implementation = AlunoRequest.class),
                                            examples = @ExampleObject(
                                                    name = "Aluno valido",
                                                    value = """
                                                            {
                                                                "nome": "João da Silva",
                                                                "dataNascimento": "2002-11-30",
                                                                "sexo": "M",
                                                                "telefone": "37999889988",
                                                                "email": "joao@email.com",
                                                                "observacao": "Teste de POST de um aluno",
                                                                "endereco": "Rua Das Flores",
                                                                "numero": "123",
                                                                "complemento": "AP-101",
                                                                "bairro": "Centro",
                                                                "cidade": "São Paulo",
                                                                "estado": "SP",
                                                                "cep": "11236000"
                                                            }
                                                            """
                                            )
                                    )
                            )
                            AlunoRequest alunoRequest);


    @Operation(
            summary = "Listar alunos",
            description = "Lista alunos de forma paginada permitindo filtros opcionais por " +
                    "nome, e-mail, celular, cidade e estado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de alunos retornada com sucesso")
            }
    )
    Page<AlunoResponse> listar(
            @Parameter(description = "Filtros opcionais para busca de alunos")
            AlunoFiltrorRequest filtro,

            @Parameter(description = "Informações de paginação e ordenação")
            Pageable pageable

    );

    @Operation(
            summary = "Buscar aluno por id",
            description = "Retorna os dados resumidos de um aluno espesifico ",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Aluno encontrado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Aluno não encontrado",
                            content = @Content(schema = @Schema(implementation = ErroResponse.class)))
            }
    )
    AlunoResponse buscarPorId(
            @Parameter(description = "ID do aluno", example = "2", required = true)
            Long id
    );

    @Operation(
            summary = "Atualiza um aluno por id",
            description = "Atualiza os dados de determinado aluno",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Aluno encontrado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Aluno não encontrado",
                            content = @Content(schema = @Schema(implementation = ErroResponse.class)))
            }
    )
    AlunoResponse atualizar(
            @Parameter(description = "ID do aluno", example = "2", required = true)
            Long id,
            @Valid
            @RequestBody
            AlunoRequest alunoRequest
    );

    @Operation(
            summary = "Exclui um aluno por id",
            description = "Exclui todos os dados do aluno",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Aluno excluido com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Aluno não encontrado",
                            content = @Content(schema = @Schema(implementation = ErroResponse.class)))
            }
    )
    void excluir(@Parameter(description = "ID do aluno", example = "2", required = true)
                 Long id);
}


