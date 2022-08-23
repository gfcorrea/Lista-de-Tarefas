package com.gfcorrea.listadetarefas.viewmodel;

import androidx.lifecycle.ViewModel;

import com.gfcorrea.listadetarefas.database.TarefaModel;
import com.gfcorrea.listadetarefas.repository.TarefaRepository;

import java.util.Calendar;
import java.util.TimeZone;

public class TarefaViewModel extends ViewModel {

    private TarefaModel tarefa = new TarefaModel();
    private final TarefaRepository tarefaRepository = new TarefaRepository();
    private final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

    public void salvarTarefa(){
        tarefa.setData(calendar.getTimeInMillis( ));
        tarefaRepository.inserir(tarefa);
    }

    public void carregarTarefa(long id){
      tarefa = tarefaRepository.getById(id);
      calendar.setTimeInMillis(tarefa.getData());
    }

    public void setDateCalendar(Calendar calendarUser){
        this.calendar.set(Calendar.YEAR, calendarUser.get(Calendar.YEAR));
        this.calendar.set(Calendar.MONTH, calendarUser.get(Calendar.MONTH));
        this.calendar.set(Calendar.DAY_OF_MONTH, calendarUser.get(Calendar.DAY_OF_MONTH));
    }

    public void setTimeCalendar(Calendar calendarUser){
        this.calendar.set(Calendar.HOUR_OF_DAY, calendarUser.get(Calendar.HOUR_OF_DAY));
        this.calendar.set(Calendar.MINUTE, calendarUser.get(Calendar.MINUTE));
        this.calendar.set(Calendar.SECOND, calendarUser.get(Calendar.SECOND));
    }

    public void concluirTarefa(){
        tarefa.setConcluido(true);
        tarefa.setData(calendar.getTimeInMillis());
        tarefaRepository.inserir(tarefa);
    }

    public void excluirTarefa(){
        tarefaRepository.excluirTarefa(tarefa);
    }
    public void setDescricao(String descricao) {
        this.tarefa.setDescricao(descricao);
    }
    
    public String getDescricao() {
        return this.tarefa.getDescricao();
    }
    public long getDateTimeInMillis(){
        return calendar.getTimeInMillis();
    }
}
