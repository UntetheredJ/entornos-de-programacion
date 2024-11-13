import React, { useState, useEffect } from 'react';

import Navbar from '../components/Navbar';
import Sidebar from '../components/Sidebar';
import ContentHeader from '../components/ContentHeader';
import Footer from '../components/Footer';
import APIInvoke from '../utils/APIInvoke';
import SweetAlert from 'sweetalert';

const Clients = () => {

    const [clients, setClients] = useState([]);

    const loadClients = async () => {
        const response = await APIInvoke.invokeGET('/list/clientes');
        //console.log(response);
        setClients(response);
    }

    useEffect(() => {
        loadClients();
    }, [])

    const deleteClient = async (e, id) => {
        e.preventDefault();
        const response = await APIInvoke.invokeDELETE(`/clientes/${id}`);
        console.log(response);

        // Verify response code}
        // if (response.code === 200) {
        //     const msg = "El cliente ha sido eliminado exitosamente.";

        //     SweetAlert({
        //         title: "Información",
        //         text: msg,
        //         icon: "success",
        //         buttons: {
        //             confirm: {
        //                 text: "Aceptar",
        //                 value: true,
        //                 visible: true,
        //                 className: "btn btn-primary",
        //                 closeModal: true
        //             }
        //         },
        //     });
        //     loadClients();
        // } else {
        //     const msg = "No se pudo eliminar el cliente.";

        //     SweetAlert({
        //         title: "Error",
        //         text: msg,
        //         icon: "error",
        //         buttons: {
        //             confirm: {
        //                 text: "Aceptar",
        //                 value: true,
        //                 visible: true,
        //                 className: "btn btn-danger",
        //                 closeModal: true
        //             }
        //         },
        //     });
        // }
    }


    return (
        <div className='wrapper'>
            <Navbar></Navbar>
            <Sidebar></Sidebar>
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
                            <h3 className="card-title">Clientes</h3>
                            <div className="card-tools">
                                <button type="button" className="btn btn-tool" data-card-widget="collapse" title="Collapse">
                                    <i className="fas fa-minus" />
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
                                    {
                                        clients.map((client) => (
                                            <tr key={client.id}>
                                                <td>{client.id}</td>
                                                <td>{client.idTipoDocumento.tipo}</td>
                                                <td>{client.numeroDocumento}</td>
                                                <td>{client.direccion}</td>
                                                <td>{client.email}</td>
                                                <td>{client.nombre}</td>
                                                <td>{client.telefono}</td>
                                                <td>
                                                    <div className="btn-group">
                                                        <button type="button" className="btn btn-warning">
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
                        <div className="card-footer">
                        </div>
                    </div>

                </section>
            </div>
            <Footer></Footer>

        </div>


    );
}

export default Clients;