import { Component, OnInit } from '@angular/core';
import { GetWeeklyWeatherServiceOutDto } from 'src/app/get-weekly-weather-service-out-dto';

@Component({
  selector: 'app-weekly-weather-info',
  templateUrl: './weekly-weather-info.component.html',
  styleUrls: ['./weekly-weather-info.component.css']
})
export class WeeklyWeatherInfoComponent implements OnInit {

  screenData = {} as GetWeeklyWeatherServiceOutDto;
  weatherInfoList: Array<GetWeeklyWeatherServiceOutDto> = [];
  regex = /"/g;

  constructor() { }

  ngOnInit(): void {

    // セッションストレージからデータを取得
    const weatherData = sessionStorage.getItem('weatherData');

    this.screenData = JSON.parse(weatherData!);
    let weatherDataLists = JSON.parse(weatherData!);
    // APIからresponseを取得
    Object.keys(weatherDataLists).map((key) => {
      const data = weatherDataLists[key];

      this.weatherInfoList.push(data);
    });

  }

}
