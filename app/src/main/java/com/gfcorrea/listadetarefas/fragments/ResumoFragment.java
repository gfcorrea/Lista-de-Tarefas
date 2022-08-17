package com.gfcorrea.listadetarefas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gfcorrea.listadetarefas.R;
import com.gfcorrea.listadetarefas.databinding.FragmentResumoBinding;


public class ResumoFragment extends Fragment {

    private FragmentResumoBinding binding;

    public ResumoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResumoBinding.inflate(getLayoutInflater());

        return binding.getRoot();
    }
}