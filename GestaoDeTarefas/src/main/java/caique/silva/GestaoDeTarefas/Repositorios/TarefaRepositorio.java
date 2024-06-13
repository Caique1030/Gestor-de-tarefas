package caique.silva.GestaoDeTarefas.Repositorios;

import caique.silva.GestaoDeTarefas.Dados.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TarefaRepositorio extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findAll();
    Tarefa save(Tarefa tarefa);
    Optional<Tarefa> findById(Long id);
    void deleteById(Long id);
}
