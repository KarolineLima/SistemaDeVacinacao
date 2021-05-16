import React from 'react';
import Header from '../../components/Header';
import { 
  Container,
  Row,
  Col
} from 'reactstrap';

import './style.css';

function Dashboard() {
  return (
      <>
        <Header/>
        <Container fluid className="container-dashboard">
          <Row xs="2">
            <Col>
              <div>
                  Usuários cadastrados atualmente
                  <br/>
                  500       
              </div>
            </Col>
            <Col>
              <div>
                  Vacinas cadastradas atualmente
                  <br/>
                  500
              </div>
            </Col>
          </Row>
          <Row className="row-vacinacao">
            <Col>
              <div>
                Vacinações Cadastradas
                <br />
                500
              </div>
            </Col>
          </Row>
        </Container>
      </>
  );
}

export default Dashboard;