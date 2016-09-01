package com.example.administrator.memo3.model;

/**
 * Created by Administrator on 2016/8/19 0019.
 */
public class Amuse {
    private int id;
    private String content;


    public int getId(){
        return id;
    }

    public String getContent(){
        return content;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String toString(){
        String str = this.getContent();
        String s = null;
        if(str.length() > 10){
            s = str.substring(0,10);
            s = s + "...";
        }else {
            s = str;
        }
        return s;
    }
}
