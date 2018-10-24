package com.mou.bakingapp.views.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mou.bakingapp.R;
import com.mou.bakingapp.data.Repository;
import com.mou.bakingapp.databinding.ActivityMainBinding;
import com.mou.bakingapp.viewmodels.MainActivityViewmodel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityViewmodel viewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewmodel = new MainActivityViewmodel(Repository.getInstance());
        binding.setVm(viewmodel);
    }
}
