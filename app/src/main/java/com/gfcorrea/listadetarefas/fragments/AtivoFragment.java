package com.gfcorrea.listadetarefas.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gfcorrea.listadetarefas.adapter.ListaAtivosAdapter;
import com.gfcorrea.listadetarefas.database.AppDatabase;
import com.gfcorrea.listadetarefas.database.TarefaModel;
import com.gfcorrea.listadetarefas.databinding.FragmentAtivoBinding;

import org.androidannotations.annotations.EFragment;

import java.util.List;

@EFragment
public class AtivoFragment extends Fragment {


    public AtivoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentAtivoBinding binding = FragmentAtivoBinding.inflate(getLayoutInflater());

        List<TarefaModel> lista = AppDatabase.getInstance().tarefaDao().getAllAtivos();

        ListaAtivosAdapter adapter = new ListaAtivosAdapter(lista);
        binding.recylcerListaAtivos.setAdapter(adapter);

        return binding.getRoot();
    }
}