package dio.academia.academiadigital.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import dio.academia.academiadigital.entity.Aluno;
import dio.academia.academiadigital.entity.Matricula;
import dio.academia.academiadigital.entity.form.MatriculaForm;
import dio.academia.academiadigital.repository.AlunoRepository;
import dio.academia.academiadigital.repository.MatriculaRepository;
import dio.academia.academiadigital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

  @Autowired
  private MatriculaRepository matriculaRepository;

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public Matricula create(MatriculaForm form) {
    Matricula matricula = new Matricula();
    Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

    matricula.setAluno(aluno);

    return matriculaRepository.save(matricula);
  }

  @Override
  public Matricula get(Long id) {
    return matriculaRepository.findById(id).get();
  }

  @Override
  public List<Matricula> getAll(String bairro) {

    if(bairro == null){
      return matriculaRepository.findAll();
    }else{
      return matriculaRepository.findAlunosMatriculadosBairro(bairro);
    }

  }

  @Override
  public void delete(Long id) {}
  

}
