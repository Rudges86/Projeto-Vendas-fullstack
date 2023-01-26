import { Icategoria } from './../models/Icategorias';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {
  url:string = "http://localhost:8080/categoria"
  constructor(private http:HttpClient) { }

  pegarCategorias():Observable<Icategoria[]>{
    return this.http.get<Icategoria[]>(this.url);
  }

  cadastrarCategoria(categoria:Icategoria):Observable<Icategoria>{
    return this.http.post<Icategoria>(this.url,categoria);
  }
}
