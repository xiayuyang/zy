package com.example.administrator.zy.Data;

/**
 * Created by Administrator on 2018/5/27.
 */

public class KeData {
    String name;
    String teacher;
    int jiaoshi;
    String week;
    String lesson;
    String bixiu;
    String raweek;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getJiaoshi() {
        return jiaoshi;
    }

    public void setJiaoshi(int jiaoshi) {
        this.jiaoshi = jiaoshi;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getBixiu() {
        return bixiu;
    }

    public void setBixiu(String bixiu) {
        this.bixiu = bixiu;
    }

    public String getRaweek() {
        return raweek;
    }

    public void setRaweek(String raweek) {
        this.raweek = raweek;
    }

    public KeData(String name, String teacher, int jiaoshi, String week, String lesson, String bixiu, String raweek) {
        this.name = name;
        this.teacher = teacher;
        this.jiaoshi = jiaoshi;
        this.week = week;
        this.lesson = lesson;
        this.bixiu = bixiu;
        this.raweek = raweek;
    }
}
