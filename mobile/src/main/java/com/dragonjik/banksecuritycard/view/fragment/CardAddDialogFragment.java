package com.dragonjik.banksecuritycard.view.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dragonjik.banksecuritycard.R;
import com.dragonjik.banksecuritycard.util.Log;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yongjik on 16. 3. 7..
 */
public class CardAddDialogFragment extends DialogFragment {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    private OnAddDialogListener listener;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE,
                android.R.style.Theme_Translucent_NoTitleBar);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_card,null);
        ButterKnife.bind(this,v);
        Log.d("onCreateView");

        //toolbar = (Toolbar) v.findViewById(R.id.toolbar);


        return  v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setTitle("카드 등록");
        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        listener.onCreate();
    }

    public void setOnListener(OnAddDialogListener listener){
        this.listener = listener;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        this.listener.onDismiss();
    }

    public interface OnAddDialogListener{
        public void onDismiss();
        public void onCreate();
    }


}
