package com.mou.bakingapp.views.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mou.bakingapp.R;
import com.mou.bakingapp.data.Repository;
import com.mou.bakingapp.data.models.RecipeModel;
import com.mou.bakingapp.databinding.ActivityMainBinding;
import com.mou.bakingapp.viewmodels.MainActivityViewmodel;
import com.mou.bakingapp.views.adapters.recyclerViewAdapters.BaseRecyclerViewAdapter;
import com.mou.bakingapp.views.navigators.MainActivityNavigator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityNavigator{

    private ActivityMainBinding binding;
    private MainActivityViewmodel viewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewmodel = new MainActivityViewmodel(Repository.getInstance());
        binding.setVm(viewmodel);

        BaseRecyclerViewAdapter adapter = new BaseRecyclerViewAdapter(new ArrayList<>(), this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        binding.recyclerView.setLayoutManager(layoutManager);

        binding.recyclerView.setAdapter(adapter);

        viewmodel.setRecipes(adapter);
    }

    @Override
    public void displayRecipe(int position) {
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra("recipe", viewmodel.getRecipes().get(position));
        System.out.println(viewmodel.getRecipes().get(position).getSteps().get(0).getShortDescription());
        startActivity(intent);
    }
}
