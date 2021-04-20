import React from 'react';
import {Col, Form, FormGroup, Label, Input, Button} from 'reactstrap';
import './style.css';

function Update() {
  return (
    <Form>
        <FormGroup row>
            <Label for="nome" sm={2}>Nome</Label>
            <Input type="text" name="nome" id="nome"/>
        </FormGroup>
        <FormGroup>
            <Label for="idade">Idade</Label>
            <Input type="number" name="idade" id="idade"/>
        </FormGroup>
        <FormGroup>
            <Label for="dataNasc">Data de Nascimento</Label>
            <Input type="date" name="dataNasc" id="dataNasc"/>
        </FormGroup>
        <FormGroup>
            <Label for="cidade">Cidade</Label>
            <Input type="text" name="cidade" id="cidade"/>
        </FormGroup>
        <FormGroup>
            <Label for="estado">Estado</Label>
            <Input type="text" name="estado" id="estado"/>
        </FormGroup>
        <FormGroup>
            <Label for="email">Email</Label>
            <Input type="email" name="email" id="email"/>
        </FormGroup>
        <Button>Salvar</Button>
    </Form>
  )
};

export default Update;