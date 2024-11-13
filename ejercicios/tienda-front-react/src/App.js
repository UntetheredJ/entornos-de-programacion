// This component is mostly used for routing.
import React, { Fragment } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './pages/auth/Login';
import Register from './pages/auth/Register';
import Home from './pages/Home';
import Clients from './pages/Clients';
import Admin from './pages/Admin';
import Edit from './pages/Edit';

function App() {
  return (
    <Fragment>
      <Router>
        <Routes>
          <Route path='/' exact element={<Login/>}/>
          <Route path='/register' exact element={<Register/>}/>
          <Route path='/home' exact element={<Home/>}/>
          <Route path='/admin' exact element={<Admin/>}/>
          <Route path='/clients' exact element={<Clients/>}/>
          <Route path='/clients-edit' exact element={<Edit/>}/>
        </Routes>
      </Router>
    </Fragment>
  );
}

export default App;
