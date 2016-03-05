package com.dragonjik.banksecuritycard.controller;

import com.dragonjik.banksecuritycard.model.Card;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;

/**
 * Created by yongjik on 16. 3. 1..
 */
public class MainController {


    public Observable<RealmResults<Card>> getCardList(){

        Realm realm  =  Realm.getDefaultInstance();

        return realm.where(Card.class).findAllAsync().asObservable();
    }
}
