package com.example.administrator.zy.Data;

/**
 * Created by Administrator on 2018/5/26.
 */

public class AnswerData {
    static int id;
    static String nicker;
    static String picture;
    static String geder;
    static String content;
    static String crate;
    static int prase;
    static int commert;
    static int isadopt;
    static int isprause;

    public AnswerData(String nicker, String picture, String geder, String content, String crate, int prase, int commert, int isadopt, int isprause) {
        this.nicker = nicker;
        this.picture = picture;
        this.geder = geder;
        this.content = content;
        this.crate = crate;
        this.prase = prase;
        this.commert = commert;
        this.isadopt = isadopt;
        this.isprause = isprause;
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getNicker() {
        return nicker;
    }

    public void setNicker(String nicker) {
        this.nicker = nicker;
    }

    public static String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public static String getGeder() {
        return geder;
    }

    public void setGeder(String geder) {
        this.geder = geder;
    }

    public static String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static String getCrate() {
        return crate;
    }

    public void setCrate(String crate) {
        this.crate = crate;
    }

    public static int getPrase() {
        return prase;
    }

    public void setPrase(int prase) {
        this.prase = prase;
    }

    public static int getCommert() {
        return commert;
    }

    public void setCommert(int commert) {
        this.commert = commert;
    }

    public static int getIsadopt() {
        return isadopt;
    }

    public void setIsadopt(int isadopt) {
        this.isadopt = isadopt;
    }

    public static int getIsprause() {
        return isprause;
    }

    public void setIsprause(int isprause) {
        this.isprause = isprause;
    }
}
