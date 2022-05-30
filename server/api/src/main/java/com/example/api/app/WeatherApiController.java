package com.example.api.app;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.example.api.repsitory.CountryInfoDto;
import com.example.api.repsitory.GetWeatherApiServiceDto;
import com.example.api.service.GetWeatherApiService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weatherApi")
public class WeatherApiController {

    private final GetWeatherApiService getWeatherApiService;

    WeatherApiController(GetWeatherApiService getWeatherApiService){

        this.getWeatherApiService = getWeatherApiService;

    }

    @RequestMapping("/jsonTest")
	public Map<String, String> jsonTest(){

		return Collections.singletonMap("message", "Hello, World!");
	}

    @CrossOrigin
    @RequestMapping("/getWeather")
    public List<GetWeatherApiServiceDto> getWeather(@RequestBody CountryInfoDto countryInfDto){

        List<GetWeatherApiServiceDto> getweatherJson = getWeatherApiService.getWeatherTokyoApi(countryInfDto);

        return getweatherJson;
    }

}
