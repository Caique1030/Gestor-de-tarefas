package caique.silva.GestaoDeTarefas.Controllers;

import caique.silva.GestaoDeTarefas.Dados.Categoria;
import caique.silva.GestaoDeTarefas.Serviços.CategoriaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaServico categoriaServico;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", categoriaServico.ListarTodos());
        return "categorias/listacategoria";
    }

    @GetMapping("/nova")
    public String nova(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/formnova";
    }
    @GetMapping("/editar/{id}")
    public String mostrarFormEditarCategoria(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaServico.findById(id);
        if (categoria != null) {
            model.addAttribute("categoria", categoria);
            return "categorias/form";
        }
        return "redirect:/categorias";
    }

    @PostMapping
    public String salvar(@ModelAttribute Categoria categoria) {
        categoriaServico.salvar(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        categoriaServico.excluir(id);
        return "redirect:/categorias";
    }

}
