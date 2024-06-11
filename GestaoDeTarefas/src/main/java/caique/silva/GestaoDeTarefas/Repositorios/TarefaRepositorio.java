package caique.silva.GestaoDeTarefas.Repositorios;

import caique.silva.GestaoDeTarefas.Dados.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepositorio extends JpaRepository<Tarefa, Long> {
}
