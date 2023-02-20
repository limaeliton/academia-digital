package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
@Data // serve para abstrair o GET, SET, EQUALS, RESCOD, com essa anotação não precisa colocar na classe
@NoArgsConstructor // CRIA UM CONSTRUTOR VAZIO
@AllArgsConstructor // CRIA O CONSTRUTOR COM TODOS OS ATRIBUTOS  // SÃO ANOTAÇÕES DO "LOMBOK"
public class AvaliacaoFisicaForm {

  private Long alunoId;

  private double peso;

  private double altura;
}
