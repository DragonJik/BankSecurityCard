package com.dragonjik.banksecuritycard.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dragonjik.banksecuritycard.R;
import com.dragonjik.banksecuritycard.model.Card;
import com.dragonjik.banksecuritycard.view.adapter.viewholder.CardListViewHolder;

import java.util.ArrayList;

import io.realm.RealmResults;

/**
 * Created by yongjik on 16. 3. 7..
 */
public class CardListAdapter extends RecyclerView.Adapter<CardListViewHolder> {


    private ArrayList<Card> arr = new ArrayList<Card>();
    private Context mContext;
    public CardListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public CardListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_list,parent,false);
        return new CardListViewHolder(mContext,itemView);
    }

    @Override
    public void onBindViewHolder(CardListViewHolder holder, int position) {

        holder.bind();

        Card card = arr.get(position);
        holder.getViewModel().setCardListResultCommand.call(card);
    }


    @Override
    public int getItemCount() {
        return arr.size();
    }

    public void addList(RealmResults<Card> results) {
        arr.addAll(results.subList(0,results.size()));
    }
}
