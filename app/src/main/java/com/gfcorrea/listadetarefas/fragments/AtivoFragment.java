package com.gfcorrea.listadetarefas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gfcorrea.listadetarefas.R;
import com.gfcorrea.listadetarefas.databinding.FragmentAtivoBinding;


public class AtivoFragment extends Fragment {

    private FragmentAtivoBinding binding;
//
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

        return binding.getRoot();
    }
}