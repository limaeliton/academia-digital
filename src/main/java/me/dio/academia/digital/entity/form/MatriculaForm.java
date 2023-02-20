package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data // serve para abstrair o GET, SET, EQUALS, RESCOD, com essa anotação não precisa colocar na classe
@NoArgsConstructor // CRIA UM CONSTRUTOR VAZIO
@AllArgsConstructor // CRIA O CONSTRUTOR COM TODOS OS ATRIBUTOS  // SÃO ANOTAÇÕES DO "LOMBOK"
public class MatriculaForm {

  @NotNull(message = "preencha o campo corretamente.") // o campo não pode ser vázio
  @Positive(message = "O id do aluno precisa ser positivo")
  private Long alunoId;

}
