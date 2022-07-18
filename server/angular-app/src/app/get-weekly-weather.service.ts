import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { GetWeeklyWeatherServiceInDto } from './get-weekly-weather-service-in-dto';

@Injectable({
  providedIn: 'root'
})
export class GetWeeklyWeatherService {

  constructor(
    private http: HttpClient
  ) {}

  // POST で使うヘッダーを作っておく
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  url = 'http://localhost:8080/weatherApi/getWeather';

  public getWeather(countryInfo: GetWeeklyWeatherServiceInDto):Observable<Object> {
      return this.http.post(this.url, countryInfo, this.httpOptions)
      .pipe(
        // エラー時もHTTPステータスコードを戻す
        catchError((err: HttpErrorResponse) => of(
          err.status
      )));
  }
}
