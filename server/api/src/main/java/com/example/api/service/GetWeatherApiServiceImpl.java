package com.example.api.service;

import java.util.ArrayList;
import java.util.List;

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
    public List<GetWeatherApiServiceDto> getWeatherTokyoApi() {

        RestTemplate rest = new RestTemplate();
        String retJsonWeather = "";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode dailys = null;
        // 最低気温
        String[] temperatureMin = null;
        // 最高気温
        String[] temperatureMax = null;
        // お天気情報の日時
        String[] weatherDate = null;

        // お天気APIのURL(東京)
        final String url = "https://api.open-meteo.com/v1/forecast?latitude=35.6785&longitude=139.6823&hourly=temperature_2m,relativehumidity_2m&daily=temperature_2m_max,temperature_2m_min&timezone=Asia/Tokyo";

        List<GetWeatherApiServiceDto> resultList = new ArrayList<GetWeatherApiServiceDto>();

        try{
            // 東京の天気情報を取得。
            ResponseEntity<String> response = rest.getForEntity(url, String.class);

            retJsonWeather = response.getBody();
            String jsons = retJsonWeather.toString();
            // json形式に変換
            JsonNode root = mapper.readTree(jsons);
            System.out.println("---------------------daily_units---------------------");
            dailys = root.get("daily");
            temperatureMin = dailys.get("temperature_2m_min").toString().split(",");
            temperatureMax = dailys.get("temperature_2m_max").toString().split(",");
            weatherDate = dailys.get("time").toString().split(",");

            for(int i = 0; i < weatherDate.length; i++){

                // 天気情報dto
                GetWeatherApiServiceDto weatherDto = new GetWeatherApiServiceDto();
                weatherDto.setWeatherDate(weatherDate[i].replace("[", "").replace("]", ""));
                weatherDto.setTemperatureMax(temperatureMax[i].replace("[", "").replace("]", ""));
                weatherDto.setTemperatureMin(temperatureMin[i].replace("[", "").replace("]", ""));

                System.out.println(weatherDto.getWeatherDate());
                System.out.println(weatherDto.getTemperatureMax());
                System.out.println(weatherDto.getTemperatureMin());

                resultList.add(weatherDto);

            }

            System.out.println("---------------------daily_units---------------------");

        } catch(HttpClientErrorException e){
            System.out.println(e);

        } catch(JsonProcessingException e){
            System.out.println(e);

        }

        return resultList;
    }

}
