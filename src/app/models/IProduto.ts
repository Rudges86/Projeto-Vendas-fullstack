import { Icategoria } from './Icategorias';


export interface IProduto {
  "id"?:number,
  "nome": string,
  "descricao": string,
  "preco": number,
  "categoria": Icategoria,
  "dataCadastro"?: string
}



