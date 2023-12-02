package com.example.tianqi.db;

import org.litepal.crud.LitePalSupport;

public class County extends LitePalSupport {
    private int id;
    private String countyName;
    private String weathrId;
    private int cityId;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getCountyName (){
        return countyName;
    }
    public void setCountyName(String countyName){
        this.countyName = countyName;
    }
    public String getWeathrId(){
        return weathrId;
    }
    public void setWeathrId(String weathrId){
        this.weathrId = weathrId;
    }
    public int getCityId (){
        return cityId;
    }
    public void setCityId (int cityId){
        this.cityId = cityId;
    }

}
