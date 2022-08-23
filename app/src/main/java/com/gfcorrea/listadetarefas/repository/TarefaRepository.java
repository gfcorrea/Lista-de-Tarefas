package com.gfcorrea.listadetarefas.repository;

import com.gfcorrea.listadetarefas.database.AppDatabase;
import com.gfcorrea.listadetarefas.database.TarefaDao;
import com.gfcorrea.listadetarefas.database.TarefaModel;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class TarefaRepository {
    TarefaDao tarefaDao = AppDatabase.getInstance().tarefaDao();

    public void inserir(TarefaModel tarefa) {
       tarefaDao.insertAll(tarefa);
    }

    public TarefaModel getById(long id){
        return tarefaDao.getById(id);
    }

    public List<TarefaModel> getListaFuturas() {
        return tarefaDao.getAllFuturas(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());
    }

    public List<TarefaModel> getListaConcluidos() {
        return tarefaDao.getAllConcluidos();
    }

    public int getTotalFuturas(){
        return tarefaDao.getAllFuturas(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis()).size();
    }

    public int getTotalConcluidos(){
        return tarefaDao.getAllConcluidos().size();
    }

    public int getTotalAtrasados(){
        return tarefaDao.getAtrasados( Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis() ).size();
    }

    public void excluirTarefa(TarefaModel tarefa){
      tarefaDao.delete(tarefa);
    }

}
