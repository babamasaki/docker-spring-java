package com.example.api.service;

import java.util.List;

import com.example.api.repsitory.GetWeatherApiServiceDto;

public interface GetWeatherApiService {
    
    /*
    * 東京の天気情報を返す。
    * @return 東京の天気データ(Json形式)
     */
    public List<GetWeatherApiServiceDto> getWeatherTokyoApi();
}
