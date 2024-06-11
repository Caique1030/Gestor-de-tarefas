package caique.silva.GestaoDeTarefas.Controllers;

import caique.silva.GestaoDeTarefas.Dados.Tarefa;
import caique.silva.GestaoDeTarefas.Serviços.CategoriaServico;
import caique.silva.GestaoDeTarefas.Serviços.TarefaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tarefas")
public class TerefaController {
    @Autowired
    private TarefaServico tarefaServico;
    @Autowired
    private CategoriaServico categoriaServico;

    @GetMapping
    public String listarTarefas(Model model) {
        model.addAttribute("tarefas", tarefaServico.ListarTarefas());
        return "tarefas/listatarefas";
    }

    @GetMapping("/nova")
    public String nova(Model model) {
        model.addAttribute("tarefa", new Tarefa());
        model.addAttribute("categorias", categoriaServico.ListarTodos());
        return "tarefas/formnova";
    }

    @PostMapping
    public String salvar(@ModelAttribute Tarefa tarefa) {
        tarefaServico.salvar(tarefa);
        return "redirect:/tarefas";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        tarefaServico.excluirTarefa(id);
        return "redirect:/tarefas";
    }

}
