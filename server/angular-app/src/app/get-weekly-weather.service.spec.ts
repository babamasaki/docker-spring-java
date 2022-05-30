import { TestBed } from '@angular/core/testing';

import { GetWeeklyWeatherService } from './get-weekly-weather.service';

describe('GetWeeklyWeatherService', () => {
  let service: GetWeeklyWeatherService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetWeeklyWeatherService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
