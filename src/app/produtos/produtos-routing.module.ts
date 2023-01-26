import { ListaProdutosComponent } from './lista-produtos/lista-produtos.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroProdutosComponent } from './cadastro-produtos/cadastro-produtos.component';

const routes: Routes = [
    {path:"cadastro-produtos",component:CadastroProdutosComponent},
    {path:"lista-produtos",component:ListaProdutosComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProdutosRoutingModule { }