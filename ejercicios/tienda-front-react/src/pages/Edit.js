import React, { useState, useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import SweetAlert from 'sweetalert';

const Edit = () => {

    const { id } = useParams();
    let arreglo = id.split('@');
    const idC = arreglo[0];
    const tipoD = arreglo[1];
    const numeroD = arreglo[2];
    const direccion = arreglo[3];
    const email = arreglo[4];
    const nombreC = arreglo[5];
    const telefono = arreglo[6];

    const [client, setClient] = useState({
        tipoDocumento: tipoD,
        numeroDocumento: numeroD,
        direccionC: direccion,
        emailC: email,
        nombre: nombreC,
        telefonoC: telefono
    });


    const { tipoDocumento, numeroDocumento, direccionC, emailC, nombre, telefonoC } = client;

    const onChange = (e) => {
        setClient({
            ...client,
            [e.target.name]: e.target.value
        });
    }

   

    const onSubmit = (e) => {
        e.preventDefault();
        const registerUser = async () => {

            if(nombreC !== nombreC){
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
    
    }

    useEffect(() => {
        document.getElementById('nombre').focus();
    }, []);

    return (
        <div class="hold-transition login-page">
            <div className="login-box">
                <div className="login-logo">
                    <Link to={"#"}><b>Edición de Registro</b></Link>
                </div>
                {/* /.login-logo */}
                <div className="card">
                    <div className="card-body login-card-body">
                        <p className="login-box-msg">Edita la Información correspondiente</p>
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
                                <input type="text" id='nombre' name='nombre' className="form-control" value={numeroDocumento} onChange={onChange} required placeholder="Nombre" />
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-id-card" />
                                    </div>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-6">
                                    <button type="submit" className="btn btn-primary btn-block">Guardar</button>
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

export default Edit;