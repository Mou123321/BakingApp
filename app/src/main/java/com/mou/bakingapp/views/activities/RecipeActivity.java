package com.mou.bakingapp.views.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mou.bakingapp.R;
import com.mou.bakingapp.data.models.RecipeModel;
import com.mou.bakingapp.databinding.ActivityRecipeBinding;

public class RecipeActivity extends AppCompatActivity{
    private ActivityRecipeBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecipeModel recipeModel = getIntent().getExtras().getParcelable("recipe");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_recipe);

    }
}
