export class CadastroModel {
    nome!:string;
    email!:string;
    phone!:string;
    password!:string;

    constructor(nome:string,email:string,phone:string,password:string){
        this.nome = nome;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}