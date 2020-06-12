import { Component, OnInit } from '@angular/core';
import { NoteService } from 'src/app/services/note.service';
import { Note } from 'src/app/models/Note.model';

@Component({
  selector: 'app-show-notes',
  templateUrl: './show-notes.component.html',
  styleUrls: ['./show-notes.component.scss']
})
export class ShowNotesComponent implements OnInit {
  notes: Note[];
  constructor(
    private noteService: NoteService
  ) { }

  ngOnInit(): void {
    this.noteService
    .getNotes()
    .subscribe((notes: Note[]) => {
      this.notes = notes;
    });
  }

}
