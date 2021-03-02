import React from 'react'
import { BrowserRouter, Route, Switch, Redirect } from 'react-router-dom'
import Cadastro from './pages/userCadastro'


export default function Routes() {
    return(
      <BrowserRouter>
        <Switch> 
          <Route path="/" exact component={Cadastro}/>          
        </Switch>
      </BrowserRouter>
    )
  }
  