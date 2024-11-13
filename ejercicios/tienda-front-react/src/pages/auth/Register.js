import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import APIInvoke from '../../utils/APIInvoke';
import SweetAlert from 'sweetalert';

const Register = () => {
    const [user, setUser] = useState({
        nombreUsuario: '',
        password: '',
        password_confirm: '',
        nombre: ''
    });

    const { nombreUsuario, password, password_confirm, nombre } = user;

    const onChange = (e) => {
        setUser({
            ...user,
            [e.target.name]: e.target.value
        });
    }

    const registerUser = async () => {

        if(password !== password_confirm){
            const msg = "Las contraseñas no coinciden.";

            SweetAlert({
                title: "Error",
                text: msg,
                icon: "error",
                buttons: {
                    confirm: {
                        text: "Aceptar",
                        value: true,
                        visible: true,
                        className: "btn btn-danger",
                        closeModal: true
                    }
                },
            });
        } else {

        }
    }

    const onSubmit = (e) => {
        e.preventDefault();
        registerUser();
    }

    useEffect(() => {
        document.getElementById('nombreUsuario').focus();
    }, []);

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
                        <form onSubmit={onSubmit}>
                            <div className="input-group mb-3">
                                <input type="text" id='nombreUsuario' name='nombreUsuario' className="form-control" value={nombreUsuario} onChange={onChange} required placeholder="Usuario" />
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-user" />
                                    </div>
                                </div>
                            </div>
                            <div className="input-group mb-3">
                                <input type="password" id='password' name='password' className="form-control" value={password} onChange={onChange} required placeholder="Contraseña" />
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-lock" />
                                    </div>
                                </div>
                            </div>
                            <div className="input-group mb-3">
                                <input type="password" id='password_confirm' name='password_confirm' className="form-control" value={password_confirm} onChange={onChange} required placeholder="Confirmar Contraseña" />
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-lock" />
                                    </div>
                                </div>
                            </div>
                            <div className="input-group mb-3">
                                <input type="text" id='nombre' name='nombre' className="form-control" value={nombre} onChange={onChange} required placeholder="Nombre" />
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-id-card" />
                                    </div>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-6">
                                    <button type="submit" className="btn btn-primary btn-block">Registrar</button>
                                </div>
                                {/* /.col */}
                                <div className="col-6">
                                    <Link to={"/"} className="btn btn-danger btn-block">Volver</Link>
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