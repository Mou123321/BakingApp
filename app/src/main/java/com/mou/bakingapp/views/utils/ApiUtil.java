package com.mou.bakingapp.views.utils;

import com.mou.bakingapp.data.remote.RecipeService;
import com.mou.bakingapp.data.remote.RetrofitClient;

public class ApiUtil {

    private static final String BASE_URL = "https://d17h27t6h515a5.cloudfront.net/";

    public static RecipeService getMovieService() {
        return RetrofitClient.getClient(BASE_URL).create(RecipeService.class);
    }
}
