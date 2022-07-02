package com.riz3nd.juegocartas.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.riz3nd.juegocartas.R;
import com.riz3nd.juegocartas.databinding.FragmentGameBinding;
import com.riz3nd.juegocartas.entity.Pokemon;

import java.util.LinkedList;
import java.util.List;

public class GameFragment extends Fragment {
    private FragmentGameBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGameBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(requireView());
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_gameFragment_to_initFragment2);
            }
        });

        RecyclerAdapter adapter = new RecyclerAdapter(getContext(), listPoke(16));
        binding.recyclerGame.setLayoutManager(new GridLayoutManager(getContext(),4));
        binding.recyclerGame.setAdapter(adapter);
    }

    private List<Pokemon> listPoke(int num){
        List<Pokemon> listPokemon = new LinkedList<>();
        listPokemon.add(new Pokemon(8,false, getContext().getDrawable(R.drawable.eevee)));
        listPokemon.add(new Pokemon(1,false, getContext().getDrawable(R.drawable.pikachu)));
        listPokemon.add(new Pokemon(2,false, getContext().getDrawable(R.drawable.meowth)));
        listPokemon.add(new Pokemon(8,false, getContext().getDrawable(R.drawable.eevee)));
        listPokemon.add(new Pokemon(4,false, getContext().getDrawable(R.drawable.snorlax)));
        listPokemon.add(new Pokemon(2,false, getContext().getDrawable(R.drawable.meowth)));
        listPokemon.add(new Pokemon(1,false, getContext().getDrawable(R.drawable.pikachu)));
        listPokemon.add(new Pokemon(7,false, getContext().getDrawable(R.drawable.jigglypuff)));
        listPokemon.add(new Pokemon(3,false, getContext().getDrawable(R.drawable.psyduck)));
        listPokemon.add(new Pokemon(6,false, getContext().getDrawable(R.drawable.bullbasaur)));
        listPokemon.add(new Pokemon(5,false, getContext().getDrawable(R.drawable.dratini)));
        listPokemon.add(new Pokemon(3,false, getContext().getDrawable(R.drawable.psyduck)));
        listPokemon.add(new Pokemon(5,false, getContext().getDrawable(R.drawable.dratini)));
        listPokemon.add(new Pokemon(4,false, getContext().getDrawable(R.drawable.snorlax)));
        listPokemon.add(new Pokemon(6,false, getContext().getDrawable(R.drawable.bullbasaur)));
        listPokemon.add(new Pokemon(7,false, getContext().getDrawable(R.drawable.jigglypuff)));
        return listPokemon;
    }
}