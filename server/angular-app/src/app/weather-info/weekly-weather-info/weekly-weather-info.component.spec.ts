import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WeeklyWeatherInfoComponent } from './weekly-weather-info.component';

describe('WeeklyWeatherInfoComponent', () => {
  let component: WeeklyWeatherInfoComponent;
  let fixture: ComponentFixture<WeeklyWeatherInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WeeklyWeatherInfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WeeklyWeatherInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
