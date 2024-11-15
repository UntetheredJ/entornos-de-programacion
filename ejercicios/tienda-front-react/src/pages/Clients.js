import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import Navbar from '../components/Navbar';
import Sidebar from '../components/Sidebar';
import ContentHeader from '../components/ContentHeader';
import Footer from '../components/Footer';
import APIInvoke from '../utils/APIInvoke';
import SweetAlert from 'sweetalert';

const Clients = () => {

    const navigate = useNavigate();
    const [clients, setClients] = useState([]);

    const loadClients = async () => {
        const response = await APIInvoke.invokeGET('/list/clientes');
        setClients(response);
    }

    const editClient = (client) => {
        navigate(
            '/clients-edit',
            { state: { client: client }
        })
    }

    useEffect(() => {
        loadClients();
    }, [])

    const deleteClient = async (e, id) => {
        e.preventDefault();

        SweetAlert({
            title: "¿Estás seguro?",
            text: "No podrás revertir esta acción",
            icon: "warning",
            buttons: {
                cancel: {
                    text: "Cancelar",
                    value: null,
                    visible: true,
                    className: "btn btn-secondary",
                    closeModal: true
                },
                confirm: {
                    text: "Sí, eliminar",
                    value: true,
                    visible: true,
                    className: "btn btn-danger",
                    closeModal: true
                }
            },
        }).then(async (confirm) => {
            if (confirm) {
                const response = await APIInvoke.invokeDELETE(`/clientes/${id}`);
                if (response && response.success) {
                    SweetAlert("Éxito", "El cliente ha sido eliminado exitosamente.", "success");
                    loadClients();
                } else {
                    SweetAlert("Error", "No se pudo eliminar el cliente.", "error");
                }
            }
        });
    }

    // Navegar a la página de creación de cliente
    const createClient = () => {
        navigate('/clients-create');
    }

    return (
        <div className='wrapper'>
            <Navbar />
            <Sidebar />
            <div className='content-wrapper'>
                <ContentHeader
                    title={"Clientes"}
                    breadCrumb1={"Administración"}
                    breadCrumb2={"Clientes"}
                    route1={"/admin"}
                />
                <section className='content'>
                    <div className="card">
                        <div className="card-header">
                            <div className="d-flex justify-content-between">
                                <h3 className="card-title">Clientes</h3>
                                <button onClick={createClient} className="btn btn-primary">
                                    Crear Cliente
                                </button>
                            </div>
                        </div>
                        <div className="card-body">
                            <table className="table table-bordered">
                                <thead>
                                    <tr>
                                        <th style={{ width: 10 }}>ID</th>
                                        <th>Tipo Documento</th>
                                        <th># Documento</th>
                                        <th>Dirección</th>
                                        <th>Email</th>
                                        <th>Nombre</th>
                                        <th>Teléfono</th>
                                        <th style={{ width: 40 }}>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {clients.map((client) => (
                                        <tr key={client.id}>
                                            <td>{client.id}</td>
                                            <td>{client.idTipoDocumento?.tipo}</td>
                                            <td>{client.numeroDocumento}</td>
                                            <td>{client.direccion}</td>
                                            <td>{client.email}</td>
                                            <td>{client.nombre}</td>
                                            <td>{client.telefono}</td>
                                            <td>
                                                <div className="btn-group">
                                                    <button onClick={() => editClient(client)} className="btn btn-warning">
                                                        <i className="fas fa-edit" />
                                                    </button>
                                                    <button onClick={(e) => deleteClient(e, client.id)} type="button" className="btn btn-danger">
                                                        <i className="fas fa-trash" />
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>
                                    ))}
                                </tbody>
                            </table>
                        </div>
                        <div className="card-footer"></div>
                    </div>
                </section>
            </div>
            <Footer />
        </div>
    );
}

export default Clients;
