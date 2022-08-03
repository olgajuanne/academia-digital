package dio.academia.academiadigital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.academia.academiadigital.entity.Aluno;
import dio.academia.academiadigital.entity.AvaliacaoFisica;
import dio.academia.academiadigital.entity.form.AvaliacaoFisicaForm;
import dio.academia.academiadigital.entity.form.AvaliacaoFisicaUpdateForm;
import dio.academia.academiadigital.repository.AlunoRepository;
import dio.academia.academiadigital.repository.AvaliacaoFisicaRepository;
import dio.academia.academiadigital.service.IAvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService{

  @Autowired
  private AvaliacaoFisicaRepository avaliacaoFisicRrepository;

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
    AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
    Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

    avaliacaoFisica.setAluno(aluno);
    avaliacaoFisica.setPeso(form.getPeso());
    avaliacaoFisica.setAltura(form.getAltura());

    return avaliacaoFisicRrepository.save(avaliacaoFisica);
  }

  @Override
  public AvaliacaoFisica get(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<AvaliacaoFisica> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void delete(Long id) {
    // TODO Auto-generated method stub
    
  }

}
