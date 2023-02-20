package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
// SÃO CLASSES DE MODELO QUE ESTÃO REPRESENTANDO O DOMÍNIO DA APLICAÇÃO.

@Data // serve para abstrair o GET, SET, EQUALS, RESCOD, com essa anotação não precisa colocar na classe
@NoArgsConstructor // CRIA UM CONSTRUTOR VAZIO
@AllArgsConstructor // CRIA O CONSTRUTOR COM TODOS OS ATRIBUTOS  // SÃO ANOTAÇÕES DO "LOMBOK"
@Entity  // CRIA A TABELA NO BANCO POR PADRÃO ELA PEDE UM @Id
@Table(name = "tb_matriculas")
public class Matricula {

  @Id // vai ser a chave PRIMARIA
  @GeneratedValue(strategy = GenerationType.IDENTITY) // para gerar o ID AUTOMATICO
  private Long id;

  // NÃO COLOCA mappedBy POIS NA TABELA ALUNO NÃO TEM A COLUNA MATRICULA
  @OneToOne(cascade = CascadeType.ALL)  // tudo que fizer em matrícula  reflete em aluno
  @JoinColumn(name = "aluno_id" ) // A COLUNA DAS FK VAI TAR DENTRO DE MATRICULA >> relaciona  matrícula com o id de cada aluno
  private Aluno aluno;

  private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
