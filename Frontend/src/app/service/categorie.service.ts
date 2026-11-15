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
<<<<<<< HEAD
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
=======

  supprimer(id: number) {
    return this.http.delete(this.baseUrl + '/del/' + id);
  }
}

>>>>>>> 7252554583b1a8eadfebf1965e43e1ae6bfd5ee9
