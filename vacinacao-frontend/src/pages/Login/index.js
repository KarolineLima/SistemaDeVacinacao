import React from 'react';

import {
    Navbar, 
    NavbarBrand, 
    Form, 
    FormGroup, 
    Label, 
    Input, 
    Button,
    Col,
    Container} from 'reactstrap';
import './style.css';

function Login() {
  return (
      <>
        <Navbar dark expand="md" fluid={true}>
            <NavbarBrand fluid={true}><h1>Vaccine</h1></NavbarBrand>
        </Navbar>

        <Container fluid className="container-login">
            <h1 className="text-sm-center text-white login">Vaccine</h1>
            <Form fluid className="form-login">
                <FormGroup row>
                    <Col>
                        <Input type="text" 
                        name="nome" 
                        id="nome" 
                        placeholder="E-mail"
                        className="input-login"/>
                    </Col>
                </FormGroup>
                <FormGroup row>
                    <Col md="12" sm="12">
                        <Input type="password" 
                        name="senha" 
                        id="senha" 
                        placeholder="Senha"
                        className="input-login"/>
                    </Col>
                </FormGroup>
                <Button type="submit" className="btn-login">
                    Login
                </Button>
            </Form>
        </Container>
      </>
  );
}

export default Login;