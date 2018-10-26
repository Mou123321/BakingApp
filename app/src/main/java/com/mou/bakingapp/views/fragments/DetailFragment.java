package com.mou.bakingapp.views.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mou.bakingapp.R;
import com.mou.bakingapp.data.models.RecipeModel;
import com.mou.bakingapp.databinding.FragmentDetailBinding;
import com.mou.bakingapp.viewmodels.RecipeDetailViewmode;
import com.mou.bakingapp.views.adapters.recyclerViewAdapters.RecipeDetailRecyclerViewAdapter;
import com.mou.bakingapp.views.navigators.RecipeDetailNavigator;

public class DetailFragment extends Fragment{

    private FragmentDetailBinding binding;
    private RecipeDetailViewmode viewmode;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.bind(inflater.inflate(R.layout.fragment_detail, container, false));

        RecipeModel recipeModel = getArguments().getParcelable("recipe");
        viewmode = new RecipeDetailViewmode(recipeModel);

        RecipeDetailRecyclerViewAdapter adapter = new RecipeDetailRecyclerViewAdapter(viewmode.descriptions);

        binding.recyclerView.setAdapter(adapter);

        viewmode.setNavigator((RecipeDetailNavigator) getActivity());

        binding.setVm(viewmode);

        return binding.getRoot();
    }
}
