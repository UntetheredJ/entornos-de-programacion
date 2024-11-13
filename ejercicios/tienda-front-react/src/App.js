// This component is mostly used for routing.
import React, { Fragment } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './pages/auth/Login';
import Register from './pages/auth/Register';

function App() {
  return (
    <Fragment>
      <Router>
        <Routes>
          <Route path='/' exact element={<Login/>}/>
          <Route path='/register' exact element={<Register/>}/>
        </Routes>
      </Router>
    </Fragment>
  );
}

export default App;
