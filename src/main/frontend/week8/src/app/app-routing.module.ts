import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NoteMainComponent } from './note/note-main/note-main.component';
import { ShowNotesComponent } from './note/show-notes/show-notes.component';
import { CreateNoteComponent } from './note/create-note/create-note.component';
import { ChangeNoteComponent } from './note/change-note/change-note.component';


const routes: Routes = [
  {path: '', redirectTo: 'note', pathMatch: 'full'},
  {path: 'note', component: NoteMainComponent, children: [
    {path: '', redirectTo: 'show', pathMatch: 'full'},
    {path: 'show', component: ShowNotesComponent},
    {path: 'create', component: CreateNoteComponent},
    {path: 'edit', component: ChangeNoteComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
