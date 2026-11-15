import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Categorie } from '../models/categorie';

@Injectable({
  providedIn: 'root'
})
export class CategorieService {
  private baseUrl = 'http://localhost:8081/api/cat';

  constructor(private http: HttpClient) {}

  getAll() {
    return this.http.get<any[]>(this.baseUrl);
  }

  getCat(idCat: number) {
    return this.http.get<Categorie>(this.baseUrl + idCat);
  }

  supprimer(id: number) {
    return this.http.delete(this.baseUrl + '/del/' + id);
  }
}

