import React, { useEffect, useState } from 'react';
import { Table } from 'reactstrap';
import api from '../../../services/api';

function List() {

  const [vacinas, setVacinas] = useState([]);


  useEffect(() => {
    api.get('/vacinas').then(response => {
      setVacinas(response.data);
    })
  }, [vacinas]);
    return (
    <Table dark>
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
            <td>Editar</td>
            <td>Excluir</td>
          </tr>
        ))}
      </tbody>
    </Table>
    );
}

export default List;