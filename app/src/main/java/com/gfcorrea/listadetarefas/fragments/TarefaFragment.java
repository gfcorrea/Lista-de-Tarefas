package com.gfcorrea.listadetarefas.fragments;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import com.gfcorrea.listadetarefas.R;
import com.gfcorrea.listadetarefas.databinding.FragmentTarefaBinding;
import com.gfcorrea.listadetarefas.viewmodel.TarefaViewModel;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.Calendar;



public class TarefaFragment extends Fragment {
    private FragmentTarefaBinding binding;
    private TarefaViewModel tarefaViewModel;
    private Calendar calendar;

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

        tarefaViewModel = new ViewModelProvider(this).get(TarefaViewModel.class);
        calendar = Calendar.getInstance();

        binding.tvHoraTarefa.setText(DateFormat.format("HH:mm", calendar));
        binding.tvDataTarefa.setText(DateFormat.format("dd/MM/yyyy", calendar));

        binding.btnSalvarTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tarefaViewModel.setDescricao(binding.txtDescricao.getText().toString());
                tarefaViewModel.salvarTarefa();

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

                        calendar.set(0, 0, 0, hourSelect, minuteSelect,0);

                        tarefaViewModel.setTimeCalendar(calendar);

                        binding.tvHoraTarefa.setText(DateFormat.format("HH:mm", calendar));
                    }
                }
                , 12, 0, true);

        timePickerDialog.updateTime(12, 0);
        timePickerDialog.show();
    }

    private void ShowDateDialog() {

        MaterialDatePicker<Long> materialDatePicker = MaterialDatePicker.Builder.datePicker().setTitleText("Selecione uma Data").build();

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onPositiveButtonClick(Object selection) {

                if(materialDatePicker.getSelection() != null) {
                    calendar.setTimeInMillis(materialDatePicker.getSelection());

                    tarefaViewModel.setDateCalendar(calendar);

                    binding.tvDataTarefa.setText(DateFormat.format("dd/MM/yyyy", calendar));
                }

            }
        });

        materialDatePicker.show(getChildFragmentManager(), "TAG");
    }
}