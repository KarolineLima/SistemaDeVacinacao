import React, { useEffect, useState } from 'react';
import { Form, FormGroup, Label, Input, Button} from 'reactstrap';
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
  )
};

export default Update;