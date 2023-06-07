import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PessoaListaComponent } from './cadastros/pessoa-lista/pessoa-lista.component';
import { PessoaFormComponent } from './cadastros/pessoa-form/pessoa-form.component';

const routes: Routes = [
  { path : 'home', component: HomeComponent },
  { path : 'pessoa-lista', component: PessoaListaComponent },
  { path : 'pessoa-form', component: PessoaFormComponent },
  { path: 'pessoa-form/:id', component: PessoaFormComponent},
  { path : 'home', component: HomeComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full'}
 

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
