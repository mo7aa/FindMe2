package com.example.myapplication.ui.subscription;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.ui.setting.SettingViewModel;


public class SubscriptionFragment extends Fragment {

    private SubscriptionViewModel subscriptionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        subscriptionViewModel  =
                ViewModelProviders.of(this).get(SubscriptionViewModel.class);
        View root = inflater.inflate(R.layout.subscription, container, false);
        subscriptionViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }

}
