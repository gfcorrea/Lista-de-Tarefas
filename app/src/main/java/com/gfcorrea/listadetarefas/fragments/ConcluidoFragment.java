package com.gfcorrea.listadetarefas.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gfcorrea.listadetarefas.adapter.ListaConcluidosAdapter;
import com.gfcorrea.listadetarefas.database.AppDatabase;
import com.gfcorrea.listadetarefas.databinding.FragmentConcluidoBinding;

import org.androidannotations.annotations.EFragment;

@EFragment
public class ConcluidoFragment extends Fragment {

    public ConcluidoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentConcluidoBinding binding = FragmentConcluidoBinding.inflate(getLayoutInflater());

        ListaConcluidosAdapter adapter = new ListaConcluidosAdapter(AppDatabase.getInstance().tarefaDao().getAllConcluidos());
        binding.recylcerListaConcluido.setAdapter(adapter);

        return binding.getRoot();
    }
}