package com.gfcorrea.listadetarefas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gfcorrea.listadetarefas.R;
import com.gfcorrea.listadetarefas.database.AppDatabase;
import com.gfcorrea.listadetarefas.database.TarefaModel;
import com.gfcorrea.listadetarefas.databinding.FragmentTarefaBinding;
import com.gfcorrea.listadetarefas.repository.TarefaRepository;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TarefaFragment extends Fragment {
    private FragmentTarefaBinding binding;
    private TarefaRepository tarefaRepository = new TarefaRepository();
    private long dataSelecionada = 0;

    public TarefaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTarefaBinding.inflate(getLayoutInflater());

        binding.btnSalvarTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TarefaModel tarefa = new TarefaModel();
                tarefa.setDescricao(binding.txtDescricao.getText().toString());
                tarefa.setData(dataSelecionada);

                tarefaRepository.inserir(tarefa);

                Toast.makeText(getContext(), "Salvo com Sucesso!", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.action_tarefaFragment_to_homeFragment);
            }
        });

        binding.tvDataTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowDateDialog();
            }
        });

        return binding.getRoot();
    }

    private void ShowDateDialog() {

        MaterialDatePicker materialDatePicker = MaterialDatePicker.Builder.datePicker().setTitleText("Selecione uma Data").build();

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {

                String longV = materialDatePicker.getSelection().toString();
                dataSelecionada = Long.parseLong(longV);

                String dateString = new SimpleDateFormat("dd/MM/yyyy").format( new Date(dataSelecionada) );
                binding.tvDataTarefa.setText("" + dateString);
            }
        });

        materialDatePicker.show(getChildFragmentManager(), "TAG");
    }
}