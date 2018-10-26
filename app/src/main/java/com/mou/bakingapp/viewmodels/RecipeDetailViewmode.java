package com.mou.bakingapp.viewmodels;

import com.mou.bakingapp.data.models.RecipeModel;
import com.mou.bakingapp.data.models.StepModel;
import com.mou.bakingapp.views.navigators.RecipeDetailNavigator;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class RecipeDetailViewmode {

    public List<String> descriptions;

    private WeakReference<RecipeDetailNavigator> navigator;

    public RecipeDetailViewmode(RecipeModel recipeModel) {
        descriptions = new ArrayList<>();
        for(StepModel stepModel : recipeModel.getSteps()) {
            descriptions.add(stepModel.getShortDescription());
        }
        System.out.println("list is " + descriptions);
    }

    public void setNavigator(RecipeDetailNavigator navigator) {
        this.navigator = new WeakReference<>(navigator);
    }
}
