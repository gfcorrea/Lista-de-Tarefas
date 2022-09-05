package com.gfcorrea.listadetarefas.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gfcorrea.listadetarefas.repository.TarefaRepository;

public class ResumoViewModel extends ViewModel {

    private MutableLiveData<Integer> numFuturas;
    private MutableLiveData<Integer> numConcluidos;
    private MutableLiveData<Integer> numAtrasados;


    public void atualizaValores(TarefaRepository tarefaRepository){
        numFuturas.setValue(tarefaRepository.getTotalFuturas());
        numConcluidos.setValue(tarefaRepository.getTotalConcluidos());
        numAtrasados.setValue(tarefaRepository.getTotalAtrasados());
    }

    public MutableLiveData<Integer> getNumFuturas() {
        if(numFuturas == null){
            numFuturas = new MutableLiveData<>();
            numFuturas.setValue(0);
        }
        return numFuturas;
    }

    public MutableLiveData<Integer> getNumConcluidos() {
        if(numConcluidos == null){
            numConcluidos = new MutableLiveData<>();
            numConcluidos.setValue(0);
        }
        return numConcluidos;
    }

    public MutableLiveData<Integer> getNumAtrasados() {
        if(numAtrasados == null){
            numAtrasados = new MutableLiveData<>();
            numAtrasados.setValue(0);
        }
        return numAtrasados;
    }
}
