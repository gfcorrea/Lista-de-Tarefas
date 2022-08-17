package com.gfcorrea.listadetarefas.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tarefa")
public class TarefaModel {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "descricao")
    private String descricao;

    @ColumnInfo(name = "data")
    private long data;

    @ColumnInfo(name = "hora")
    private long hora;

    @ColumnInfo(name = "concluido")
    private boolean concluido;

    public TarefaModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public long getHora() {
        return hora;
    }

    public void setHora(long hora) {
        this.hora = hora;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
}
