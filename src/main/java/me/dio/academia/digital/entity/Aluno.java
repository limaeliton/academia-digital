package me.dio.academia.digital.entity;
// SÃO CLASSES DE MODELO QUE ESTÃO REPRESENTANDO O DOMÍNIO DA APLICAÇÃO.
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Data // serve para abstrair o GET, SET, EQUALS, RESCOD, com essa anotação não precisa colocar na classe
@NoArgsConstructor // CRIA UM CONSTRUTOR VAZIO
@AllArgsConstructor // CRIA O CONSTRUTOR COM TODOS OS ATRIBUTOS  // SÃO ANOTAÇÕES DO "LOMBOK"
@Entity // CRIA A TABELA NO BANCO POR PADRÃO ELA PEDE UM @Id
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // o HIBERNET VAI TER UMA INICIALIZAÇÃO LENTA
public class Aluno {

  @Id // vai ser a chave PRIMARIA
  @GeneratedValue(strategy = GenerationType.IDENTITY) // para gerar o ID AUTOMATICO
  private Long id;


  private String nome;

  @Column(unique = true)
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  //  fetch = FetchType.LAZY >> BOA PRATICA PARA PERFOMACE
  // carrega todas as informações do aluno MENOS AVALIAÇÕES FISÍCAS
  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
  @JsonIgnore // para evitar o LUP INFINITO >> E EVITA EXCEPTION DO JSON
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
