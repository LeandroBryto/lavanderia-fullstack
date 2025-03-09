import { Component, OnInit } from '@angular/core';
import { PedidoService } from '../../services/pedido.service';
import { Pedido } from '../../models/pedido.model';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-editar-pedido',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './editar-pedidos.component.html',
  styleUrls: ['./editar-pedidos.component.css']
})
export class EditarPedidoComponent implements OnInit {
  pedido: Pedido = {
    id: 0,
    clienteNome: '',
    tipoServico: '',
    roupas: [],
    prazo: '', // Formato yyyy-MM-dd
    status: 'EM_ANDAMENTO'
  };

  roupasInput: string = ''; // Propriedade para armazenar o input do usuário como string

  constructor(
    private pedidoService: PedidoService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.params['id']); // Convertendo ID para número
    if (!isNaN(id) && id > 0) {
      this.carregarPedido(id);
    } else {
      alert('ID do pedido inválido!');
      this.router.navigate(['/pedidos']); // Redireciona se o ID for inválido
    }
  }

  carregarPedido(id: number): void {
    this.pedidoService.buscarPedidoPorId(id).subscribe({
      next: (data) => {
        this.pedido = data;
        this.roupasInput = this.pedido.roupas.join(', '); // Converte a lista de roupas para uma string
      },
      error: (error) => {
        console.error('Erro ao carregar pedido:', error);
        alert('Erro ao carregar o pedido. Verifique a conexão com o servidor.');
        this.router.navigate(['/pedidos']);
      }
    });
  }

  atualizarPedido(): void {
    // Transforma a string de roupas em uma lista
    this.pedido.roupas = this.roupasInput.split(',').map(item => item.trim());

    // Garante que o prazo esteja no formato yyyy-MM-dd
    this.pedido.prazo = this.formatarData(this.pedido.prazo);

    this.pedidoService.atualizarPedido(this.pedido.id, this.pedido).subscribe({
      next: () => {
        alert('Pedido atualizado com sucesso!');
        this.router.navigate(['/pedidos']);
      },
      error: (error) => {
        console.error('Erro ao atualizar pedido:', error);
        alert('Erro ao atualizar o pedido. Tente novamente.');
      }
    });
  }

  // Método para formatar a data no padrão yyyy-MM-dd
  private formatarData(data: string): string {
    const date = new Date(data);
    const year = date.getFullYear();
    const month = ('0' + (date.getMonth() + 1)).slice(-2); // Adiciona zero à esquerda
    const day = ('0' + date.getDate()).slice(-2); // Adiciona zero à esquerda
    return `${year}-${month}-${day}`;
  }
}