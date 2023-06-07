import { Component } from '@angular/core';
import { Pessoa } from '../model/pessoa';
import { Router } from '@angular/router';
import { PessoaService } from 'src/app/services/pessoa.service';
import { OnInit } from '@angular/core';

@Component({
  selector: 'app-pessoa-lista',
  templateUrl: './pessoa-lista.component.html',
  styleUrls: ['./pessoa-lista.component.css']
})
export class PessoaListaComponent  implements OnInit {
[x: string]: any;
editarPessoa(arg0: any) {
throw new Error('Method not implemented.');
}

  pessoaLista: Pessoa[] = [];
  pessoaSelecionado: Pessoa = new Pessoa();
  mensagemSucesso: String = "";
  mensagemErro: String = "";
pessoas: any;

  constructor(
      private service: PessoaService,
      private router: Router) {
  }
  

  ngOnInit(): void {
    this.service.getAll().subscribe( resposta => this.pessoaLista = resposta);
  }

  novoCadastro(){
      this.router.navigate(['/pessoa-form'])
  }

  preparaDelecao(pessoa: Pessoa){
      this.pessoaSelecionado = pessoa;
  }

  deletar(){
      this.service
        .deletar(this.pessoaSelecionado)
        .subscribe(
        response => {
          this.mensagemSucesso = 'Pessoa deletada com sucesso'
          this.ngOnInit();
        },
        erro => this.mensagemErro = 'Ocorreu um erro ao deletar a pessoa'
    )
}
excluirPessoa(id: number) {
  if (confirm('Tem certeza de que deseja excluir esta pessoa?')) {
    this['pessoaService'].excluirPessoa(id).subscribe(
      () => {
        alert('Pessoa excluída com sucesso!');
        this['listarPessoas']();
      },
      (error: any) => {
        console.log(error);
      }
    );
  }

}

}