import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CountrysComponent } from './countrys/countrys.component';
import { WeeklyWeatherInfoComponent } from './weekly-weather-info/weekly-weather-info.component';

const routes: Routes = [
  { path: 'countrys', component: CountrysComponent },
  { path: 'weekly-weather-info', component: WeeklyWeatherInfoComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class WeatherInfoRoutingModule { }
