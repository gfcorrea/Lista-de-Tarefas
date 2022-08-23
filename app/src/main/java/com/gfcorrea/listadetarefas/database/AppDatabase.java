package com.gfcorrea.listadetarefas.database;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
        entities = {TarefaModel.class},
        version = 1
)

public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "tarefas";
    private static AppDatabase instance;
    private static Context contexto;

    public abstract TarefaDao tarefaDao();

    public static synchronized AppDatabase getInstance(){
        if(instance == null){
            instance = Room.databaseBuilder(contexto, AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
        }
        return instance;
    }

    public static void setContexto(Context c){
        contexto = c;
    }

}
