package com.dragonjik.banksecuritycard.viewmodel;

import com.dragonjik.banksecuritycard.controller.MainController;
import com.dragonjik.banksecuritycard.model.Card;
import com.dragonjik.banksecuritycard.util.Log;
import com.fernandocejas.frodo.annotation.RxLogObservable;
import com.jakewharton.rxrelay.PublishRelay;

import io.realm.RealmResults;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.subjects.BehaviorSubject;

/**
 * Created by yongjik on 16. 2. 29..
 */
public class MainViewModel {

    public PublishRelay<Void> mAddCardSubject = PublishRelay.create();


    public final PublishRelay<Void> loadCardListCommand = PublishRelay.create();

    private final BehaviorSubject<RealmResults<Card>> mCardListResultSubject = BehaviorSubject.create();


    @RxLogObservable
    public final Observable<RealmResults<Card>> getCardList(){
        return mCardListResultSubject.asObservable();
    }

    public MainViewModel(){
        this(new MainController());
    }

    public MainViewModel(final MainController controller) {


        loadCardListCommand.concatMap(new Func1<Void, Observable<RealmResults<Card>>>() {
            @Override
            public Observable<RealmResults<Card>> call(Void aVoid) {
                Log.d("concatmap");
                return controller.getCardList();
            }
        })
        .subscribe(new Subscriber<RealmResults<Card>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

                Log.d(e);
            }

            @Override
            public void onNext(RealmResults<Card> results) {
                Log.d("onNext"+results.size());
                mCardListResultSubject.onNext(results);
            }
        });
    }
}
