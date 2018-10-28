package com.mou.bakingapp.views.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.mou.bakingapp.R;
import com.mou.bakingapp.data.models.RecipeModel;
import com.mou.bakingapp.databinding.ActivityRecipeBinding;
import com.mou.bakingapp.views.fragments.DetailFragment;
import com.mou.bakingapp.views.navigators.RecipeDetailNavigator;

public class RecipeActivity extends FragmentActivity implements RecipeDetailNavigator{

    private ActivityRecipeBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_recipe);

        RecipeModel recipeModel =  getIntent().getExtras().getParcelable("recipe");
        binding.toolbar.setTitle(recipeModel.getName());

        DetailFragment detailFragment = new DetailFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.content, detailFragment);
        Bundle bundle = new Bundle();
        bundle.putParcelable("recipe", recipeModel);
        detailFragment.setArguments(bundle);
        fragmentTransaction.commit();
    }

    @Override
    public void showIngredients() {

    }

    @Override
    public void showStep() {

    }
}
