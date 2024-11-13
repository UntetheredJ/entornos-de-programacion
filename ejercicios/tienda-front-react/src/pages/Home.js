import React from 'react';
import Navbar from '../components/Navbar';
import Sidebar from '../components/Sidebar';
import ContentHeader from '../components/ContentHeader';
import Footer from '../components/Footer';

const Home = () => {
    return (
        <div className="wrapper">
            <Navbar></Navbar>
            <Sidebar></Sidebar>
            <div className='content-wrapper'>
                <ContentHeader
                    title={"Home"}
                    breadCrumb1={"Inicio"}
                    breadCrumb2={"Home"}
                    route1={"/home"}
                />
                <section className='content'>
                    <p>
                        Bienvenido al API de Tienda. Este es un proyecto de ejemplo para mostrar cómo se puede consumir un API REST con React.
                    </p>
                </section>
            </div>
            <Footer></Footer>
        </div>
    );
}

export default Home;