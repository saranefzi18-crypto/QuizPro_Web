import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Utilisateur } from '../models/utilisateur';

@Injectable({
    providedIn: 'root'
})
export class AdminService {

    private baseUrl = 'http://localhost:8081/api/utilisateurs';

    constructor(private http: HttpClient) { }

    getAllUtilisateurs(): Observable<Utilisateur[]> {
        return this.http.get<Utilisateur[]>(this.baseUrl);
    }

    deleteUtilisateur(id: number): Observable<void> {
        return this.http.delete<void>(`${this.baseUrl}/${id}`);
    }
}