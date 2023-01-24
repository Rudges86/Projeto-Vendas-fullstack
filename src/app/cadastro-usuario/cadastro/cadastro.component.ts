import { ResponseError } from './../../models/ResponseError';
import { CadastroModel } from './../../models/CadastroModel';
import { CadastroService } from './../../servicos/cadastro.service';
import { Component, OnInit } from '@angular/core';
import{FormBuilder, FormGroup, Validators} from '@angular/forms'

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.scss']
})
export class CadastroComponent implements OnInit {
  fill:boolean = true
  forms:FormGroup = this.fb.group({
    nome:[,[Validators.required]],
    email:['',[Validators.email, Validators.minLength(5),Validators.required]],
    phone:['',[ Validators.minLength(11),Validators.required]],
    password:[,[Validators.maxLength(8), Validators.minLength(5),Validators.required]],
    confPassword:[,[Validators.maxLength(8), Validators.minLength(5),Validators.required]]
  })

  constructor(private cadastro:CadastroService,
    private fb:FormBuilder) { }

  ngOnInit(): void {
  
  }
  cadastrar(){
    this.cadastro.cadastrar(this.forms.value).subscribe({
      next: () => console.log("Ok"),
      error: (error:ResponseError)=> console.log(error.error.message)
    })
  }
  hide(){
    this.fill = !this.fill;
  }

}
