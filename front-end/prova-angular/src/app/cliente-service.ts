import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Cliente } from './cliente';
import { Observable  } from 'rxjs';


@Injectable({
    providedIn: 'root'
  })
  export class ClienteService {
  
    url = 'http://localhost:8080/cliente'; 

    constructor(private httpClient: HttpClient) { }
  
    httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    }

    getClientes(): Observable<Cliente[]> {
      return this.httpClient.get<Cliente[]>(this.url);
    }
  
    getClienteById(id: string): Observable<Cliente> {
      return this.httpClient.get<Cliente>(this.url + '/' + id);
    }
  
    saveCliente(cliente: Cliente): Observable<Cliente> {
      return this.httpClient.post<Cliente>(this.url, JSON.stringify(cliente), this.httpOptions);
    }

    deleteCar(cliente: Cliente) {
      return this.httpClient.delete<Cliente>(this.url + '/' + cliente.id, this.httpOptions);
    }
  
  }