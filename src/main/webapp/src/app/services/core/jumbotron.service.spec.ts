import { TestBed } from '@angular/core/testing';

import { JumbotronService } from './jumbotron.service';

describe('JumbotronService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: JumbotronService = TestBed.get(JumbotronService);
    expect(service).toBeTruthy();
  });
});
