package com.mou.bakingapp.viewmodels;

import com.mou.bakingapp.data.Repository;
import com.mou.bakingapp.data.models.RecipeModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivityViewmodel {

    private Repository repository;

    private List<RecipeModel> recipes;

    public MainActivityViewmodel(Repository repository) {
        this.repository = repository;
        setRecipes();
    }

    private void setRecipes() {
        repository.getRcipes()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(r -> recipes = r, e -> System.out.println(e.getMessage()));
    }

    public List<RecipeModel> getRecipes() {
        return recipes;
    }
}
