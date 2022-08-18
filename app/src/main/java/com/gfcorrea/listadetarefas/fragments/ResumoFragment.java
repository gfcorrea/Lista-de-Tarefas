package com.gfcorrea.listadetarefas.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.gfcorrea.listadetarefas.databinding.FragmentResumoBinding;
import com.gfcorrea.listadetarefas.repository.TarefaRepository;
import com.github.mikephil.charting.components.Legend;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResumoBinding.inflate(getLayoutInflater());


        setupPieChart();
        loadPieData();

        return binding.getRoot();
    }

    public void setupPieChart(){
        binding.pieChartResumo.setDrawHoleEnabled(true);
        binding.pieChartResumo.setUsePercentValues(true);
        binding.pieChartResumo.setEntryLabelTextSize(12);
        binding.pieChartResumo.setEntryLabelColor(Color.BLACK);
        binding.pieChartResumo.setCenterText("Resumo das Tarefas");
        binding.pieChartResumo.setCenterTextSize(16);
        binding.pieChartResumo.getDescription().setEnabled(false);

        binding.pieChartResumo.getLegend().setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        binding.pieChartResumo.getLegend().setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        binding.pieChartResumo.getLegend().setOrientation(Legend.LegendOrientation.VERTICAL);
        binding.pieChartResumo.getLegend().setDrawInside(false);
        binding.pieChartResumo.getLegend().setEnabled(false);
    }

    public void loadPieData(){
        TarefaRepository tarefaRepository = new TarefaRepository();

        float totAtrasados  = tarefaRepository.getTotalAtrasados();
        float totAtivos     = tarefaRepository.getTotalAtivos() - totAtrasados;
        float totConcluidos = tarefaRepository.getTotalConcluidos();

        float totGeral = totAtivos + totConcluidos + totAtrasados;

        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry((totAtivos * 100)/totGeral, "Ativos"));
        entries.add(new PieEntry((totConcluidos * 100)/totGeral, "Concluídos"));
        entries.add(new PieEntry((totAtrasados * 100)/totGeral, "Atrasados"));

        ArrayList<Integer> colors = new ArrayList<>();
        for(int color: ColorTemplate.MATERIAL_COLORS){
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