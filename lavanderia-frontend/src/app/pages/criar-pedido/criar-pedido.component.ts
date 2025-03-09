import { Component } from '@angular/core';
import { PedidoService } from '../../services/pedido.service';
import { Pedido } from '../../models/pedido.model';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-criar-pedido',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './criar-pedido.component.html',
  styleUrls: ['./criar-pedido.component.css']
})
export class CriarPedidoComponent {
  pedido: Pedido = {
    id: 0,
    clienteNome: '',
    tipoServico: '',
    roupas: [], // Inicializado como array vazio
    prazo: '', // Formato yyyy-MM-dd
    status: 'EM_ANDAMENTO'
  };

  roupasInput: string = ''; // Propriedade para armazenar o input do usuário como string

  constructor(private pedidoService: PedidoService, private router: Router) { }

  criarPedido(): void {
    // Transforma a string de roupas em uma lista
    this.pedido.roupas = this.roupasInput.split(',').map(item => item.trim());

    // Garante que o prazo esteja no formato yyyy-MM-dd
    this.pedido.prazo = this.formatarData(this.pedido.prazo);

    this.pedidoService.criarPedido(this.pedido).subscribe(
      () => {
        this.router.navigate(['/pedidos']); // Redireciona para a lista de pedidos
      },
      (error) => {
        console.error('Erro ao criar pedido:', error);
      }
    );
  }

  // Método para formatar a data no padrão yyyy-MM-dd
  private formatarData(data: string): string {
    const date = new Date(data);
    const year = date.getFullYear();
    const month = ('0' + (date.getMonth() + 1)).slice(-2); // Adiciona zero à esquerda
    const day = ('0' + date.getDate()).slice(-2); // Adiciona zero à esquerda
    return `${year}-${month}-${day}`; // Formato yyyy-MM-dd
  }
}