package com.gfcorrea.listadetarefas.repository;

import com.gfcorrea.listadetarefas.database.AppDatabase;
import com.gfcorrea.listadetarefas.database.TarefaModel;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class TarefaRepository {

    public void inserir(TarefaModel tarefa) {
        AppDatabase.getInstance().tarefaDao().insertAll(tarefa);
    }

    public TarefaModel getById(long id){
        return AppDatabase.getInstance().tarefaDao().getById(id);
    }

    public List<TarefaModel> getListaFuturas() {
        return AppDatabase.getInstance().tarefaDao().getAllFuturas(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());
    }

    public List<TarefaModel> getListaConcluidos() {
        return AppDatabase.getInstance().tarefaDao().getAllConcluidos();
    }

    public int getTotalFuturas(){
        return AppDatabase.getInstance().tarefaDao().getAllFuturas(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis()).size();
    }

    public int getTotalConcluidos(){
        return AppDatabase.getInstance().tarefaDao().getAllConcluidos().size();
    }

    public int getTotalAtrasados(){
        return AppDatabase.getInstance().tarefaDao().getAtrasados( Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis() ).size();
    }

}
