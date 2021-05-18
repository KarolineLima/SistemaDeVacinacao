import React, {useState, useEffect} from 'react';
import Header from '../../components/Header';
import api from '../../services/api';
import { 
  Container,
  Row,
  Col
} from 'reactstrap';

import './style.css';

function Dashboard() {
  const [values, setValues] = useState();
  
  useEffect(() => {
    api.get('/dashboard').then(response => {
      setValues(response.data);
    })
  }, [values]);

  return (
      <>
        <Header/>
        <Container fluid className="container-dashboard">
          <Row xs="2">
            <Col>
              <div>
                  Usuários cadastrados atualmente
                  <br/>
                  {values?.usuaarios}  
              </div>
            </Col>
            <Col>
              <div>
                  Vacinas cadastradas atualmente
                  <br/>
                  {values?.vacinas}
              </div>
            </Col>
          </Row>
          <Row className="row-vacinacao">
            <Col>
              <div>
                Vacinações Cadastradas
                <br />
                {values?.vacinacoes}
              </div>
            </Col>
          </Row>
        </Container>
      </>
  );
}

export default Dashboard;