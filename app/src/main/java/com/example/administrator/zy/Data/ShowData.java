package com.example.administrator.zy.Data;

/**
 * Created by Administrator on 2018/5/27.
 */

public class ShowData {
    int id;
    String lessonii;
    int  jiaoshiii;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonii() {
        return lessonii;
    }

    public void setLessonii(String lessonii) {
        this.lessonii = lessonii;
    }

    public int getJiaoshiii() {
        return jiaoshiii;
    }

    public void setJiaoshiii(int  jiaoshiii) {
        this.jiaoshiii = jiaoshiii;
    }

    public ShowData(int id, String lessonii, int  jiaoshiii) {
        this.id = id;
        this.lessonii = lessonii;
        this.jiaoshiii = jiaoshiii;
    }
}
