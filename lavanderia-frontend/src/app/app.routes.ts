import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarPedidosComponent } from './pages/listar-pedidos/listar-pedidos.component';
import { CriarPedidoComponent } from './pages/criar-pedido/criar-pedido.component';
import { EditarPedidoComponent } from './pages/editar-pedidos/editar-pedidos.component';

export const routes: Routes = [
  { path: '', redirectTo: '/pedidos', pathMatch: 'full' }, // Rota padrão
  { path: 'pedidos', component: ListarPedidosComponent }, // Listar pedidos
  { path: 'pedidos/novo', component: CriarPedidoComponent }, // Criar pedido
  { path: 'pedidos/editar/:id', component: EditarPedidoComponent }, // Editar pedido
  { path: '**', redirectTo: '/pedidos' } // Rota curinga (404)
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }