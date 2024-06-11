package caique.silva.GestaoDeTarefas.Repositorios;

import caique.silva.GestaoDeTarefas.Dados.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
