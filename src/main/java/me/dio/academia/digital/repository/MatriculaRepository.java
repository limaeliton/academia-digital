package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    /* @Param bairro bairro referência para o filtro
       @Return lista de alunos matriculados que residem no bairro passado como parâmetro

    * */
    // @Query(value = "Select * From tb_matriculas m" +
    //"Inner Join tb_alunos a ON m.aluno_id = a.id" +
    // "WHERE a.bairro = :bairro nativeQuery = true)

    // @Query("FROM Matricula m WHERE m.aluno.bairro = :bairro ")



    List<Matricula> findByAlunoBairro(String bairro);
}
