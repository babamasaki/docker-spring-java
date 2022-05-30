import { Component, OnInit } from '@angular/core';
import { GetWeeklyWeatherService } from 'src/app/get-weekly-weather.service';
import { GetWeeklyWeatherServiceInDto } from '../../get-weekly-weather-Service-in-dto';
import { Data } from '@angular/router';
import { GetWeeklyWeatherServiceOutDto } from 'src/app/get-weekly-weather-Service-out-dto';


@Component({
  selector: 'app-countrys',
  templateUrl: './countrys.component.html',
  styleUrls: ['./countrys.component.css']
})
export class CountrysComponent implements OnInit {

  weatherInfoList: Array<GetWeeklyWeatherServiceOutDto> = [];

  constructor(
    private getWeeklyWeatherService: GetWeeklyWeatherService
  ) {}

  ngOnInit(): void {
  }

  getWeather(country: string){

    let getWeeklyWeatherServiceInDto = <GetWeeklyWeatherServiceInDto>{
      countryName : country
    };

    let getWeeklyWeatherOutDto = <GetWeeklyWeatherServiceOutDto>{}

    // 天気予報取得serviceの呼び出し
    this.getWeeklyWeatherService.getWeather(getWeeklyWeatherServiceInDto).subscribe(response=>{

      // APIからresponseを取得
      Object.entries(response).forEach(([key, fromValue]) => {
        getWeeklyWeatherOutDto = fromValue;
        this.weatherInfoList.push(getWeeklyWeatherOutDto);

      });

      for (const value of this.weatherInfoList) {
        console.log(value);
      }
    });
  }

}
