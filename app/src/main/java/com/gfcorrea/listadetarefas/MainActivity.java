package com.gfcorrea.listadetarefas;

import androidx.appcompat.app.AppCompatActivity;

import com.gfcorrea.listadetarefas.database.AppDatabase;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @AfterViews
    public void afterViews() {
        AppDatabase.setContexto(getApplicationContext());
    }

}
