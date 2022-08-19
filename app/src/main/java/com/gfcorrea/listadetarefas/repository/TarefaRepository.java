package com.gfcorrea.listadetarefas.repository;

import com.gfcorrea.listadetarefas.database.AppDatabase;
import com.gfcorrea.listadetarefas.database.TarefaModel;

import java.util.Calendar;
import java.util.List;

public class TarefaRepository {

    public void inserir(TarefaModel tarefa) {
        AppDatabase.getInstance().tarefaDao().insertAll(tarefa);
    }

    public List<TarefaModel> getListaAtivos() {
        return AppDatabase.getInstance().tarefaDao().getAllAtivos();
    }

    public List<TarefaModel> getListaConcluidos() {
        return AppDatabase.getInstance().tarefaDao().getAllConcluidos();
    }

    public int getTotalAtivos(){
        return AppDatabase.getInstance().tarefaDao().getAllAtivos().size();
    }

    public int getTotalConcluidos(){
        return AppDatabase.getInstance().tarefaDao().getAllConcluidos().size();
    }

    public int getTotalAtrasados(){
        return AppDatabase.getInstance().tarefaDao().getAtrasados( Calendar.getInstance().getTimeInMillis() ).size();
    }

}
