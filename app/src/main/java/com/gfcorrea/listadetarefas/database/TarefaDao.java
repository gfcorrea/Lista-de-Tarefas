package com.gfcorrea.listadetarefas.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TarefaDao {

    @Query("SELECT * FROM tarefa where concluido = 0 order by data")
    List<TarefaModel> getAllAtivos();

    @Query("SELECT * FROM tarefa where concluido = 1 order by data desc")
    List<TarefaModel> getAllConcluidos();

    @Query("SELECT * FROM tarefa where concluido = 0 and data < :hoje order by data")
    List<TarefaModel> getAtrasados(long hoje);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(TarefaModel... tarefaModel);

    @Delete
    void delete(TarefaModel tarefaModel);

}
