import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CadastroProdutosComponent } from './cadastro-produtos/cadastro-produtos.component';



@NgModule({
  declarations: [
    CadastroProdutosComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports:[
    CadastroProdutosComponent
  ]
})
export class ProdutosModule { }
