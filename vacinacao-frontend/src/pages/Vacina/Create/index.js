import React, { useState } from 'react';
import { Container, Form, FormGroup, Label, Input, Button} from 'reactstrap';
import Header from '../../../components/Header';
import api from '../../../services/api';
import { useHistory } from 'react-router-dom';
import './style.css';

function Create() {
  const [nomeVacina, setNomeVacina] = useState();
  const [totalDoses, setTotalDoses] = useState();
  const [intervalo, setIntervalo] = useState();
  const history = useHistory();

  
  async function handleCadastro(e){
    e.preventDefault();
    try {
      const response = await api.post('vacinas', 
          {nomeVacina, totalDoses, intervalo, headers: {
            "Access-Control-Allow-Origin": "*"
          }}
      );
      history.push('/vacinas')
    } catch (error) {
      console.log(error)
    }
  }
  return (
    <>
      <Header/>
      <h1 className="text-center">Cadastrar Nova Vacina</h1>
      <Container fluid className="container-vacina">
        <Form fluid onSubmit={handleCadastro} className="w-50">
            <FormGroup row>
                <Label for="nomeVacina" sm={2}>Nome</Label>
                <Input 
                  type="text" 
                  name="nomeVacina" 
                  id="nomeVacina" 
                  placeholder="Ex: Coronavac"
                  required
                  onChange={e => setNomeVacina(e.target.value)}  
                />
            </FormGroup>
            <FormGroup row>
                <Label for="totalDoses" sm={6}>Total de Doses</Label>
                <Input 
                  type="number" 
                  name="totalDoses" 
                  id="totalDoses" 
                  placeholder="Ex: 150"
                  required
                  onChange={e => setTotalDoses(e.target.value)}
                />
            </FormGroup>
            <FormGroup row>
                <Label for="intervalo" sm={6}>Intervalo</Label>
                <Input 
                  type="number" 
                  name="intervalo" 
                  id="intervalo" 
                  placeholder="Ex: 21"
                  required
                  onChange={e => setIntervalo(e.target.value)}
                />
            </FormGroup>
            
            <Button type="submit" className="btn-vacina">Cadastrar</Button>
        </Form>
      </Container>
    </>
  )
};

export default Create;