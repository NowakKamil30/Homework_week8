import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Note } from '../models/Note.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class NoteService {

  constructor(
    private http: HttpClient
  ) { }

  getNotes(): Observable<Note[]> {
    return this.http
      .get<Note[]>(`${environment.url}/note`);
  }

  postNote(note: Note): Observable<Note> {
    return this.http
      .post<Note>(`${environment.url}/note`, note);
  }
  deleteNote(id: number): Observable<any> {
    return this.http
      .delete<any>(`${environment.url}/note/${id}`);
  }
  putNote(id: number, note: Note): Observable<Note> {
    return this.http
      .put<Note>(`${environment.url}/note/${id}`, note);
  }
}
