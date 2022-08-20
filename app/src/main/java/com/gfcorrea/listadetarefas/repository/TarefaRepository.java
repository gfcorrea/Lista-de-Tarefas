package com.gfcorrea.listadetarefas.repository;

import com.gfcorrea.listadetarefas.database.AppDatabase;
import com.gfcorrea.listadetarefas.database.TarefaModel;

import java.util.Calendar;
import java.util.List;

public class TarefaRepository {

    public void inserir(TarefaModel tarefa) {
        AppDatabase.getInstance().tarefaDao().insertAll(tarefa);
    }

    public List<TarefaModel> getListaFuturas() {
        return AppDatabase.getInstance().tarefaDao().getAllFuturas(Calendar.getInstance().getTimeInMillis());
    }

    public List<TarefaModel> getListaConcluidos() {
        return AppDatabase.getInstance().tarefaDao().getAllConcluidos();
    }

    public int getTotalFuturas(){
        return AppDatabase.getInstance().tarefaDao().getAllFuturas(Calendar.getInstance().getTimeInMillis()).size();
    }

    public int getTotalConcluidos(){
        return AppDatabase.getInstance().tarefaDao().getAllConcluidos().size();
    }

    public int getTotalAtrasados(){
        return AppDatabase.getInstance().tarefaDao().getAtrasados( Calendar.getInstance().getTimeInMillis() ).size();
    }

}
