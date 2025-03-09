import { Component, OnInit } from '@angular/core';
import { PedidoService } from '../../services/pedido.service';
import { Pedido } from '../../models/pedido.model';
import { Router, RouterModule } from '@angular/router'; // Importe o RouterModule
import { CommonModule, } from '@angular/common';

@Component({
  selector: 'app-listar-pedidos',
  standalone: true,
  imports: [CommonModule, RouterModule], // Adicione o RouterModule aqui
  templateUrl: './listar-pedidos.component.html',
  styleUrls: ['./listar-pedidos.component.css']
})
export class ListarPedidosComponent implements OnInit {
  pedidos: Pedido[] = [];

  constructor(private pedidoService: PedidoService, private router: Router) { }

  ngOnInit(): void {
    this.carregarPedidos();
  }

  carregarPedidos(): void {
    this.pedidoService.listarPedidos().subscribe(
      (data) => {
        this.pedidos = data;
      },
      (error) => {
        console.error('Erro ao carregar pedidos:', error);
      }
    );
  }

  converterParaDate(prazo: string): Date {
    return new Date(prazo);
  }

  editarPedido(id: number): void {
    this.router.navigate(['/pedidos/editar', id]); // Navega para a página de edição
  }

  excluirPedido(id: number): void {
    if (confirm('Tem certeza que deseja excluir este pedido?')) {
      this.pedidoService.excluirPedido(id).subscribe(
        () => {
          this.carregarPedidos(); // Recarrega a lista após a exclusão
        },
        (error) => {
          console.error('Erro ao excluir pedido:', error);
        }
      );
    }
  }
}