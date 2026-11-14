import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Categorie } from '../models/categorie';

@Injectable({
  providedIn: 'root'
})
export class CategorieService {

  private baseUrl = 'http://localhost:8081/api';

  constructor(public http: HttpClient) { }

  getAllCat() {
    return this.http.get<Categorie[]>(this.baseUrl + "/categorie");
  }

  getCat(idCat: number) {
    return this.http.get<Categorie>(this.baseUrl + "/categorie/" + idCat);
  }
}