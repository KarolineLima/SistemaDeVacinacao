import React from 'react';
import { Table } from 'reactstrap';

function List() {
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
        <tr>
          <th scope="row">1</th>
          <td>Mark</td>
          <td>Otto</td>
          <td>@mdo</td>
          <td>@mdo</td>
        </tr>
      </tbody>
    </Table>
    );
}

export default List;