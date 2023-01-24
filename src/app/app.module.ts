import { ProdutosModule } from './produtos/produtos.module';
import { CadastroUsuarioModule } from './cadastro-usuario/cadastro-usuario.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http'

@NgModule({
  declarations: [
    AppComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CadastroUsuarioModule,
    ProdutosModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
