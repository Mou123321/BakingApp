package com.mou.bakingapp.views.adapters.recyclerViewAdapters;

import com.mou.bakingapp.R;
import com.mou.bakingapp.data.models.RecipeModel;
import com.mou.bakingapp.viewmodels.RecipePostViewmodel;

import java.util.List;

public class RecipeRecyclerViewAdapter extends BaseRecyclerViewAdapter{

    private List<RecipePostViewmodel> viewModels;

    public RecipeRecyclerViewAdapter(List<RecipePostViewmodel> viewModels) {
        this.viewModels = viewModels;
    }

    @Override
    protected int getLayoutId(int position) {
        return R.layout.recipe_item;
    }

    @Override
    protected Object getListObject(int position) {
        return viewModels.get(position);
    }

    @Override
    protected int getListSize() {
        return viewModels.size();
    }

    public void update(List<RecipePostViewmodel> viewModels) {
        this.viewModels = viewModels;
        notifyDataSetChanged();
    }
}
