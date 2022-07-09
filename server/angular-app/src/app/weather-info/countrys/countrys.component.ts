import { Component, OnInit } from '@angular/core';
import { GetWeeklyWeatherService } from 'src/app/get-weekly-weather.service';
import { GetWeeklyWeatherServiceInDto } from '../../get-weekly-weather-service-in-dto';
import { Router } from '@angular/router';
import { GetWeeklyWeatherServiceOutDto } from '../../get-weekly-weather-service-out-dto';
import { CountrysService } from 'src/app/countrys.service';


@Component({
  selector: 'app-countrys',
  templateUrl: './countrys.component.html',
  styleUrls: ['./countrys.component.css']
})
export class CountrysComponent implements OnInit {

  weatherInfoList: Array<GetWeeklyWeatherServiceOutDto> = [];

  countrys:Array<string> = [];

  constructor(
    private getWeeklyWeatherService: GetWeeklyWeatherService
    ,private router: Router
    ,private countrysService: CountrysService
  ) {}

  ngOnInit(): void {

    // 国名を取得
    this.countrysService.getWeather().subscribe(response=>{

      // 設定ファイルから値を取得
      Object.entries(response).forEach(([key, fromValue]) => {
        this.countrys.push(fromValue);

      });

    });

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

      let weatherData = JSON.stringify(this.weatherInfoList);
      sessionStorage.removeItem('weatherData');
      sessionStorage.setItem('weatherData', weatherData);

      this.router.navigate(['/weekly-weather-info']);
    });
  }

}
