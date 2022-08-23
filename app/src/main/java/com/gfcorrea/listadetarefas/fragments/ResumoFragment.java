package com.gfcorrea.listadetarefas.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gfcorrea.listadetarefas.databinding.FragmentResumoBinding;
import com.gfcorrea.listadetarefas.viewmodel.ResumoViewModel;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ResumoFragment extends Fragment {

    private FragmentResumoBinding binding;


    public ResumoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResumoBinding.inflate(getLayoutInflater());

        final ResumoViewModel resumoViewModel = new ViewModelProvider(this).get(ResumoViewModel.class);


        final Observer<Integer> numFuturasObserver = (
                s -> binding.TvNumTarefasFuturas.setText(String.valueOf(resumoViewModel.getNumFuturas().getValue()))
        );

        final Observer<Integer> numConcluidosObserver = (
                s -> binding.TvNumTarefasConcluidas.setText(String.valueOf(resumoViewModel.getNumConcluidos().getValue()))
        );

        final Observer<Integer> numAtrasadosObserver = (
                s -> binding.TvNumTarefasAtrasadas.setText(String.valueOf(resumoViewModel.getNumAtrasados().getValue() ))
        );

        resumoViewModel.getNumFuturas().observe( getViewLifecycleOwner(), numFuturasObserver);
        resumoViewModel.getNumConcluidos().observe( getViewLifecycleOwner(), numConcluidosObserver);
        resumoViewModel.getNumAtrasados().observe( getViewLifecycleOwner(), numAtrasadosObserver);

        resumoViewModel.atualizaValores();


        float totAtrasados = resumoViewModel.getNumAtrasados().getValue();
        float totAtivos = resumoViewModel.getNumFuturas().getValue();
        float totConcluidos = resumoViewModel.getNumConcluidos().getValue();

        setupPieChart();
        setPieData(totAtrasados, totAtivos, totConcluidos);

        return binding.getRoot();
    }

    public void setupPieChart() {
        binding.pieChartResumo.setDrawHoleEnabled(true);
        binding.pieChartResumo.setUsePercentValues(true);
        binding.pieChartResumo.setEntryLabelTextSize(12);
        binding.pieChartResumo.setEntryLabelColor(Color.BLACK);
        binding.pieChartResumo.setCenterText("Tarefas");
        binding.pieChartResumo.setCenterTextSize(16);
        binding.pieChartResumo.getDescription().setEnabled(false);
        binding.pieChartResumo.getLegend().setEnabled(true);
    }

    public void setPieData(float totAtrasados, float totAtivos, float totConcluidos) {

        float totGeral = totAtivos + totConcluidos + totAtrasados;

        List<PieEntry> entries = new ArrayList<>();
        if(totConcluidos > 0) entries.add(new PieEntry((totConcluidos * 100) / totGeral, "Concluídos"));
        if(totAtivos > 0) entries.add(new PieEntry((totAtivos * 100) / totGeral, "Futuras"));
        if(totAtrasados > 0 ) entries.add(new PieEntry((totAtrasados * 100) / totGeral, "Atrasados"));

        ArrayList<Integer> colors = new ArrayList<>();
        for (int color : ColorTemplate.MATERIAL_COLORS) {
            colors.add(color);
        }

        PieDataSet dataset = new PieDataSet(entries, "");
        dataset.setColors(colors);

        PieData data = new PieData(dataset);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(binding.pieChartResumo));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);

        binding.pieChartResumo.setData(data);
        binding.pieChartResumo.invalidate();
    }
}