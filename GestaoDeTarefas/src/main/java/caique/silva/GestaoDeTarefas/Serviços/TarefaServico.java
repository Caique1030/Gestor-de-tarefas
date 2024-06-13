package caique.silva.GestaoDeTarefas.Serviços;

import caique.silva.GestaoDeTarefas.Dados.Tarefa;
import caique.silva.GestaoDeTarefas.Repositorios.TarefaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaServico {
    @Autowired
    private TarefaRepositorio tarefaRepositorio;

    public List<Tarefa> ListarTarefas(){
        return tarefaRepositorio.findAll();
    }
    public Tarefa salvar(Tarefa tarefa){
        return tarefaRepositorio.save(tarefa);
    }

    public void deleteById(Long id) {
        tarefaRepositorio.deleteById(id);
    }

    public List<Tarefa> getAllTarefas() {
        return tarefaRepositorio.findAll();
    }


    public Optional<Tarefa> findById(Long id) {
        return tarefaRepositorio.findById(id);
    }
}
