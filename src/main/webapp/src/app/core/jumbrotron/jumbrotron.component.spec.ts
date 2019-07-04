import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JumbrotronComponent } from './jumbrotron.component';

describe('JumbrotronComponent', () => {
  let component: JumbrotronComponent;
  let fixture: ComponentFixture<JumbrotronComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JumbrotronComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JumbrotronComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
