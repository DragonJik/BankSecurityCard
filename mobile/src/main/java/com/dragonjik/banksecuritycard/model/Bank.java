package com.dragonjik.banksecuritycard.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by yongjik on 16. 2. 29..
 */
public class Bank extends RealmObject {

    @PrimaryKey
    private String name;

    //계좌번호
    private String acount;


    //가로 세로
    private int cardType;

    //카드개수
    private int cardCount;

    //일련번호
    private String serialNo;

    //연결된 앱
    private String relationAppPkg;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
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