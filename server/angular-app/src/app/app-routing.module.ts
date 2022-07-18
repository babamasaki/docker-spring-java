import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WeatherInfoModule } from './weather-info/weather-info.module';

const routes: Routes = [
  {
    path: 'weather-info',
    loadChildren: () => import('./weather-info/weather-info.module').then(m => m.WeatherInfoModule), // 追加
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes), WeatherInfoModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
