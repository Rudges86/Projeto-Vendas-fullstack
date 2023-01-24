import { CadastroModel } from './../models/CadastroModel';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CadastroService {
  url = "http://localhost:8080/users"

  constructor(private http:HttpClient) { }

  cadastrar(cadastro:CadastroModel):Observable<CadastroModel>{
    return this.http.post<CadastroModel>(this.url,cadastro);
  }

}
