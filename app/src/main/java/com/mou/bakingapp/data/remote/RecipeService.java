package com.mou.bakingapp.data.remote;

import com.mou.bakingapp.data.models.RecipeModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RecipeService {

    String END_POINT = "/topher/2017/May/59121517_baking/baking.json";

    @GET(END_POINT)
    Observable<List<RecipeModel>> getRecipes();
}
