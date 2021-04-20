import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Create from './pages/Vacina/Create';
import Vacinas from './pages/Vacina/List';
import VacinaEditar from './pages/Vacina/Update';
import Usuarios from './pages/Usuario/List';
import UsuarioNovo from './pages/Usuario/Create';
import UsuarioEditar from './pages/Usuario/Update';



export default function Routes(){
    return (
        <Router>
            <Switch>
                {/*rotas de usuário */}
                <Route path="/usuarios" exact component={Usuarios}/>
                <Route path="/usuarios/novo" exact component={UsuarioNovo}/>
                <Route path="/usuarios/editar/:id" exact component={UsuarioEditar}/>
                {/*rotas de usuário */}

                {/*rotas de vacina */}
                <Route path="/vacinas" exact component={Vacinas}/>
                <Route path="/vacinas/novo" exact component={Create}/>
                <Route path="/vacinas/editar/:id" exact component={VacinaEditar}/>
                {/*rotas de vacina */}
            </Switch>
        </Router>
    );
}