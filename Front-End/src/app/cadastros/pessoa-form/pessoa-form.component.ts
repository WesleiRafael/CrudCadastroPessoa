import { Component } from '@angular/core';
import { Pessoa } from '../model/pessoa';
import { PessoaService } from 'src/app/services/pessoa.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-pessoa-form',
  templateUrl: './pessoa-form.component.html',
  styleUrls: ['./pessoa-form.component.css']
})
export class PessoaFormComponent implements OnInit {

  pessoa: Pessoa = new Pessoa();
  success: boolean = false;
  errors: String[] = [];
  id: number = 0;

  constructor( 
    private service: PessoaService, 
    private router: Router, 
    private activatedRoute: ActivatedRoute,
    private http: HttpClient){
    this.pessoa = new Pessoa();
    this.router.routeReuseStrategy.shouldReuseRoute = function(){return false;}
  }

  ngOnInit(): void {
      let params : Observable<Params> = this.activatedRoute.params;
      params.subscribe( urlParams => {
          this.id = urlParams['id'];
          this.service.getById(this.id).subscribe( response => this.pessoa = response, errorResponse => this.pessoa = new Pessoa() )
      })
      console.log(params);
  }

  voltarParaListagem(){
    this.router.navigateByUrl("/pessoa-lista", { skipLocationChange: true });
    this.router.navigate(['/pessoa-lista']);
  }



  onSubmit(){
    if(this.id){
      this.service.alterar(this.pessoa)
          .subscribe(response => {
            this.success = true;
            this.errors = [];
          }, errorResponse => {
            this.errors = ['Erro ao alterar a pessoa']
          }
      )
    }else{
      this.service.salvar(this.pessoa).subscribe( response => {
        this.success = true;
        this.errors = [];
        this.pessoa = response;
      }, errorResponse => {
          this.success = false;
          this.errors = errorResponse.error.errors;
      }
      )
    }
    this.voltarParaListagem();
  }

}
