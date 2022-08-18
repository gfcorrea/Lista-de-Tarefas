package com.gfcorrea.listadetarefas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gfcorrea.listadetarefas.adapter.ListaAtivosAdapter;
import com.gfcorrea.listadetarefas.database.AppDatabase;
import com.gfcorrea.listadetarefas.database.TarefaModel;
import com.gfcorrea.listadetarefas.databinding.FragmentAtivoBinding;

import java.util.List;


public class AtivoFragment extends Fragment {

    private FragmentAtivoBinding binding;
    private List<TarefaModel> lista;


    public AtivoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAtivoBinding.inflate(getLayoutInflater());

        lista = AppDatabase.getInstance().tarefaDao().getAllAtivos();

        ListaAtivosAdapter adapter = new ListaAtivosAdapter(lista);
        binding.recylcerListaAtivos.setAdapter(adapter);

        return binding.getRoot();
    }
}