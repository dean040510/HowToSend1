package com.example.dean.howtosend;

import java.util.ArrayList;

/**
 * Created by dean on 2015/8/5.
 */
public class item extends ArrayList<String>{
    public String company_name;
    public String money;
    public String day;
    public String size;
    public String from;
    public String to1;
    public String type1;


    public void setItem(String company_name,String money,String day,String size,String from,String to1,String type1){
        this.company_name = company_name;
        this.money = money;
        this.day = day;
        this.size  = size;
        this.from = from;
        this.to1 = to1;
        this.type1 =  type1;
    }
    public String getName(){
        return company_name;
    }

    public String getMoney(){
        return money;
    }

    public String getday(){
        return day;
    }

}
