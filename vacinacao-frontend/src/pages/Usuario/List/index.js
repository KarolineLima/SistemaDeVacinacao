import React from 'react';
import {Link} from 'react-router-dom';
import { Table, Container } from 'reactstrap';
import Header from '../../../components/Header';

function List() {
    return (
      <>
      <Header/>
      <h1 className="text-center">Usuários Cadastrados</h1>
      <Container fluid>
        <Table striped>
          <thead>
            <tr>
              <th>#</th>
              <th>Nome da Vacina</th>
              <th>Total de Doses</th>
              <th>Ações</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">1</th>
              <td>Mark</td>
              <td>Otto</td>
              <td><Link to={`/usuarios/editar/1`}>Editar</Link></td>
              <td>Excluir</td>
            </tr>
          </tbody>
        </Table>
      </Container>
    </>
    );
}

export default List;