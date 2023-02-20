package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Data // serve para abstrair o GET, SET, EQUALS, RESCOD, com essa anotação não precisa colocar na classe
@NoArgsConstructor // CRIA UM CONSTRUTOR VAZIO
@AllArgsConstructor // CRIA O CONSTRUTOR COM TODOS OS ATRIBUTOS  // SÃO ANOTAÇÕES DO "LOMBOK"
public class AlunoForm {

  @NotBlank(message = "preencha o campo corretamente.") // o campo não pode ser vázio
  @Size(min = 3, max = 50, message = "'${validateValue}' precisa estar entre {min} e {max} caracteres.")
  private String nome;

  @NotBlank(message = "preencha o campo corretamente.")
  @CPF(message = "'${validatedValue}' é inválido!")
  private String cpf;

  @NotBlank(message = "preencha o campo corretamente.") //  @NotBlank só quando for String
  @Size(min = 3, max = 50, message = "'${validateValue}' precisa estar entre {min} e {max} caracteres.")
  private String bairro;

  @NotNull(message =  "preencha o campo corretamente.")
  @Past(message = "Data '${validatedValue}' é inválida") // a data de nascimento tem que ser no passado
  private LocalDate dataDeNascimento;
}
