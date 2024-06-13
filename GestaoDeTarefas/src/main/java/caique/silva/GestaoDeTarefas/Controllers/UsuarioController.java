package caique.silva.GestaoDeTarefas.Controllers;

import caique.silva.GestaoDeTarefas.Serviços.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UsuarioController {
    @Autowired
    private UsuarioServico usuarioServico;

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login"; // Supondo que você tenha uma página chamada login.html em seus recursos de modelo Thymeleaf
    }

    @GetMapping("/registro")
    public String mostrarFormularioRegistro() {
        return "registro"; // Supondo que você tenha uma página chamada registro.html em seus recursos de modelo Thymeleaf
    }

    @PostMapping("/login")
    public String processarLogin(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 Model model) {
        // Lógica de autenticação do usuário
        if (usuarioServico.autenticar(username, password)) {
            // Se as credenciais forem válidas, redireciona para a página principal ou outra página desejada
            return "redirect:/categorias";
        } else {
            model.addAttribute("erro", "Usuário ou senha inválidos. Por favor, tente novamente.");
            return "login";
        }
    }

    @PostMapping("/registro")
    public String processarRegistro(@RequestParam("newUsername") String newUsername,
                                    @RequestParam("newPassword") String newPassword,
                                    Model model) {
        // Lógica para registrar um novo usuário
        try {
            usuarioServico.registrarNovoUsuario(newUsername, newPassword);
            // Redirecionar para a página de login se o registro for bem-sucedido
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            // Se o nome de usuário já estiver em uso, adicionar mensagem de erro ao modelo
            model.addAttribute("erroRegistro", e.getMessage());
            return "registro";
        }
    }
}
