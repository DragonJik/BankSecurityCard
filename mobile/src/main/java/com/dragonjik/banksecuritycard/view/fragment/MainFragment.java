package com.dragonjik.banksecuritycard.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dragonjik.banksecuritycard.R;
import com.dragonjik.banksecuritycard.viewmodel.MainViewModel;
import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.ButterKnife;


/**
 * Created by yongjik on 16. 2. 29..
 */
public class MainFragment extends RxFragment {


    private MainViewModel mainViewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, null);

        ButterKnife.bind(this,v);

        mainViewModel = new MainViewModel();

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        setupModel();
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainViewModel.loadCardListCommand.call(null);


    }

    private void setupModel() {



    }
}
