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
  ajouterCategorie(categorie: Categorie) {
    return this.http.post<Categorie>(this.baseUrl + "/categorie/add", categorie);
  }

  // 4. Accepter une catégorie
  accepterCategorie(idCat: number) {
    return this.http.put<Categorie>(this.baseUrl + "/categorie/accepter/" + idCat, {});
  }


  refuserCategorie(idCat: number) {
    return this.http.put<Categorie>(this.baseUrl + "/categorie/refuser/" + idCat, {});
  }
}