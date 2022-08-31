package com.gfcorrea.listadetarefas.fragments;

import android.graphics.Color;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.gfcorrea.listadetarefas.R;
import com.gfcorrea.listadetarefas.viewmodel.ResumoViewModel;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EFragment(R.layout.fragment_resumo)
public class ResumoFragment extends Fragment {
    @ViewById
    TextView TvNumTarefasFuturas;

    @ViewById
    TextView TvNumTarefasConcluidas;

    @ViewById
    TextView TvNumTarefasAtrasadas;

    @ViewById
    PieChart pieChartResumo;

    @AfterViews
    public void afterViews(){

        final ResumoViewModel resumoViewModel = new ViewModelProvider(this).get(ResumoViewModel.class);


        final Observer<Integer> numFuturasObserver = (
                s -> TvNumTarefasFuturas.setText(String.valueOf(resumoViewModel.getNumFuturas().getValue()))
        );

        final Observer<Integer> numConcluidosObserver = (
                s -> TvNumTarefasConcluidas.setText(String.valueOf(resumoViewModel.getNumConcluidos().getValue()))
        );

        final Observer<Integer> numAtrasadosObserver = (
                s -> TvNumTarefasAtrasadas.setText(String.valueOf(resumoViewModel.getNumAtrasados().getValue() ))
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
    }

    public void setupPieChart() {
        pieChartResumo.setDrawHoleEnabled(true);
        pieChartResumo.setUsePercentValues(true);
        pieChartResumo.setEntryLabelTextSize(12);
        pieChartResumo.setEntryLabelColor(Color.BLACK);
        pieChartResumo.setCenterText("Tarefas");
        pieChartResumo.setCenterTextSize(16);
        pieChartResumo.getDescription().setEnabled(false);
        pieChartResumo.getLegend().setEnabled(true);
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
        data.setValueFormatter(new PercentFormatter(pieChartResumo));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);

        pieChartResumo.setData(data);
        pieChartResumo.invalidate();
    }
}