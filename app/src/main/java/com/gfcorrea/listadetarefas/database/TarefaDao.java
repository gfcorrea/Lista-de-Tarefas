package com.gfcorrea.listadetarefas.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
//
@Dao
public interface TarefaDao {

    @Query("SELECT * FROM tarefa")
    List<TarefaModel> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(TarefaModel... tarefaModel);

    @Delete
    void delete(TarefaModel tarefaModel);

}
