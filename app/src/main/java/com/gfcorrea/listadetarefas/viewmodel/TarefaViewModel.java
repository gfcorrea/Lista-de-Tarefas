package com.gfcorrea.listadetarefas.viewmodel;

import androidx.lifecycle.ViewModel;

import com.gfcorrea.listadetarefas.database.TarefaModel;

public class TarefaViewModel extends ViewModel {

    private final TarefaModel tarefa = new TarefaModel();

    private long dataSelecionada = 0;

    public long getDataSelecionada() {
        return dataSelecionada;
    }

    public void setDataSelecionada(long dataSelecionada) {
        this.dataSelecionada = dataSelecionada;
    }



}
