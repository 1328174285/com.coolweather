package com.example.tianqi.util;

import android.text.TextUtils;

import com.example.tianqi.db.City;
import com.example.tianqi.db.County;
import com.example.tianqi.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {

//    解析和处理服务器返回的省级数据
    public static boolean handleProvinceResponse(String response){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i< allProvinces.length(); i++){
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("Id"));
                    province.save();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

//    解析和处理服务器返回的市级数据
    public static boolean handleCityResponse(String response, int provinceId){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCties = new JSONArray(response);
                for (int i = 0; i< allCties.length(); i++){
                    JSONObject citObject = allCties.getJSONObject(i);
                    City city = new City();
                    city.setCityName(citObject.getString("naem"));
                    city.setProvinceId(citObject.getInt("Id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

//    解析和处理服务器返回的县级数据
    public  static boolean handleCountyResponse(String response , int cityId) {
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i = 0; i<allCounties.length(); i++){
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeathrId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
