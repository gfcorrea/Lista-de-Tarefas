package com.gfcorrea.listadetarefas.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gfcorrea.listadetarefas.R;
import com.gfcorrea.listadetarefas.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentHomeBinding binding = FragmentHomeBinding.inflate(getLayoutInflater());

        //Em um fragment devemos usar o getChildFragmentManager
        NavHostFragment navHostFragment = (NavHostFragment)  getChildFragmentManager().findFragmentById(R.id.nav_host_view);
        NavController navController = navHostFragment.getNavController();

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                navController.getGraph()
        ).build();

        NavigationUI.setupActionBarWithNavController((AppCompatActivity)  getActivity(), navController, appBarConfiguration);

        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController);

        return binding.getRoot();
    }



}