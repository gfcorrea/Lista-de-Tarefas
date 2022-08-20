package com.gfcorrea.listadetarefas.fragments;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import com.gfcorrea.listadetarefas.MainActivity;
import com.gfcorrea.listadetarefas.R;
import com.gfcorrea.listadetarefas.database.TarefaModel;
import com.gfcorrea.listadetarefas.databinding.FragmentTarefaBinding;
import com.gfcorrea.listadetarefas.repository.TarefaRepository;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TarefaFragment extends Fragment {
    private FragmentTarefaBinding binding;
    private final TarefaRepository tarefaRepository = new TarefaRepository();
    private long dataSelecionada = 0;
    private int horaSelecionada = 0, minutoSelecionado = 0;

    public TarefaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
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

        binding.tvHoraTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowTimeDialog();
            }
        });


        return binding.getRoot();
    }

    private void ShowTimeDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                getContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourSelect, int minuteSelect) {
                        horaSelecionada = hourSelect;
                        minutoSelecionado = minuteSelect;

                        Calendar calendar = Calendar.getInstance();
                        calendar.set(0, 0, 0, hourSelect, minuteSelect);

                        binding.tvHoraTarefa.setText(DateFormat.format("hh:mm aa", calendar));
                    }
                }
                , 12, 0, false);

        timePickerDialog.updateTime(horaSelecionada, minutoSelecionado);
        timePickerDialog.show();
    }

    private void ShowDateDialog() {

        MaterialDatePicker<Long> materialDatePicker = MaterialDatePicker.Builder.datePicker().setTitleText("Selecione uma Data").build();

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onPositiveButtonClick(Object selection) {
                dataSelecionada = materialDatePicker.getSelection();

                String dateString = new SimpleDateFormat("dd/MM/yyyy").format(new Date(dataSelecionada));
                binding.tvDataTarefa.setText(dateString);
            }
        });

        materialDatePicker.show(getChildFragmentManager(), "TAG");
    }
}