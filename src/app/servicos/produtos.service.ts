import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IProduto } from './../models/IProduto';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProdutosService {
  url:string = "http://localhost:8080/produto"
  constructor(private http:HttpClient) { }

  cadastrarProduto(produto:IProduto):Observable<IProduto>{
    return this.http.post<IProduto>(this.url,produto);
  }

  getAllProdutos():Observable<IProduto[]>{
    return this.http.get<IProduto[]>(this.url);
  }


  deleta(id:number):Observable<IProduto>{
    return this.http.delete<IProduto>(`${this.url}/${id}`)
  }
}
