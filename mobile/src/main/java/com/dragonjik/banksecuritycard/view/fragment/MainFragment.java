package com.dragonjik.banksecuritycard.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dragonjik.banksecuritycard.R;
import com.dragonjik.banksecuritycard.model.Card;
import com.dragonjik.banksecuritycard.view.adapter.CardListAdapter;
import com.dragonjik.banksecuritycard.viewmodel.MainViewModel;
import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmResults;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;


/**
 * Created by yongjik on 16. 2. 29..
 */
public class MainFragment extends RxFragment {


    private MainViewModel mainViewModel;
    @Bind(R.id.lv)
    RecyclerView lv;

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
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        lv.setLayoutManager(layoutManager);
        lv.setHasFixedSize(true);
        mainViewModel.loadCardListCommand.call(null);


    }

    private void setupModel() {


        mainViewModel.getCardList()
                .map(new Func1<RealmResults<Card>, CardListAdapter>() {
                    @Override
                    public CardListAdapter call(RealmResults<Card> results) {

                        CardListAdapter adapter = new CardListAdapter(getActivity());

                        adapter.addList(results);

                        return adapter;

                    }
                })
                .compose(this.<CardListAdapter>bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<CardListAdapter>() {
                    @Override
                    public void call(CardListAdapter cardListAdapter) {

                        lv.setAdapter(cardListAdapter);
                    }
                });

    }
}
