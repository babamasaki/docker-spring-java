package com.example.api.Constant;

public class ConstantWeatherInfo {

    // カウント数
    public static final int ROOP_COUNT = 6;

    // お天気APIのURL(東京)
    public static final String TOKYO_URL_STRING = "https://api.open-meteo.com/v1/forecast?latitude=35.6785&longitude=139.6823&hourly=temperature_2m,relativehumidity_2m&daily=temperature_2m_max,temperature_2m_min,precipitation_sum&timezone=Asia/Tokyo";
    // お天気APIのURL(ニューヨーク)
    public static final String NEWYORK_URL_STRING = "https://api.open-meteo.com/v1/forecast?latitude=40.71&longitude=-74.01&hourly=temperature_2m,relativehumidity_2m&daily=temperature_2m_max,temperature_2m_min,precipitation_sum&timezone=America/New_York";
    // お天気APIのURL(ロンドン)
    public static final String LONDON_URL_STRING = "https://api.open-meteo.com/v1/forecast?latitude=51.5002&longitude=-0.1262&hourly=temperature_2m,relativehumidity_2m&daily=temperature_2m_max,temperature_2m_min,precipitation_sum&timezone=Europe/London";

    // 東京
    public static final String CONTRY_TOKYO_STRING = "Tokyo";
    // ニューヨーク
    public static final String CONTRY_NEWYORK_STRING = "NewYork";
    // ロンドン
    public static final String CONTRY_LONDON_STRING = "London";
}
