package com.gfcorrea.listadetarefas.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gfcorrea.listadetarefas.database.TarefaModel;
import com.gfcorrea.listadetarefas.databinding.RecyclerItemTarefaAtivaBinding;

import java.util.List;


public class ListaAtivosAdapter extends RecyclerView.Adapter<ListaAtivosAdapter.ListaAtivosHolder> {

    private List<TarefaModel> listaTarefas;

    public ListaAtivosAdapter(List<TarefaModel> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    @NonNull
    @Override
    public ListaAtivosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListaAtivosHolder(
                RecyclerItemTarefaAtivaBinding.inflate(LayoutInflater.from( parent.getContext() ), parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAtivosHolder holder, int position) {

        holder.binding.lblDescricao.setText(listaTarefas.get(position).getDescricao());

    }

    @Override
    public int getItemCount() {
        return listaTarefas.size();
    }

    public class ListaAtivosHolder extends RecyclerView.ViewHolder{
        RecyclerItemTarefaAtivaBinding binding;


        public ListaAtivosHolder(@NonNull RecyclerItemTarefaAtivaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
