package com.dragonjik.banksecuritycard.model;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by yongjik on 16. 2. 29..
 */
public class Card extends RealmObject {

    private Bank bank;

    private RealmList<CardInfo> cardInfo;

    private Date createDate;

    public RealmList<CardInfo> getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(RealmList<CardInfo> cardInfo) {
        this.cardInfo = cardInfo;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
