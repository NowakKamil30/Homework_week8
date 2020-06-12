import { Component, OnInit, Input } from '@angular/core';
import { Note } from 'src/app/models/Note.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-note-card',
  templateUrl: './note-card.component.html',
  styleUrls: ['./note-card.component.scss']
})
export class NoteCardComponent implements OnInit {
  @Input() note: Note;
  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  edit(): void {
    this.router.navigate(['/note', 'edit'], {queryParams: {
      note: JSON.stringify(this.note)
    }});
  }

}
