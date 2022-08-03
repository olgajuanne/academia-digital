package dio.academia.academiadigital.controller;

import dio.academia.academiadigital.entity.Aluno;
import dio.academia.academiadigital.entity.AvaliacaoFisica;
import dio.academia.academiadigital.entity.form.AlunoForm;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dio.academia.academiadigital.service.impl.AlunoServiceImpl;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

  @Autowired
  private AlunoServiceImpl service;

  // @GetMapping
  // public List<Aluno> getAll() {
  //   return service.getAll(String );
  // }

  @PostMapping
  public Aluno create(@Valid @RequestBody AlunoForm form){
    return service.create(form);
  }

  @GetMapping("/avaliacoes/{id}")
  public List<AvaliacaoFisica> getAllAvaliacaoFisicasId(@PathVariable Long id) {
    return service.getAllAvaliacaoFisicasId(id);
  }

  @GetMapping
  public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNacimento){
    return service.getAll(dataDeNacimento);
  }
}
