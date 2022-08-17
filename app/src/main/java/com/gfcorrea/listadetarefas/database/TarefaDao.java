package com.gfcorrea.listadetarefas.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TarefaDao {

    @Query("SELECT * FROM tarefa where concluido = 0")
    List<TarefaModel> getAllAtivos();

    @Query("SELECT * FROM tarefa where concluido = 1")
    List<TarefaModel> getAllConcluidos();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(TarefaModel... tarefaModel);

    @Delete
    void delete(TarefaModel tarefaModel);

}
