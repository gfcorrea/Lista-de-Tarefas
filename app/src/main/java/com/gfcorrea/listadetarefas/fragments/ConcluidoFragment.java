package com.gfcorrea.listadetarefas.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gfcorrea.listadetarefas.R;
import com.gfcorrea.listadetarefas.adapter.ListaConcluidosAdapter;
import com.gfcorrea.listadetarefas.database.AppDatabase;
import com.gfcorrea.listadetarefas.databinding.FragmentConcluidoBinding;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_concluido)
public class ConcluidoFragment extends Fragment {

    @ViewById
    RecyclerView recylcerListaConcluido;

    @AfterViews
    public void afterView() {
        ListaConcluidosAdapter adapter = new ListaConcluidosAdapter(AppDatabase.getInstance().tarefaDao().getAllConcluidos());
        recylcerListaConcluido.setAdapter(adapter);
    }
}