package caique.silva.GestaoDeTarefas.Serviços;

import caique.silva.GestaoDeTarefas.Dados.Tarefa;
import caique.silva.GestaoDeTarefas.Repositorios.TarefaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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
    public void excluirTarefa(Long id) {
        tarefaRepositorio.deleteById(id);
    }

}
