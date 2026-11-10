import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  public userConnect: any = null;

  private baseUrl = 'http://localhost:3000/api/auth';

  constructor(public http: HttpClient) {}

  register(data: any) {
    return this.http.post<any>(this.baseUrl + '/inscription', data);
  }
}