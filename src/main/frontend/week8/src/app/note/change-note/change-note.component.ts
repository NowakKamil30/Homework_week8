import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { NoteService } from 'src/app/services/note.service';
import { Note } from 'src/app/models/Note.model';

@Component({
  selector: 'app-change-note',
  templateUrl: './change-note.component.html',
  styleUrls: ['./change-note.component.scss']
})
export class ChangeNoteComponent implements OnInit {
  noteForm: FormGroup;
  note: Note;
  constructor(
    private noteService: NoteService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    this.noteForm = new FormGroup({
      note: new FormControl('')
    });
   }

  ngOnInit(): void {
    this.activatedRoute
      .queryParams
      .subscribe((params: Params) => {
        this.note = JSON.parse(params.note);
        this.noteForm.setValue({
          note: this.note.note
        });
      });
  }

  onSubmit(): void {
    const {value: note}: {value: Note} = this.noteForm;
    this.noteService
    .putNote(this.note.id, note)
    .subscribe(() => this.router.navigate(['/note', 'show']));
  }


}
