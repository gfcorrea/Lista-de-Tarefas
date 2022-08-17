package com.gfcorrea.listadetarefas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gfcorrea.listadetarefas.databinding.FragmentHomeBinding;

//
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        //Em um fragment devemos usar o getChildFragmentManager
        NavHostFragment navHostFragment = (NavHostFragment)  getChildFragmentManager()
                .findFragmentById(R.id.nav_host_view);
        NavController navController = navHostFragment.getNavController();

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                navController.getGraph()
        ).build();

        NavigationUI.setupActionBarWithNavController((AppCompatActivity) this.getActivity(), navController, appBarConfiguration);

        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController);

        return binding.getRoot();
    }



}