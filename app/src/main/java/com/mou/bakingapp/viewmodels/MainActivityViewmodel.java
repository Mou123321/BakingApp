package com.mou.bakingapp.viewmodels;

import com.mou.bakingapp.data.Repository;
import com.mou.bakingapp.data.models.RecipeModel;
import com.mou.bakingapp.views.adapters.recyclerViewAdapters.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivityViewmodel {

    private Repository repository;

    private List<RecipeModel> recipes;

    public MainActivityViewmodel(Repository repository) {
        this.repository = repository;
    }

    public void setRecipes(BaseRecyclerViewAdapter adapter) {
        repository.getRcipes()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(r -> adapter.update(getRecipeNames(recipes = r)), e -> System.out.println(e.getMessage()));
    }

    public List<RecipeModel> getRecipes() {
        return recipes;
    }

    private List<String> getRecipeNames(List<RecipeModel> recipes) {
        List<String> name = new ArrayList<>();
        for (RecipeModel recipe : recipes) {
            name.add(recipe.getName());
        }

        return name;
    }

}
