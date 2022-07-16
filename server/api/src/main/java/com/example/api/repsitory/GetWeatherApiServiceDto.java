package com.example.api.repsitory;

public class GetWeatherApiServiceDto {

    // 取得日
    String weatherDate;
    // 最高気温
    String temperatureMax;
    // 最低気温
    String temperatureMin;
    // 降水量
    String precipitationSum;


    public void setWeatherDate(String weatherDate){
        this.weatherDate = weatherDate;
    }

    public String getWeatherDate(){
        return weatherDate;
    }

    public void setTemperatureMax(String temperatureMax){
        this.temperatureMax = temperatureMax;
    }

    public String getTemperatureMax(){
        return temperatureMax;
    }

    public void setTemperatureMin(String temperatureMin){
        this.temperatureMin = temperatureMin;
    }

    public String getTemperatureMin(){
        return temperatureMin;
    }

    public void setPrecipitationSum(String precipitationSum){
        this.precipitationSum = precipitationSum;
    }

    public String getPrecipitationSum(){
        return precipitationSum;
    }
}
