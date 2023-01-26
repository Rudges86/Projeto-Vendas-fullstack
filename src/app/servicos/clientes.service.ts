import { CadastroModel } from './../models/CadastroModel';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {
  url:string = "http://localhost:8080/users"
  constructor(private http:HttpClient) { }

  cadastrar(cliente:CadastroModel):Observable<CadastroModel>{
    return this.http.post<CadastroModel>(this.url,cliente);
  }

}
