package com.example.api.service;

import java.util.ArrayList;
import java.util.List;

import com.example.api.Constant.ConstantWeatherInfo;
import com.example.api.repsitory.CountryInfoDto;
import com.example.api.repsitory.GetWeatherApiServiceDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class GetWeatherApiServiceImpl implements GetWeatherApiService {

    @Override
    public List<GetWeatherApiServiceDto> getWeatherTokyoApi(CountryInfoDto countryInfDto) {

        RestTemplate rest = new RestTemplate();
        String retJsonWeather = "";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode dailys = null;
        // 最低気温
        String[] temperatureMin = null;
        // 最高気温
        String[] temperatureMax = null;
        // 降水量
        String[] precipitationSum = null;
        // お天気情報の日時
        String[] weatherDate = null;
        // APIのURL
        String url = null;

        if(ConstantWeatherInfo.CONTRY_TOKYO_STRING.equals(countryInfDto.getCountryName())){
            // 東京の天気情報(URL)の設定
            url =ConstantWeatherInfo.TOKYO_URL_STRING;
        } else {
            url = "";
        }

        List<GetWeatherApiServiceDto> resultList = new ArrayList<GetWeatherApiServiceDto>();

        try{
            // 東京の天気情報を取得。
            ResponseEntity<String> response = rest.getForEntity(url, String.class);

            retJsonWeather = response.getBody();
            String jsons = retJsonWeather.toString();
            // json形式に変換
            JsonNode root = mapper.readTree(jsons);
            dailys = root.get("daily");
            temperatureMin = dailys.get("temperature_2m_min").toString().split(",");
            temperatureMax = dailys.get("temperature_2m_max").toString().split(",");
            precipitationSum = dailys.get("precipitation_sum").toString().split(",");
            weatherDate = dailys.get("time").toString().split(",");

            for(int i = 0; i < ConstantWeatherInfo.ROOP_COUNT; i++){

                // 天気情報dto
                GetWeatherApiServiceDto weatherDto = new GetWeatherApiServiceDto();
                weatherDto.setWeatherDate(weatherDate[i].replace("[", "").replace("]", ""));
                weatherDto.setTemperatureMax(temperatureMax[i].replace("[", "").replace("]", ""));
                weatherDto.setTemperatureMin(temperatureMin[i].replace("[", "").replace("]", ""));
                weatherDto.setPrecipitationSum(precipitationSum[i].replace("[", "").replace("]", ""));

                resultList.add(weatherDto);
            }

        } catch(HttpClientErrorException e){
            System.out.println(e);

        } catch(JsonProcessingException e){
            System.out.println(e);

        }
        return resultList;
    }

}
