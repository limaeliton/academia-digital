package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MatriculaServiceImmpl implements IMatriculaService {


    @Autowired //  FAZ A CONECÇÃO COM O BANCO ATRAVÉS DO REPOSITORY.
    private MatriculaRepository matriculaRepository ;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Matricula get(Long id) {
        return null;
    }

    @Override
    public List<Matricula> getAll(String bairro) {
        if (bairro == null){
            return matriculaRepository.findAll();
        }else {
            return matriculaRepository.findByAlunoBairro(bairro);
        }

    }

    @Override
    public void delete(Long id) {

    }

    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        matricula.setAluno(aluno);

        return matriculaRepository.save(matricula);
    }
}
