package com.mou.bakingapp.views.adapters.recyclerViewAdapters;

import com.mou.bakingapp.R;
import com.mou.bakingapp.viewmodels.RecipeDetailItemViewmode;

import java.util.List;

public class RecipeDetailRecyclerViewAdapter extends BaseRecyclerViewAdapter{
    private List<RecipeDetailItemViewmode> list;

    public RecipeDetailRecyclerViewAdapter(List<RecipeDetailItemViewmode> list) {
        this.list = list;
    }

    @Override
    protected int getLayoutId(int position) {
        return R.layout.recipe_detail_item;
    }

    @Override
    protected Object getListObject(int position) {
        return list.get(position);
    }

    @Override
    protected int getListSize() {
        return list.size();
    }
}
