package com.gfcorrea.listadetarefas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.novaTarefa:
                Navigation.findNavController(binding.getRoot().getViewById(R.id.nav_global_view) ).navigate(R.id.action_homeFragment_to_tarefaFragment);
                break;
        }
        return true;
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
