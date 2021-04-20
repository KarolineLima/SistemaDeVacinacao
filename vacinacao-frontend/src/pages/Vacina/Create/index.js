import React, { useState } from 'react';
import { Container, Form, FormGroup, Label, Input, Button} from 'reactstrap';
import Header from '../../../components/Header';
import api from '../../../services/api';
import { useHistory } from 'react-router-dom';
import './style.css';

function Create() {
  const [nome, setNome] = useState();
  const [totalDoses, setTotalDoses] = useState();
  const history = useHistory();

  
  async function handleCadastro(e){
    e.preventDefault();
    try {
      const response = await api.post('vacinas', {nome, totalDoses});
      history.push('/vacinas')
    } catch (error) {
      console.log(error)
    }
  }
  return (
    <>
      <Header/>
      <h1 className="text-center"> Cadastrar Nova Vacina</h1>
      <Container>

        
      <Form onSubmit={handleCadastro}>
          <FormGroup row>
              <Label for="nome" sm={2}>Nome</Label>
              <Input 
                type="text" 
                name="nome" 
                id="nome" 
                placeholder="Ex: Coronavac"
                onChange={e => setNome(e.target.value)}  
              />
          </FormGroup>
          <FormGroup row>
              <Label for="totalDoses" sm={2}>Total de Doses</Label>
              <Input 
                type="number" 
                name="totalDoses" 
                id="totalDoses" 
                placeholder="Ex: 150"
                onChange={e => setTotalDoses(e.target.value)}
              />
          </FormGroup>
          
          <Button>Cadastrar</Button>
      </Form>
    </Container>
    </>
  )
};

export default Create;