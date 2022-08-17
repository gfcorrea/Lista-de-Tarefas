package com.gfcorrea.listadetarefas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gfcorrea.listadetarefas.adapter.ListaConcluidosAdapter;
import com.gfcorrea.listadetarefas.database.AppDatabase;
import com.gfcorrea.listadetarefas.databinding.FragmentConcluidoBinding;


public class ConcluidoFragment extends Fragment {
    private FragmentConcluidoBinding binding;

    public ConcluidoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentConcluidoBinding.inflate(getLayoutInflater());

        ListaConcluidosAdapter adapter = new ListaConcluidosAdapter(AppDatabase.getInstance().tarefaDao().getAllConcluidos());
        binding.recylcerListaConcluido.setAdapter(adapter);

        return binding.getRoot();
    }
}