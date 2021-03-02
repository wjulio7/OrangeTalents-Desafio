import React from 'react'
import { BrowserRouter, Route, Switch, Redirect } from 'react-router-dom'
import Cadastro from './pages/userCadastro'
import vacCadastro from './pages/vacCadastro'

export default function Routes() {
    return(
      <BrowserRouter>
        <Switch> 
          <Route path="/" exact component={Cadastro}/>       
          <Route path="/vacinacaocadastro" exact component={vacCadastro}/>       
            
        </Switch>
      </BrowserRouter>
    )
  }
  