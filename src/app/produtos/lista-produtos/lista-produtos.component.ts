import { IProduto } from './../../models/IProduto';
import { ProdutosService } from 'src/app/servicos/produtos.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-produtos',
  templateUrl: './lista-produtos.component.html',
  styleUrls: ['./lista-produtos.component.scss']
})
export class ListaProdutosComponent implements OnInit {
  produtos !: IProduto[];

  constructor(
    private produtoService: ProdutosService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.produtoService.getAllProdutos().subscribe({
      next: (produtos) => this.produtos = produtos,
      error: (erros) => console.log(erros)
    })
  }
 
 //Resolver remover o opcional da interface, transformar em classe
  deletaProduto(id: number | undefined, posicao:number) {
    if (id) {
      this.produtoService.deleta(id).subscribe({
        next: () => {
          this.produtos.splice(posicao, 1)
          console.log(this.produtos)
        },
        error: (erro) => console.log(erro)
      })
    }
  }
}
