import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NoteNavComponent } from './note-nav.component';

describe('NoteNavComponent', () => {
  let component: NoteNavComponent;
  let fixture: ComponentFixture<NoteNavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NoteNavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NoteNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
