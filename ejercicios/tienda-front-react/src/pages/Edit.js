import React, { useState, useEffect } from 'react';
import { Link, useLocation } from 'react-router-dom';
import SweetAlert from 'sweetalert';

const Edit = () => {
    const location = useLocation();

    const [client, setClient] = useState(location.state?.client || {
        tipoDocumento: '',
        numeroDocumento: '',
        direccion: '',
        email: '',
        nombre: '',
        telefono: ''
    });


    const { tipoDocumento, numeroDocumento, direccion, email, nombre, telefono } = client;

    const onChange = (e) => {
        setClient({
            ...client,
            [e.target.name]: e.target.value
        });
    }

    const onSubmit = (e) => {
        e.preventDefault();
        
    }

    useEffect(() => {
        document.getElementById('numeroDocumento').focus();
    }, []);

    return (
        <div class="hold-transition login-page">
            <div className="login-box">
                <div className="login-logo">
                    <Link to={"#"}><b>Edición de Clientes</b></Link>
                </div>
                {/* /.login-logo */}
                <div className="card">
                    <div className="card-body login-card-body">
                        <p className="login-box-msg">Edita la información correspondiente</p>
                        <form onSubmit={onSubmit}>
                            <div className="input-group mb-3">
                                <input type="text" id='tipoDocumento' name='tipoDocumento' className="form-control" value={tipoDocumento} onChange={onChange}  />
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-user" />
                                    </div>
                                </div>
                            </div>

                            <div className="input-group mb-3">
                                <input type="text" id='numeroDocumento' name='numeroDocumento' className="form-control" value={numeroDocumento} onChange={onChange} required placeholder="Número de Documento" />
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-id-card" />
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

                            <div className="input-group mb-3">
                                <input type="text" id='direccion' name='direccion' className="form-control" value={direccion} onChange={onChange} required placeholder="Dirección" />
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-id-card" />
                                    </div>
                                </div>
                            </div>

                            <div className="input-group mb-3">
                                <input type="email" id='email' name='email' className="form-control" value={email} onChange={onChange} required placeholder="Email" />
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-envelope" />
                                    </div>
                                </div>
                            </div>

                            <div className="input-group mb-3">
                                <input type="text" id='telefono' name='telefono' className="form-control" value={telefono} onChange={onChange} required placeholder="Teléfono" />
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-phone" />
                                    </div>
                                </div>
                            </div>


                            <div className="row">
                                <div className="col-6">
                                    <button type="submit" className="btn btn-primary btn-block">Guardar</button>
                                </div>
                                {/* /.col */}
                                <div className="col-6">
                                    <Link to={"/clients"} className="btn btn-danger btn-block">Volver</Link>
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

export default Edit;