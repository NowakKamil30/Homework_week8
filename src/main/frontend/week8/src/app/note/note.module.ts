import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShowNotesComponent } from './show-notes/show-notes.component';
import { CreateNoteComponent } from './create-note/create-note.component';
import { ChangeNoteComponent } from './change-note/change-note.component';
import { NoteNavComponent } from './note-nav/note-nav.component';
import { NoteMainComponent } from './note-main/note-main.component';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { NoteCardComponent } from './note-card/note-card.component';



@NgModule({
  declarations: [ShowNotesComponent, CreateNoteComponent, ChangeNoteComponent, NoteNavComponent, NoteMainComponent, NoteCardComponent],
  imports: [
    CommonModule,
    RouterModule,
    ReactiveFormsModule
  ]
})
export class NoteModule { }
