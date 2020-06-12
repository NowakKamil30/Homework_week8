import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { NoteService } from 'src/app/services/note.service';
import { Note } from 'src/app/models/Note.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-note',
  templateUrl: './create-note.component.html',
  styleUrls: ['./create-note.component.scss']
})
export class CreateNoteComponent implements OnInit {
  noteForm: FormGroup;
  constructor(
    private noteService: NoteService,
    private router: Router
  ) {
    this.noteForm = new FormGroup({
      note: new FormControl('')
    });
   }

  ngOnInit(): void {
  }

  onSubmit(): void {
    const {value: note} = this.noteForm;
    this.noteService
    .postNote(note)
    .subscribe(() => this.router.navigate(['/note', 'show']));
  }

}
