package caique.silva.GestaoDeTarefas.Repositorios;

import caique.silva.GestaoDeTarefas.Dados.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
}
