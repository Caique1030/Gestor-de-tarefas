package caique.silva.GestaoDeTarefas.Controllers;

import caique.silva.GestaoDeTarefas.Dados.Tarefa;
import caique.silva.GestaoDeTarefas.Serviços.CategoriaServico;
import caique.silva.GestaoDeTarefas.Serviços.TarefaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {
    @Autowired
    private TarefaServico tarefaServico;
    @Autowired
    private CategoriaServico categoriaServico;

    @GetMapping("/listatarefas")
    public String listatarefas(Model model) {
        List<Tarefa> tarefas = tarefaServico.getAllTarefas();
        model.addAttribute("tarefas", tarefas);
        return "tarefas/listatarefas";
    }

    @GetMapping("/formnova")
    public String nova(Model model) {
        model.addAttribute("tarefa", new Tarefa());
        model.addAttribute("categorias", categoriaServico.ListarTodos());
        return "tarefas/formnova";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormEditarTarefa(@PathVariable Long id, Model model) {
        Optional<Tarefa> tarefa = tarefaServico.findById(id);
        if (tarefa.isPresent()) {
            model.addAttribute("tarefa", tarefa.get());
            model.addAttribute("categorias", categoriaServico.ListarTodos());
            return "tarefas/formnova";
        }
        return "redirect:/tarefas";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Tarefa tarefa) {
        tarefaServico.salvar(tarefa);
        return "redirect:/tarefas/listatarefas";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        tarefaServico.deleteById(id);
        return "redirect:/tarefas/listatarefas";
    }
}
