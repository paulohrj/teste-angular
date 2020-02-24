import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { ClienteService } from '../cliente-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cliente-form',
  templateUrl: './cliente-form.component.html',
  styleUrls: ['./cliente-form.component.css']
})
export class ClienteFormComponent implements OnInit {

  formGroup: FormGroup;

  constructor(private _fb: FormBuilder, private _clienteService: ClienteService, private _router: Router) {
    this.formGroup = this._fb.group({
      id: new FormControl(null),
      nome: new FormControl(null, [Validators.required]),
      email: new FormControl(null, [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+')]),
      cpf: new FormControl(null, [Validators.required]),
      dataNascimento: new FormControl(null, [Validators.required]),
    });

  }

  public salvar(){
    this._clienteService.saveCliente(this.formGroup.getRawValue()).subscribe(result => {
      this._router.navigate(['/cliente']);
    })
  }

  public cancelar(){
    this._router.navigate(['/cliente']);
  }

  ngOnInit() {

  }

}
