package com.dragonjik.banksecuritycard.model;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by yongjik on 16. 2. 29..
 */
public class Card extends RealmObject {

    private Bank bank;

    private RealmList<CardInfo> cardInfo = new RealmList<CardInfo>();

    private Date createDate;

    private String memo;

    private String name;

    //가로 세로
    private int cardType;

    //카드개수
    private int cardCount;

    //일련번호
    private String serialNo;

    //연결된 앱
    private String relationAppPkg;


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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public int getCardCount() {
        return cardCount;
    }

    public void setCardCount(int cardCount) {
        this.cardCount = cardCount;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getRelationAppPkg() {
        return relationAppPkg;
    }

    public void setRelationAppPkg(String relationAppPkg) {
        this.relationAppPkg = relationAppPkg;
    }
}
