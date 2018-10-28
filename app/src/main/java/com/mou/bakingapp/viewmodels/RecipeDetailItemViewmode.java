package com.mou.bakingapp.viewmodels;

import android.support.annotation.Nullable;

import com.mou.bakingapp.views.navigators.RecipeDetailNavigator;

import java.lang.ref.WeakReference;

public class RecipeDetailItemViewmode {

    public String itemName;
    public int position;

    @Nullable
    private WeakReference<RecipeDetailNavigator> mNavigator;

    public RecipeDetailItemViewmode(String itemName, int position) {
        this.itemName = itemName;
        this.position = position;
    }

    public void setNavigator(RecipeDetailNavigator navigator) {
        mNavigator = new WeakReference<>(navigator);
    }
}
