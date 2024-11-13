import React from 'react';
import { Link } from 'react-router-dom';

const Register = () => {
    return (
        <div class="hold-transition login-page">
            <div className="login-box">
                <div className="login-logo">
                    <Link to={"#"}><b>Regístrate</b></Link>
                </div>
                {/* /.login-logo */}
                <div className="card">
                    <div className="card-body login-card-body">
                        <p className="login-box-msg">Regístrate en nuestro sistema</p>
                        <form action="../../index3.html" method="post">
                            <div className="input-group mb-3">
                                <input type="text" id='usuario' name='usuario' className="form-control" placeholder="Usuario" />
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-envelope" />
                                    </div>
                                </div>
                            </div>
                            <div className="input-group mb-3">
                                <input type="password" id='password' name='password' className="form-control" placeholder="Contraseña" />
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-lock" />
                                    </div>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-6">
                                    <button type="submit" className="btn btn-primary btn-block">Login</button>
                                </div>
                                {/* /.col */}
                                <div className="col-6">
                                    <Link to={"/register"} className="btn btn-danger btn-block">Registrar</Link>
                                </div>
                                {/* /.col */}
                            </div>
                        </form>
                        <br/>
                    </div>
                    {/* /.login-card-body */}
                </div>
            </div>

        </div>
    );
}

export default Register;