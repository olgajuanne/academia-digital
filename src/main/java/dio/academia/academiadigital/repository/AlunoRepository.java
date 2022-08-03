package dio.academia.academiadigital.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dio.academia.academiadigital.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

  List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimento);
}
