package com.gfcorrea.listadetarefas.fragments;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.gfcorrea.listadetarefas.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_home)
public class HomeFragment extends Fragment {

    @ViewById
    BottomNavigationView bottomNavigationView;

    @AfterViews
    public void afterViews(){
        //Em um fragment devemos usar o getChildFragmentManager
        NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.nav_host_view);
        NavController navController = navHostFragment.getNavController();

        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Click
    public void btnNovaTarefaClicked(){
        Navigation.findNavController(  getActivity().findViewById(R.id.nav_global_view)  ).navigate(R.id.action_homeFragment_to_tarefaFragment);
    }

}