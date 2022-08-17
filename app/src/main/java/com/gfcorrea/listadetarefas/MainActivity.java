package com.gfcorrea.listadetarefas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.gfcorrea.listadetarefas.database.AppDatabase;
import com.gfcorrea.listadetarefas.database.TarefaModel;
import com.gfcorrea.listadetarefas.databinding.ActivityMainBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppDatabase.setContexto(getApplicationContext());

        popularLista();
    }

    public void popularLista(){

        TarefaModel tarefa = new TarefaModel();
        tarefa.setDescricao("Tarefa 1");
        tarefa.setData( converteData("01/08/2023") );
        tarefa.setConcluido(false);

        AppDatabase.getInstance().tarefaDao().insertAll(tarefa);

        tarefa = new TarefaModel();
        tarefa.setDescricao("Tarefa 2");
        tarefa.setData( converteData("01/08/2023") );
        tarefa.setConcluido(false);

        AppDatabase.getInstance().tarefaDao().insertAll(tarefa);

        tarefa = new TarefaModel();
        tarefa.setDescricao("Tarefa 3");
        tarefa.setData( converteData("01/04/2021") );
        tarefa.setConcluido(false);

        AppDatabase.getInstance().tarefaDao().insertAll(tarefa);

        tarefa = new TarefaModel();
        tarefa.setDescricao("Tarefa 4");
        tarefa.setData( converteData("10/12/2022") );
        tarefa.setConcluido(false);

        AppDatabase.getInstance().tarefaDao().insertAll(tarefa);

        tarefa = new TarefaModel();
        tarefa.setDescricao("Tarefa 5");
        tarefa.setData( converteData("01/12/2021") );
        tarefa.setConcluido(true);

        AppDatabase.getInstance().tarefaDao().insertAll(tarefa);
    }

    public long converteData(String data){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada = null;

        try {
            dataFormatada = formato.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dataFormatada.getTime();
    }

}
