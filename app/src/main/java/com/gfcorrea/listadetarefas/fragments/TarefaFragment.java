package com.gfcorrea.listadetarefas.fragments;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.gfcorrea.listadetarefas.R;
import com.gfcorrea.listadetarefas.viewmodel.TarefaViewModel;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Calendar;
import java.util.TimeZone;

@EFragment(R.layout.fragment_tarefa)
public class TarefaFragment extends Fragment {
    private TarefaViewModel tarefaViewModel;
    private Calendar calendar;

    @ViewById
    TextView txtDescricao;

    @ViewById
    TextView tvTitulo;

    @ViewById
    TextView tvHoraTarefa;

    @ViewById
    TextView tvDataTarefa;

    @ViewById
    Button btnConcluido;

    @ViewById
    Button btnExcluirTarefa;

    @ViewById
    Button btnSalvarTarefa;

    @AfterViews
    public void afterViews() {
        tarefaViewModel = new ViewModelProvider(this).get(TarefaViewModel.class);
        calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

        if (getArguments() != null) {

            long id = (long) getArguments().get("tarefa_id");
            tarefaViewModel.carregarTarefa(id);
            calendar.setTimeInMillis(tarefaViewModel.getDateTimeInMillis());
            txtDescricao.setText(tarefaViewModel.getDescricao());
            tvTitulo.setText("Dados da Tarefa");
            btnConcluido.setVisibility(View.VISIBLE);
            btnExcluirTarefa.setVisibility(View.VISIBLE);
        }

        tvHoraTarefa.setText(DateFormat.format("HH:mm", calendar));
        tvDataTarefa.setText(DateFormat.format("dd/MM/yyyy", calendar));
    }

    @Click
    public void btnConcluidoClicked(View view) {
        tarefaViewModel.setDescricao(txtDescricao.getText().toString());
        tarefaViewModel.concluirTarefa();

        Toast.makeText(getContext(), "Concluído com Sucesso!", Toast.LENGTH_SHORT).show();
        Navigation.findNavController(view).navigate(R.id.action_tarefaFragment_to_homeFragment);
    }

    @Click
    public void btnExcluirTarefaClicked(View view) {
        tarefaViewModel.excluirTarefa();
        Toast.makeText(getContext(), "Excluído com Sucesso!", Toast.LENGTH_SHORT).show();
        Navigation.findNavController(view).navigate(R.id.action_tarefaFragment_to_homeFragment);
    }

    @Click
    public void btnSalvarTarefaClicked(View view) {
        tarefaViewModel.setDescricao(txtDescricao.getText().toString());
        tarefaViewModel.salvarTarefa();

        Toast.makeText(getContext(), "Salvo com Sucesso!", Toast.LENGTH_SHORT).show();
        Navigation.findNavController(view).navigate(R.id.action_tarefaFragment_to_homeFragment);
    }

    @Click
    public void tvDataTarefaClicked(View view) {
        ShowDateDialog();
    }

    @Click
    public void tvHoraTarefaClicked(View view) {
        ShowTimeDialog();
    }

    private void ShowTimeDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                getContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourSelect, int minuteSelect) {

                        calendar.set(0, 0, 0, hourSelect, minuteSelect, 0);

                        tarefaViewModel.setTimeCalendar(calendar);

                        tvHoraTarefa.setText(DateFormat.format("HH:mm", calendar));
                    }
                }
                , 12, 0, true);

        timePickerDialog.updateTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
        timePickerDialog.show();
    }

    private void ShowDateDialog() {

        MaterialDatePicker<Long> materialDatePicker = MaterialDatePicker.Builder.datePicker().setTitleText("Selecione uma Data").build();

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onPositiveButtonClick(Object selection) {

                if (materialDatePicker.getSelection() != null) {

                    calendar.setTimeInMillis(materialDatePicker.getSelection());

                    tarefaViewModel.setDateCalendar(calendar);

                    tvDataTarefa.setText(DateFormat.format("dd/MM/yyyy", calendar));
                }

            }
        });
        materialDatePicker.show(getChildFragmentManager(), "TAG");
    }
}