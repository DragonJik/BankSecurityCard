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


}