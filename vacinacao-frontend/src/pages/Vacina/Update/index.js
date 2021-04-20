import React, { useEffect, useState } from 'react';
import { Container, Form, FormGroup, Label, Input, Button} from 'reactstrap';
import Header from '../../../components/Header';
import api from '../../../services/api';
import { useHistory, useParams } from 'react-router-dom';
import './style.css';

function Update() {
  const [nome, setNome] = useState();
  const [totalDoses, setTotalDoses] = useState();
  const {id} = useParams();
  const history = useHistory();

  useEffect(() => {
      api.get('vacinas/'.concat(id)).then(response => {
          setTotalDoses(response.totalDoses);
          setNome(response.nome);
      })
  }, [id]);

  async function handleCadastro(e){
    e.preventDefault();
    try {
      const response = await api.put('vacinas'.concat(id), {nome, totalDoses});
    } catch (error) {
      history.pushState('/vacinas')
    }
  }
  return (
    <>
      <Header/>
      <h1 className="text-center">Atualizar Vacina</h1>
      <Container>          
        <Form onSubmit={handleCadastro}>
            <FormGroup row>
                <Label for="nome" sm={2} value={nome}></Label>
                <Input 
                  type="text" 
                  name="nome" 
                  id="nome" 
                  onChange={e => setNome(e.target.value)}  
                />
            </FormGroup>
            <FormGroup row>
                <Label for="totalDoses" sm={2} value={totalDoses}></Label>
                <Input 
                  type="number" 
                  name="totalDoses" 
                  id="totalDoses"
                  onChange={e => setTotalDoses(e.target.value)}
                />
            </FormGroup>
            
            <Button>Atualizar</Button>
        </Form>
    </Container>
    </>
  )
};

export default Update;