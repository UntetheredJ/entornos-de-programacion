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
                    <div className='container-fluid'>
                        <div className='row'>

                        </div>
                    </div>
                </section>
            </div>
            <Footer></Footer>
        </div>
    );
}

export default Home;