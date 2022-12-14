package com.gfcorrea.listadetarefas.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gfcorrea.listadetarefas.R;
import com.gfcorrea.listadetarefas.database.TarefaModel;
import com.gfcorrea.listadetarefas.databinding.RecyclerItemTarefaConcluidaBinding;

import java.text.SimpleDateFormat;
import java.util.List;

public class ListaConcluidosAdapter extends RecyclerView.Adapter<ListaConcluidosAdapter.ListaConcluidosHolder> {

    private List<TarefaModel> listaConcluidos;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ListaConcluidosAdapter(List<TarefaModel> listaConcluidos) {
        this.listaConcluidos = listaConcluidos;
    }

    @NonNull
    @Override
    public ListaConcluidosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListaConcluidosHolder(
                RecyclerItemTarefaConcluidaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ListaConcluidosHolder holder, int position) {
        holder.binding.lblDescricaoConcluido.setText(listaConcluidos.get(position).getDescricao());

        holder.binding.lblDataConcluidos.setText( simpleDateFormat.format(listaConcluidos.get(position).getData()) );

        holder.binding.CVConcluidos.setBackgroundResource(R.color.purple_500);
    }


    @Override
    public int getItemCount() {
        return listaConcluidos.size();
    }

    public class ListaConcluidosHolder extends RecyclerView.ViewHolder{
        RecyclerItemTarefaConcluidaBinding binding;

        public ListaConcluidosHolder(@NonNull RecyclerItemTarefaConcluidaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
