import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarPedidoComponent } from './editar-pedidos.component';

describe('EditarPedidosComponent', () => {
  let component: EditarPedidoComponent;
  let fixture: ComponentFixture<EditarPedidoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarPedidoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarPedidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
