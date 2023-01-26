import { RouterModule } from '@angular/router';
import { ProdutosRoutingModule } from './produtos-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CadastroProdutosComponent } from './cadastro-produtos/cadastro-produtos.component';
import { ListaProdutosComponent } from './lista-produtos/lista-produtos.component';



@NgModule({
  declarations: [
    CadastroProdutosComponent,
    ListaProdutosComponent
  ],
  imports: [
    CommonModule,
    ProdutosRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule
  ],
  exports:[
    CadastroProdutosComponent,
    ListaProdutosComponent
  ]
})
export class ProdutosModule { }
