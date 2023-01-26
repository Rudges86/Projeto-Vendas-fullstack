import { ListaProdutosComponent } from './produtos/lista-produtos/lista-produtos.component';
import { HomeComponent } from './templates/home/home.component';
import { CadastroProdutosComponent } from './produtos/cadastro-produtos/cadastro-produtos.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroComponent } from './cadastro-usuario/cadastro/cadastro.component';

const routes: Routes = [
  {path:"home",component:HomeComponent},
  {path:"cadastro-cliente",component:CadastroComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
