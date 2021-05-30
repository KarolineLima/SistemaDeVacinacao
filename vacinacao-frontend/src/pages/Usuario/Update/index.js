import React, {useEffect, useState} from 'react';
import {Container, Form, FormGroup, Label, Input, Button} from 'reactstrap';
import moment from 'moment';

import api from '../../../services/api';
import { useHistory, useParams } from 'react-router-dom';
import Header from '../../../components/Header';

function Update() {
    const [nome, setNome] = useState('');
    const [idade, setIdade] = useState('');
    const [dataNasc, setDataNasc] = useState('');
    const [cidade, setCidade] = useState('');
    const [estado, setEstado] = useState('');
    const [email, setEmail] = useState('');
    const [user, setUser] = useState();
    let data;
    const {id} = useParams();
    const history = useHistory();

    useEffect(async ()=>{
        await api.get('usuarios/'.concat(id))
        .then(response => {
            setUser(response.data) 
            console.log(user.dataNascimento)
            console.log(moment(user.dataNascimento).toDate())
        });
    }, [id]);


    async function handleCadastro(e){
        e.preventDefault();
        try {
          const response = await api.post('usuarios', {
              nome,
              idade,
              dataNasc,
              cidade,
              estado,
              email
          });
          history.push('/usuarios')
        } catch (error) {
          console.log(error)
        }
      }
  return (
      <>
        <Header/>
        <h1 className="text-center">Atualizar Usuário</h1>
        <Container className="container-user">
            <Form fluid className="w-50" onSubmit={handleCadastro}>
                <FormGroup>
                    <Label for="nome"></Label>
                    <Input 
                        type="text" 
                        name="nome" 
                        id="nome"
                        defaultValue={user?.nome || ''}
                        onChange={e => setNome(e.target.value)}
                        required/>
                </FormGroup>
                <FormGroup>
                    <Label for="idade"></Label>
                    <Input 
                        type="number" 
                        name="idade" 
                        id="idade"
                        defaultValue={user?.idade}
                        onChange={e => setIdade(e.target.value)}
                        required/>
                </FormGroup>
                <FormGroup>
                    <Label for="dataNasc"></Label>
                    <Input 
                        type="date" 
                        name="dataNasc" 
                        id="dataNasc"
                        defaultValue={moment(user?.dataNascimento)}
                        onChange={e => setDataNasc(e.target.value)}
                        required
                        />
                </FormGroup>
                <FormGroup>
                    <Label for="cidade"></Label>
                    <Input 
                        type="text" 
                        name="cidade" 
                        id="cidade"
                        defaultValue={user?.cidade}
                        onChange={e => setCidade(e.target.value)}
                        required/>
                </FormGroup>
                <FormGroup>
                    <Label for="estado"></Label>
                    <Input 
                        type="text" 
                        name="estado" 
                        id="estado"
                        defaultValue={user?.estado}
                        onChange={e => setEstado(e.target.value)}
                        required/>
                </FormGroup>
                <FormGroup>
                    <Label for="email"></Label>
                    <Input 
                        type="email" 
                        name="email" 
                        id="email"
                        defaultValue={user?.email}
                        onChange={e => setEmail(e.target.value)}
                        required/>
                </FormGroup>
                <Button type="submit" className="btn-user">Salvar</Button>
            </Form>
        </Container>
      </>
  )
};

export default Update;