import React, { useEffect, useState } from 'react';
import { Table, Container } from 'reactstrap';
import {Link} from 'react-router-dom';
import api from '../../../services/api';
import Header from '../../../components/Header';
import {MdEdit} from 'react-icons/md';
import {IoMdTrash} from 'react-icons/io';
import './style.css';

function List() {

  const [calendario, setCalendario] = useState([]);


  useEffect(() => {
    api.get('/calendario').then(response => {
      setCalendario(response.data);
    })
  }, [calendario]);
    return (
      <>
        <Header/>
        <h1 className="text-center">Calendarios Cadastrados</h1>
        <Container fluid>
          <Table striped responsive hover size="xs">
            <thead class="lista-vacina">
              <tr>
                <th></th>
                <th>Data Inicial</th>
                <th>Data Final</th>
                <th>Idade Inicial</th>
                <th>Idade Final</th>
                <th>Ações</th>
              </tr>
            </thead>
            <tbody>
              {calendario?.map(cal => (
                <tr key={cal.idCalendario}>
                  <th scope="row">{cal.idCalendario}</th>
                  <td>{cal.DataInicial}</td>
                  <td>{cal.DataFinal}</td>
                  <td>{cal.IdadeInicial}</td>
                  <td>{cal.IdadeFinal}</td>
                  <td><Link to={`/calendario/editar/1`}><MdEdit size={30} color="#2BA8EA"/></Link></td>
                  <td><IoMdTrash size={30} color="#EE0000"/></td>
                </tr>
              ))}
                <tr>
                  <th scope="row">1</th>
                  <td>15/08/2021</td>
                  <td>30/08/2021</td>
                  <td>70 anos</td>
                  <td>80 anos</td>
                  <td><Link to={`/calendario/editar/1`}><MdEdit size={30} color="#2BA8EA"/></Link></td>
                  <td><IoMdTrash size={30} color="#EE0000"/></td>
                </tr>
            </tbody>
          </Table>
        </Container>
    </>
    );
}

export default List;