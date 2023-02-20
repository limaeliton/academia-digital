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
@Table(name = "tb_avaliacoes")
public class AvaliacaoFisica {

  @Id // vai ser a chave PRIMARIA
  @GeneratedValue(strategy = GenerationType.IDENTITY) // para gerar o ID AUTOMATICO
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL) // tudo que fizer em avaliação física reflete em aluno
  @JoinColumn(name = "aluno_id" ) // A COLUNA DAS FK VAI TAR DENTRO DE AVALIAÇÕES FÍSICAS >> relaciona avaliação física com o id de cada aluno
  private Aluno aluno;

  // a data da avaliação é criada automaticamente
  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  @Column(name = "peso_atual")
  private double peso;

  @Column(name = "altura_atual")
  private double altura;

}
