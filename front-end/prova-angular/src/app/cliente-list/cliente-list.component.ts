import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente-service';
import {Router} from "@angular/router"

@Component({
  selector: 'app-cliente-list',
  templateUrl: './cliente-list.component.html',
  styleUrls: ['./cliente-list.component.css']
})
export class ClienteListComponent implements OnInit {

  displayedColumns: string[] = ['id', 'nome', 'cpf', 'email', 'dataNascimento', 'idade'];

  dataSource: Cliente[];
  
  constructor(private _clienteService: ClienteService, private _router: Router){

  }

  public novoCliente(){
    this._router.navigate(['/cliente/novo']);
  }

  public ngOnInit(){

    this._clienteService.getClientes().subscribe(clientes =>{
      this.dataSource = clientes;
    })
  }

}
