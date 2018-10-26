package com.mou.bakingapp.views.adapters.recyclerViewAdapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mou.bakingapp.BR;

public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseRecyclerViewViewHolder>{

    @Override
    public BaseRecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);

        return new BaseRecyclerViewViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewViewHolder holder, int position) {
        holder.bind(getListObject(position));
    }

    @Override
    public int getItemCount() {
        return getListSize();
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutId(position);
    }

    protected abstract int getLayoutId(int position);

    protected abstract Object getListObject(int position);

    protected abstract int getListSize();

    public class BaseRecyclerViewViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding mBinding;

        public BaseRecyclerViewViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        public void bind(Object object) {
            if (object != null) {
                mBinding.setVariable(BR.vm, object);
            }
            mBinding.executePendingBindings();
        }
    }
}
