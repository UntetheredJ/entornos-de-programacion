import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import SweetAlert from 'sweetalert';
import APIInvoke from '../utils/APIInvoke';
import { useNavigate } from 'react-router-dom';

const Create = () => {

    const navigate = useNavigate();

    const [client, setClient] = useState({
        id: '',
        idTipoDocumento: { id: '', tipo: '' },
        numeroDocumento: '',
        direccion: '',
        email: '',
        nombre: '',
        telefono: ''
    });

    const [tipoDocumentos, setTipoDocumentos] = useState([]);
    const { idTipoDocumento, numeroDocumento, direccion, email, nombre, telefono } = client;


    useEffect(() => {
        const fetchTipoDocumentos = async () => {
            try {
                const response = await APIInvoke.invokeGET('/list/tipoDocumentos');
                setTipoDocumentos(response); 
            } catch (error) {
                console.error('Error al obtener tipos de documentos', error);
            }
        };

        fetchTipoDocumentos();
        document.getElementById('numeroDocumento').focus();
    }, []);

    const onChange = (e) => {
        setClient({
            ...client,
            [e.target.name]: e.target.value
        });
    };

    const handleTipoDocumentoChange = (e) => {
        const selectedTipoDocumento = tipoDocumentos.find(item => item.id === parseInt(e.target.value));
        setClient({
            ...client,
            idTipoDocumento: selectedTipoDocumento || { id: '', tipo: '' }
        });
    };

    const editClient = async () => {
        const data = {
            id: client.id,
            idTipoDocumento: client.idTipoDocumento, 
            numeroDocumento: client.numeroDocumento,
            direccion: client.direccion,
            email: client.email,
            nombre: client.nombre,
            telefono: client.telefono
        };

        const response = await APIInvoke.invokePOST('/clientes', data);
        console.log(response)

        if (response && Object.keys(response).length > 0) {
            SweetAlert({
                title: "Éxito",
                text: "Cliente creado correctamente",
                icon: "success",
                buttons: {
                    confirm: {
                        text: "Aceptar",
                        value: true,
                        visible: true,
                        className: "btn btn-primary",
                        closeModal: true
                    }
                }
            }).then(() => {
                navigate('/clients');  
            });
        } else {
            SweetAlert("Error", "No se pudo crear el cliente", "error");
        }
        
        
    };

    const onSubmit = (e) => {
        e.preventDefault();
        editClient();
    };

    return (
        <div className="hold-transition login-page">
            <div className="login-box">
                <div className="login-logo">
                    <Link to={"#"}><b>Creación de Clientes</b></Link>
                </div>
                <div className="card">
                    <div className="card-body login-card-body">
                        <p className="login-box-msg">Inrgesa la información correspondiente</p>
                        <form onSubmit={onSubmit}>
                            {/* Desplegable para el tipo de documento */}
                            <div className="input-group mb-3">
                                <select 
                                    name="tipoDocumento" 
                                    className="form-control" 
                                    value={idTipoDocumento.id} 
                                    onChange={handleTipoDocumentoChange} 
                                    required
                                >
                                    <option value="">Seleccionar tipo de documento</option>
                                    {tipoDocumentos.map((tipo) => (
                                        <option key={tipo.id} value={tipo.id}>
                                            {tipo.tipo}
                                        </option>
                                    ))}
                                </select>
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-id-card" />
                                    </div>
                                </div>
                            </div>

                            <div className="input-group mb-3">
                                <input 
                                    type="text" 
                                    id='numeroDocumento' 
                                    name='numeroDocumento' 
                                    className="form-control" 
                                    value={numeroDocumento} 
                                    onChange={onChange} 
                                    required 
                                    placeholder="Número de Documento" 
                                />
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-id-card" />
                                    </div>
                                </div>
                            </div>

                            <div className="input-group mb-3">
                                <input 
                                    type="text" 
                                    id='nombre' 
                                    name='nombre' 
                                    className="form-control" 
                                    value={nombre} 
                                    onChange={onChange} 
                                    required 
                                    placeholder="Nombre" 
                                />
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-id-card" />
                                    </div>
                                </div>
                            </div>

                            <div className="input-group mb-3">
                                <input 
                                    type="text" 
                                    id='direccion' 
                                    name='direccion' 
                                    className="form-control" 
                                    value={direccion} 
                                    onChange={onChange} 
                                    required 
                                    placeholder="Dirección" 
                                />
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-id-card" />
                                    </div>
                                </div>
                            </div>

                            <div className="input-group mb-3">
                                <input 
                                    type="email" 
                                    id='email' 
                                    name='email' 
                                    className="form-control" 
                                    value={email} 
                                    onChange={onChange} 
                                    required 
                                    placeholder="Email" 
                                />
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-envelope" />
                                    </div>
                                </div>
                            </div>

                            <div className="input-group mb-3">
                                <input 
                                    type="text" 
                                    id='telefono' 
                                    name='telefono' 
                                    className="form-control" 
                                    value={telefono} 
                                    onChange={onChange} 
                                    required 
                                    placeholder="Teléfono" 
                                />
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
                                <div className="col-6">
                                    <Link to={"/clients"} className="btn btn-danger btn-block">Volver</Link>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Create;
