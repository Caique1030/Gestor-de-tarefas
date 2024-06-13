package caique.silva.GestaoDeTarefas.Serviços;

import caique.silva.GestaoDeTarefas.Dados.Categoria;
import caique.silva.GestaoDeTarefas.Repositorios.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServico {

    @Autowired
    private CategoriaRepositorio   categoriaRepositorio;

    public List<Categoria> ListarTodos(){
        return categoriaRepositorio.findAll();
    }
    public Categoria salvar(Categoria categoria){
        return categoriaRepositorio.save(categoria);
    }
    public void excluir(Long id){
        categoriaRepositorio.deleteById(id);
    }

    public Categoria findById(Long id) {
        return null;
    }
}
