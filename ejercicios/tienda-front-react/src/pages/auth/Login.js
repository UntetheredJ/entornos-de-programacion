import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import APIInvoke from '../../utils/APIInvoke';
import SweetAlert from 'sweetalert';

const Login = () => {

    // Redirect to another page or component
    const navigate = useNavigate();

    const [user, setUser] = useState({
        nombreUsuario: '',
        password: ''
    });

    const { nombreUsuario, password } = user;

    const onChange = (e) => {
        setUser({
            ...user,
            [e.target.name]: e.target.value
        })
    }

    const login = async () => {
        if(password.length < 3){
            const msg = "La contraseña debe tener al menos 3 caracteres.";

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
            const data = {
                nombreUsuario: user.nombreUsuario,
                password: user.password
            }

            const response = await APIInvoke.invokePOST('/login', data);

            if(response.Usuario){
                navigate("/home");
            } else {
                const msg = "Usuario o contraseña incorrectos.";
                
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
            }
        }
    }

    const onSubmit = (e) => {
        e.preventDefault();
        login();
    }

    useEffect(() => {
        document.getElementById('nombreUsuario').focus();
    }, []);

    return (
        <div class="hold-transition login-page">
            <div className="login-box">
                <div className="login-logo">
                    <Link to={"#"}><b>Tienda</b>API</Link>
                </div>
                {/* /.login-logo */}
                <div className="card">
                    <div className="card-body login-card-body">
                        <p className="login-box-msg">Inicia sesión para empezar a consumir el API</p>
                        <form onSubmit={onSubmit}>
                            <div className="input-group mb-3">
                                <input type="text" id='nombreUsuario' name='nombreUsuario' className="form-control" value={nombreUsuario} onChange={onChange} required placeholder="Usuario" />
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-envelope" />
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

export default Login;