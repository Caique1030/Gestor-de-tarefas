package caique.silva.GestaoDeTarefas.Serviços;

import caique.silva.GestaoDeTarefas.Dados.Usuario;
import caique.silva.GestaoDeTarefas.Repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServico {


    @Autowired
    private UsuarioRepositorio usuarioRepository;

    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public boolean autenticar(String username, String password) {
        Usuario usuario = findByUsername(username);
        if (usuario != null && usuario.getPassword().equals(password)) {
            return true; // Credenciais válidas
        }
        return false; // Credenciais inválidas
    }
    public boolean existeUsuario(String username) {
        return usuarioRepository.findByUsername(username) != null;
    }
    public void registrarNovoUsuario(String username, String password) {
        // Verifica se o usuário já existe
        if (existeUsuario(username)) {
            throw new IllegalArgumentException("O nome de usuário já está em uso. Por favor, escolha outro.");
        }

        // Cria um novo usuário
        Usuario novoUsuario = new Usuario();
        novoUsuario.setUsername(username);
        novoUsuario.setPassword(password);

        // Salva o novo usuário no banco de dados
        usuarioRepository.save(novoUsuario);
    }
}
