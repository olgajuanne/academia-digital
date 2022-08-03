package dio.academia.academiadigital.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.academia.academiadigital.entity.Aluno;
import dio.academia.academiadigital.entity.AvaliacaoFisica;
import dio.academia.academiadigital.entity.form.AlunoForm;
import dio.academia.academiadigital.entity.form.AlunoUpdateForm;
import dio.academia.academiadigital.infra.utils.JavaTimeUtils;
import dio.academia.academiadigital.repository.AlunoRepository;
import dio.academia.academiadigital.service.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService {

  @Autowired
  private AlunoRepository repository;

  @Override
  public Aluno create(AlunoForm form) {
    Aluno aluno = new Aluno();
    aluno.setNome(form.getNome());
    aluno.setCpf(form.getCpf());
    aluno.setDataDeNascimento(form.getDataDeNascimento());
    aluno.setDataDeNascimento(form.getDataDeNascimento());

    return repository.save(aluno);
  }

  @Override
  public Aluno get(Long id) {
    return null;
  }

  @Override
  public List<Aluno> getAll(String dataDeNascimento) {

    if(dataDeNascimento == null){
      return repository.findAll();
    }else {
      LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
      return repository.findByDataDeNascimento(localDate);
    }
    
  }

  @Override
  public Aluno update(Long id, AlunoUpdateForm formUpdate) {

    return null;
  }

  @Override
  public void delete(Long id) {

    
  }

  @Override
  public List<AvaliacaoFisica> getAllAvaliacaoFisicasId(Long id) {
    Aluno aluno = repository.findById(id).get();
    return aluno.getAvaliacoes();
  }

}
