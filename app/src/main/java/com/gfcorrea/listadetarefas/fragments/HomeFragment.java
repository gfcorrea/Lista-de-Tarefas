package com.gfcorrea.listadetarefas.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.gfcorrea.listadetarefas.R;
import com.gfcorrea.listadetarefas.databinding.FragmentHomeBinding;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_home)
public class HomeFragment extends Fragment {

    @ViewById
    Button btnNovaTarefa;



    @AfterViews
    public void afterViews(){

    }

    @Click
    public void btnNovaTarefaClicked(View view){
        Toast.makeText(view.getContext(), "Teste", Toast.LENGTH_SHORT).show();
    }

}