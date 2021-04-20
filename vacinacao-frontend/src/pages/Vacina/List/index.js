import React, { useEffect, useState } from 'react';
import { Table, Container } from 'reactstrap';
import {Link} from 'react-router-dom';
import api from '../../../services/api';
import Header from '../../../components/Header';

function List() {

  const [vacinas, setVacinas] = useState([]);


  useEffect(() => {
    api.get('/vacinas').then(response => {
      setVacinas(response.data);
    })
  }, [vacinas]);
    return (
      <>
        <Header/>
        <h1 className="text-center">Vacinas Cadastradas</h1>
        <Container fluid>
          <Table striped responsive hover size="xs">
            <thead>
              <tr>
                <th>#</th>
                <th>Nome da Vacina</th>
                <th>Total de Doses</th>
                <th>Ações</th>
              </tr>
            </thead>
            <tbody>
              {vacinas?.map(vacina => (
                <tr key={vacina.id}>
                  <th scope="row">vacina.id</th>
                  <td>vacina.nome</td>
                  <td>vacina.totalDoses</td>
                  <td><Link to={`/vacinas/editar/${vacina.id}`}>Editar</Link></td>
                  <td>Excluir</td>
                </tr>
              ))}
              <tr>
                  <th scope="row">vacinas?.id</th>
                  <td>vacinas?.nome</td>
                  <td>vacinas?.totalDoses</td>
                  <td><Link to={`/vacinas/editar/${vacinas?.id}`}>Editar</Link></td>
                  <td>Excluir</td>
                </tr>
                <tr>
                  <th scope="row">vacinas?.id</th>
                  <td>vacinas?.nome</td>
                  <td>vacinas?.totalDoses</td>
                  <td>Editar</td>
                  <td>Excluir</td>
                </tr>
            </tbody>
          </Table>
        </Container>
    </>
    );
}

export default List;