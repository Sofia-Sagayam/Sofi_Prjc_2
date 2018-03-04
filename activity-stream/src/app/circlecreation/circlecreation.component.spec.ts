import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CirclecreationComponent } from './circlecreation.component';

describe('CirclecreationComponent', () => {
  let component: CirclecreationComponent;
  let fixture: ComponentFixture<CirclecreationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CirclecreationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CirclecreationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
