package com.gfcorrea.listadetarefas.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gfcorrea.listadetarefas.R;
import com.gfcorrea.listadetarefas.database.TarefaModel;
import com.gfcorrea.listadetarefas.databinding.RecyclerItemTarefaAtivaBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class ListaAtivosAdapter extends RecyclerView.Adapter<ListaAtivosAdapter.ListaAtivosHolder> {

    private List<TarefaModel> listaTarefas;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

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


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ListaAtivosHolder holder, int position) {

        holder.binding.lblDescricao.setText(listaTarefas.get(position).getDescricao());
        holder.binding.lblData.setText( simpleDateFormat.format(listaTarefas.get(position).getData()) );

        if(listaTarefas.get(position).getData() < Calendar.getInstance().getTimeInMillis() ){
            holder.binding.CVAtivos.setBackgroundResource(R.color.red);
        }else{
            holder.binding.CVAtivos.setBackgroundResource(R.color.grey);
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
        }
    }

}
