package com.mou.bakingapp.views.adapters.recyclerViewAdapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mou.bakingapp.BR;
import com.mou.bakingapp.R;
import com.mou.bakingapp.viewmodels.RecipePostViewmodel;
import com.mou.bakingapp.views.navigators.MainActivityNavigator;

import java.util.List;

public class BaseRecyclerViewAdapter extends RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseRecyclerViewViewHolder>{

    private List<String> recipes;

    private MainActivityNavigator mNavigator;

    public BaseRecyclerViewAdapter(List<String> recipes, MainActivityNavigator navigator) {
        this.recipes = recipes;
        mNavigator = navigator;
    }

    @Override
    public BaseRecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);

        return new BaseRecyclerViewViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewViewHolder holder, int position) {
        holder.bind(recipes.get(position), position);
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.recipe_item;
    }

    public void update(List<String> name) {
        recipes = name;
        notifyDataSetChanged();
    }

    public class BaseRecyclerViewViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding mBinding;

        public BaseRecyclerViewViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        public void bind(String name, int position) {
            RecipePostViewmodel vm = new RecipePostViewmodel(name, position);
            vm.setNavigator(mNavigator);
            mBinding.setVariable(BR.vm, vm);
            mBinding.executePendingBindings();
        }
    }
}
