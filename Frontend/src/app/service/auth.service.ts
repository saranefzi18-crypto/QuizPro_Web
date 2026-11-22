import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Utilisateur } from '../models/utilisateur';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'http://localhost:8081/api/auth';

  userConnecte: Utilisateur | null = null;

  constructor(public http: HttpClient) {}

  login(data: any) {
    return this.http.post<any>(this.baseUrl+"/login", data);
  }
  register(data: any) {
    return this.http.post<any>(this.baseUrl + '/inscription', data);
  }
  
}