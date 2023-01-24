import { Icategoria } from './../models/Icategorias';
import { ResponseError } from './../models/ResponseError';
import { IProduto } from './../models/IProduto';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CadastroprodCateService {

  urlCategoria = "http://localhost:8080/categoria"
  urlProduto = "http://localhost:8080/produto"
  constructor(private http:HttpClient) { }

  pegarCategorias():Observable<any>{
    return this.http.get<any>(this.urlCategoria);
  }

  cadastrarProduto(produto:IProduto):Observable<ResponseError>{
    return this.http.post<ResponseError>(this.urlProduto,produto)
  }

  cadastrarCategoria(categoria:Icategoria):Observable<ResponseError>{
    return this.http.post<ResponseError>(this.urlCategoria,categoria)
  }
}
