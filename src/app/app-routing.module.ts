import { CadastroProdutosComponent } from './produtos/cadastro-produtos/cadastro-produtos.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroComponent } from './cadastro-usuario/cadastro/cadastro.component';

const routes: Routes = [
  {path:"",component:CadastroProdutosComponent}
  //{path:"",component:CadastroComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
