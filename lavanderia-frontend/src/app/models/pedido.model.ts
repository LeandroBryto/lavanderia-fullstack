export interface Pedido {
    id: number;
    clienteNome: string;
    tipoServico: string;
    roupas: string[];
    prazo: string; // Ou Date, dependendo da necessidade
    status: string;
  }
  