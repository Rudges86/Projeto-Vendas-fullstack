import { IProduto } from './../../models/IProduto';
import { Icategoria } from './../../models/Icategorias';

import { CadastroprodCateService } from './../../servicos/cadastroprod-cate.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
//Modal
import * as bootstrap from 'bootstrap';
import {Modal} from "bootstrap";
import { BehaviorSubject, Observable } from 'rxjs';
@Component({
  selector: 'app-cadastro-produtos',
  templateUrl: './cadastro-produtos.component.html',
  styleUrls: ['./cadastro-produtos.component.scss']
})


export class CadastroProdutosComponent implements OnInit {
  categoria:Icategoria[] = [];
  
  
  //Modal
  openModal:Modal|undefined;

  formProduto:FormGroup = this.fb.group({
    nome:['',[]],
    descricao:['',[]],
    preco:['',[]],
    categoria: this.fb.group({
      id:[,[]],
      nome:['',[]]
    })
    
  })
  constructor(private fb:FormBuilder, private cateService:CadastroprodCateService) { }

  ngOnInit(): void {
    this.cateService.pegarCategorias().subscribe({
      next:(x) => this.categoria = x,
      error: (error) => console.log(error)
    })
  }

  //Abrir modal no bootstrap

  open(){
    this.openModal = new bootstrap.Modal(document.getElementById('exampleModal')!,{
      keyboard:false,
      backdrop:'static'
    })
    this.openModal?.show();
  }

  


  onSubmit(){
    let produto:IProduto =  this.formProduto.value;
    this.cateService.cadastrarProduto(produto)
    .subscribe({
      next:(x)=>{
        this.formProduto.reset();
         console.log(x)

        },
      error:(error) => console.log(error)
    })
  }

  cadastraCategoria(){
    let categoria:Icategoria = this.formProduto.controls['categoria'].value;
    this.cateService.cadastrarCategoria(categoria).subscribe({
      next:() => this.categoria.push(categoria),
      error:(error) => console.log(error)
    });
  }

}
