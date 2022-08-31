package com.gfcorrea.listadetarefas.fragments;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.gfcorrea.listadetarefas.R;
import com.gfcorrea.listadetarefas.adapter.ListaAtivosAdapter;
import com.gfcorrea.listadetarefas.database.AppDatabase;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_ativo)
public class AtivoFragment extends Fragment {

    @ViewById
    RecyclerView recylcerListaAtivos;

    @AfterViews
    public void afterViews(){
        ListaAtivosAdapter adapter = new ListaAtivosAdapter(AppDatabase.getInstance().tarefaDao().getAllAtivos());
        recylcerListaAtivos.setAdapter(adapter);
    }

}