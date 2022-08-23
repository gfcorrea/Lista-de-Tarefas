package com.gfcorrea.listadetarefas.adapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.gfcorrea.listadetarefas.R;
import com.gfcorrea.listadetarefas.database.TarefaModel;
import com.gfcorrea.listadetarefas.databinding.RecyclerItemTarefaAtivaBinding;
import com.gfcorrea.listadetarefas.fragments.TarefaFragment;

import android.text.format.DateFormat;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;


public class ListaAtivosAdapter extends RecyclerView.Adapter<ListaAtivosAdapter.ListaAtivosHolder> {

    private final List<TarefaModel> listaTarefas;

    public ListaAtivosAdapter(List<TarefaModel> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    @NonNull
    @Override
    public ListaAtivosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListaAtivosHolder(
                RecyclerItemTarefaAtivaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        );
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ListaAtivosHolder holder, int position) {
        holder.binding.lblDescricao.setText(listaTarefas.get(position).getDescricao());
        holder.binding.lblData.setText( DateFormat.format("dd/MM/yyyy   HH:mm", listaTarefas.get(position).getData()) );

        if(listaTarefas.get(position).getData() < Calendar.getInstance().getTimeInMillis() ){
            holder.binding.CVAtivos.setBackgroundResource(R.color.red);
        }else{
            holder.binding.CVAtivos.setBackgroundResource(R.color.purple_500);
        }
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putLong("tarefa_id",  listaTarefas.get( getAdapterPosition() ).getId()  );

                    Navigation.findNavController( binding.getRoot().getRootView().findViewById(R.id.nav_global_view) ).navigate(R.id.action_homeFragment_to_tarefaFragment, bundle);
                }
            });
        }
    }

}
