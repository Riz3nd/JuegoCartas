package com.riz3nd.juegocartas.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.riz3nd.juegocartas.R;
import com.riz3nd.juegocartas.databinding.FragmentInitBinding;

public class InitFragment extends Fragment implements View.OnClickListener {
    private FragmentInitBinding binding;
    private NavController navController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInitBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(requireView());
        binding.btnFacil.setOnClickListener(this);
        binding.btnMedio.setOnClickListener(this);
        binding.btnMedio.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
             case R.id.btnFacil:
                 navController.navigate(R.id.action_initFragment2_to_gameFragment);
                break;
            case R.id.btnMedio:
                navController.navigate(R.id.action_initFragment2_to_gameFragment);
                break;
            case R.id.btnDificil:
                navController.navigate(R.id.action_initFragment2_to_gameFragment);
                break;
        }
    }
}