import { Injectable } from '@angular/core';
import { Pessoa } from '../cadastros/model/pessoa';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  apiURL: string =  'http://localhost:8080/Pessoas';

  constructor(private http: HttpClient) { }

  salvar(pessoa: Pessoa): Observable<Pessoa>{
    return this.http.post<Pessoa>(`${this.apiURL}/pessoa/salve`, pessoa);
  }

  alterar(pessoa: Pessoa): Observable<any>{
    return this.http.put<Pessoa>( `${this.apiURL}/${pessoa.id}`, pessoa);
  }

  getAll() : Observable<Pessoa[]>{
    return  this.http.get<Pessoa[]>(this.apiURL);
  }

  getById(id: number):Observable<Pessoa>{
    return  this.http.get<any>( `${this.apiURL}/${id}`);
  }

  deletar(pessoa: Pessoa): Observable<any>{
    return this.http.delete<any>(`${this.apiURL}/${pessoa.id}`);
  }
  listarPessoas(): Observable<Pessoa[]> {
    return this.http.get<Pessoa[]>(`${this.apiURL}/pessoa`);
  }

  getByIdPessoa(id: number): Observable<Pessoa> {
    return this.http.get<Pessoa>(`${this.apiURL}/pessoa/${id}`);
  }

  salvaPessoa(pessoa: Pessoa): Observable<Pessoa> {
    return this.http.post<Pessoa>(`${this.apiURL}/pessoa/salve`, pessoa);
  }

  atualizaPessoa(pessoa: Pessoa): Observable<Pessoa> {
    return this.http.put<Pessoa>(`${this.apiURL}/pessoa/atualiza`, pessoa);
  }

  deleteByIdPessoa(id: number): Observable<string> {
    return this.http.delete<string>(`${this.apiURL}/pessoa/${id}`);
  }


}
