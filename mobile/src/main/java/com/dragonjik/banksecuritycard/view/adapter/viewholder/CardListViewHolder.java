package com.dragonjik.banksecuritycard.view.adapter.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dragonjik.banksecuritycard.R;
import com.dragonjik.banksecuritycard.model.Card;
import com.dragonjik.banksecuritycard.viewmodel.MainViewModel;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Action1;

/**
 * Created by yongjik on 16. 3. 7..
 */
public class CardListViewHolder extends RecyclerView.ViewHolder{

    private Context mContext;
    private MainViewModel mainViewModel;

    @Bind(R.id.tv_card_name)
    TextView tvCardName;

    public CardListViewHolder(Context context, View itemView) {
        super(itemView);

        mContext = context;

        mainViewModel = new MainViewModel();
        ButterKnife.bind(itemView);

    }


    public void bind(){

        mainViewModel.data().subscribe(new Action1<Card>() {
            @Override
            public void call(Card card) {

                tvCardName.setText(card.getBank().getName());
            }
        });
    }

    public MainViewModel getViewModel(){
        return mainViewModel;
    }
}
