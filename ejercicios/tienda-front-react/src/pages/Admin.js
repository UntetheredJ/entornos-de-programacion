import React from 'react';
import Navbar from '../components/Navbar';
import Sidebar from '../components/Sidebar';
import ContentHeader from '../components/ContentHeader';
import Footer from '../components/Footer';
import { Link } from 'react-router-dom';

const Admin = () => {
    return (
        <div className="wrapper">
            <Navbar></Navbar>
            <Sidebar></Sidebar>
            <div className='content-wrapper'>
                <ContentHeader
                    title={"Administración"}
                    breadCrumb1={"Inicio"}
                    breadCrumb2={"Administración"}
                    route1={"/admin"}
                />
                <section className='content'>
                    <div className='container-fluid'>
                        <div className='row'>
                            <div className="col-lg-3 col-6">
                                <div className="small-box bg-info">
                                    <div className="inner">
                                        <h3>Clientes</h3>
                                        <p>Muestra una tabla con la lista de clientes para administrar.</p>
                                    </div>
                                    <div className="icon">
                                        <i className="ion ion-bag" />
                                    </div>
                                    <Link to={"/clients"} className="small-box-footer">Ver Clientes <i className="fas fa-arrow-circle-right" /></Link>
                                </div>
                            </div>

                        </div>
                    </div>
                </section>
            </div>
            <Footer></Footer>
        </div>
    );
}

export default Admin;