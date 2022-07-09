import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CountrysService {

  constructor(
    private http: HttpClient
  ) { }

  // POST で使うヘッダーを作っておく
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  url = 'assets/data/countrys.json';

  public getWeather():Observable<Object> {
      return this.http.get(this.url, this.httpOptions)
      .pipe(
        // エラー時もHTTPステータスコードを戻す
        catchError((err: HttpErrorResponse) => of(
          err.status
      )));
  }

}
