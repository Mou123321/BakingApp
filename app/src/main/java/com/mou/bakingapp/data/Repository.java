package com.mou.bakingapp.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mou.bakingapp.data.models.RecipeModel;
import com.mou.bakingapp.data.remote.RecipeService;
import com.mou.bakingapp.views.utils.ApiUtil;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class Repository {

    @Nullable
    private static Repository INSTANCE;

    @NonNull
    private final RecipeService mService;

    private Repository() {
        this.mService = ApiUtil.getMovieService();
    }

    public static Repository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Repository();
        }
        return INSTANCE;
    }

    public Observable<List<RecipeModel>> getRcipes(){
        return mService.getRecipes()
                .subscribeOn(Schedulers.io());
    }
}
