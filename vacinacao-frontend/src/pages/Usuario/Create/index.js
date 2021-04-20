import React from 'react';
import {Col, Form, FormGroup, Label, Input, Button} from 'reactstrap';
import './style.css';

function Create() {
  return (
    <Form>
        <FormGroup row>
            <Label for="nome" sm={2}>Nome</Label>
            <Input type="text" name="nome" id="nome" placeholder="Ex: João da Silva"/>
        
        </FormGroup>
        <FormGroup>
            <Label for="idade">Idade</Label>
            <Input type="number" name="idade" id="idade" placeholder="50"/>
        </FormGroup>
        <FormGroup>
            <Label for="dataNasc">Data de Nascimento</Label>
            <Input type="date" name="dataNasc" id="dataNasc"/>
        </FormGroup>
        <FormGroup>
            <Label for="cidade">Cidade</Label>
            <Input type="text" name="cidade" id="cidade" placeholder="São Paulo"/>
        </FormGroup>
        <FormGroup>
            <Label for="estado">Estado</Label>
            <Input type="text" name="estado" id="estado" placeholder="São Paulo"/>
        </FormGroup>
        <FormGroup>
            <Label for="email">Email</Label>
            <Input type="email" name="email" id="email" placeholder="joao@example.com"/>
        </FormGroup>
        <Button>Cadastrar</Button>
    </Form>
  )
};

export default Create;