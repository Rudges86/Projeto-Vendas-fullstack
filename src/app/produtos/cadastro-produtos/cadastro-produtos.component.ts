
import { IProduto } from './../../models/IProduto';
import { Icategoria } from './../../models/Icategorias';


import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
//Modal
import * as bootstrap from 'bootstrap';
import {Modal} from "bootstrap";
import { BehaviorSubject, Observable } from 'rxjs';
import { ProdutosService } from 'src/app/servicos/produtos.service';
import { CategoriaService } from 'src/app/servicos/categoria.service';
import { Router } from '@angular/router';
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
  constructor(private fb:FormBuilder,
     private produtoService:ProdutosService,
     private categoriaService:CategoriaService,
     private router:Router) { }

  ngOnInit(): void {
    this.categoriaService.pegarCategorias().subscribe({
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
    this.produtoService.cadastrarProduto(produto)
    .subscribe({
      next:()=>{
        this.router.navigate(['/lista-produtos']);
        },
      error:(error) => console.log(error)
    })
  }

  cadastraCategoria(){
    let categoria:Icategoria = this.formProduto.controls['categoria'].value;
    this.categoriaService.cadastrarCategoria(categoria).subscribe({
      next:() => this.categoria.push(categoria),
      error:(error) => console.log(error)
    });
  }

}
