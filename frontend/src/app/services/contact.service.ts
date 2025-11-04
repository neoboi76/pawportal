import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ContactForm } from '../models/contact.model';

@Injectable({
  providedIn: 'root'
})
export class ContactService {
  private apiUrl = 'http://localhost:8080/contact';

  constructor(private http: HttpClient) {}

  submitContactForm(contact: ContactForm): Observable<ContactForm> {
    return this.http.post<ContactForm>(this.apiUrl, contact);
  }
}
