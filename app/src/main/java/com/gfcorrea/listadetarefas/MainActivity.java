package com.gfcorrea.listadetarefas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.gfcorrea.listadetarefas.database.AppDatabase;
import com.gfcorrea.listadetarefas.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppDatabase.setContexto(getApplicationContext());
    }

    /*
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
*/
}
