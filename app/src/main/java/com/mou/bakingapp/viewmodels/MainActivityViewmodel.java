package com.mou.bakingapp.viewmodels;

import com.mou.bakingapp.data.Repository;
import com.mou.bakingapp.data.models.RecipeModel;
import com.mou.bakingapp.views.activities.MainActivity;
import com.mou.bakingapp.views.adapters.recyclerViewAdapters.BaseRecyclerViewAdapter;
import com.mou.bakingapp.views.adapters.recyclerViewAdapters.RecipeRecyclerViewAdapter;
import com.mou.bakingapp.views.navigators.MainActivityNavigator;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivityViewmodel {

    private Repository repository;

    private List<RecipeModel> recipes;

    private MainActivityNavigator navigator;

    public MainActivityViewmodel(Repository repository, MainActivityNavigator navigator) {
        this.repository = repository;
        this.navigator = navigator;
    }

    public void setRecipes(RecipeRecyclerViewAdapter adapter) {
        repository.getRcipes()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(r -> adapter.update(getRecipeNames(recipes = r)), e -> System.out.println(e.getMessage()));
    }

    public List<RecipeModel> getRecipes() {
        return recipes;
    }

    private List<RecipePostViewmodel> getRecipeNames(List<RecipeModel> recipes) {
        List<RecipePostViewmodel> list = new ArrayList<>();
        for (int i = 0; i < recipes.size(); i++) {
            RecipePostViewmodel viewmodel = new RecipePostViewmodel(recipes.get(i).getName(), i);
            viewmodel.setNavigator(navigator);
            list.add(viewmodel);
        }
        return list;
    }

}
