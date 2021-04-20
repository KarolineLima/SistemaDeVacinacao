import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Create from './pages/Vacina/Create';
import Vacinas from './pages/Vacina/List';



export default function Routes(){
    return (
        <Router>
            <Switch>
                {/*rotas de usuário */}
                <Route path="/usuarios" exact />
                <Route path="/usuarios/novo" exact />
                <Route path="/usuarios/editar/:id" exact />
                {/*rotas de usuário */}

                {/*rotas de vacina */}
                <Route path="/vacinas" exact component={Vacinas}/>
                <Route path="/vacinas/novo" exact component={Create}/>
                <Route path="/vacinas/editar/:id" exact/>
                {/*rotas de vacina */}
            </Switch>
        </Router>
    );
}