package com.mou.bakingapp.viewmodels;

import android.support.annotation.Nullable;

import com.mou.bakingapp.views.navigators.MainActivityNavigator;

import java.lang.ref.WeakReference;

public class RecipePostViewmodel {
    public String name;
    public int position;

    @Nullable
    private WeakReference<MainActivityNavigator> mNavigator;

    public RecipePostViewmodel(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void setNavigator(MainActivityNavigator navigator) {
        mNavigator = new WeakReference<>(navigator);
    }
}
