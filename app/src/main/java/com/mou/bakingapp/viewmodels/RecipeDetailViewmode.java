package com.mou.bakingapp.viewmodels;

import com.mou.bakingapp.data.models.RecipeModel;
import com.mou.bakingapp.data.models.StepModel;
import com.mou.bakingapp.views.navigators.RecipeDetailNavigator;

import java.util.ArrayList;
import java.util.List;

public class RecipeDetailViewmode {

    public List<String> descriptions;
    private RecipeDetailNavigator navigator;


    public RecipeDetailViewmode(RecipeModel recipeModel, RecipeDetailNavigator navigator) {
        descriptions = new ArrayList<>();
        for(StepModel stepModel : recipeModel.getSteps()) {
            descriptions.add(stepModel.getShortDescription());
        }

        this.navigator = navigator;
    }

    public List<RecipeDetailItemViewmode> getDetail() {
        List<RecipeDetailItemViewmode> detail = new ArrayList<>();

        RecipeDetailItemViewmode ingredients = new RecipeDetailItemViewmode("Recipe Ingredients", 0);
        ingredients.setNavigator(navigator);
        detail.add(ingredients);

        for (int i = 1; i <= descriptions.size(); i++ ) {
            RecipeDetailItemViewmode item = new RecipeDetailItemViewmode(descriptions.get(i-1), i);
            item.setNavigator(navigator);
            detail.add(item);
        }
        return detail;
    }
}
