package com.dragonjik.banksecuritycard.model;

import io.realm.RealmObject;

/**
 * Created by yongjik on 16. 2. 29..
 */
public class CardInfo extends RealmObject {

    private String no;

    private String pw;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
