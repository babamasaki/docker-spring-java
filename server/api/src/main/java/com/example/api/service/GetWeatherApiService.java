package com.example.api.service;

import java.util.List;

import com.example.api.repsitory.CountryInfoDto;
import com.example.api.repsitory.GetWeatherApiServiceDto;

public interface GetWeatherApiService {

    /**
     * お天気情報取得API呼び出し
     * @param 国名 文字列型
     * @return ６日分のお天気情報　GetWeatherApiServiceDto型
     */
    public List<GetWeatherApiServiceDto> getWeatherTokyoApi(CountryInfoDto countryInfDto);
}
