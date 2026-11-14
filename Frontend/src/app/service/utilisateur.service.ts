import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {
  private baseUrl = 'http://localhost:8081/api/utilisateurs';

  constructor(private http: HttpClient) {}

  getAll() {
    return this.http.get<any[]>(this.baseUrl);
  }

  desactiver(id: number) {
    return this.http.put<any>(this.baseUrl + '/' + id + '/desactiver', {});
  }

  activer(id: number) {
    return this.http.put<any>(this.baseUrl + '/' + id + '/activer', {});
  }
}
