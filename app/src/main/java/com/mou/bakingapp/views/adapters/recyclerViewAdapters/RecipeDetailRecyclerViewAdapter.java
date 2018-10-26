package com.mou.bakingapp.views.adapters.recyclerViewAdapters;

import com.mou.bakingapp.R;

import java.util.List;

public class RecipeDetailRecyclerViewAdapter extends BaseRecyclerViewAdapter{
    private List<String> list;

    public RecipeDetailRecyclerViewAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    protected int getLayoutId(int position) {
        return R.layout.recipe_item;
    }

    @Override
    protected Object getListObject(int position) {
        return null;
    }

    @Override
    protected int getListSize() {
        return list.size();
    }
}
