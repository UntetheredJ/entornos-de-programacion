import React from 'react';
import Menu from './Menu';
import Logo from '../../node_modules/admin-lte/dist/img/AdminLTELogo.png';
import { Link } from 'react-router-dom';

const Sidebar = () => {
    return (
        <aside className="main-sidebar sidebar-dark-primary elevation-4">
            {/* Brand Logo */}
            <Link to={"/home"} className="brand-link">
                <img src={Logo} alt="AdminLTE Logo" className="brand-image img-circle elevation-3" style={{ opacity: '.8' }} />
                <span className="brand-text font-weight-light">Tienda API</span>
            </Link>
            {/* Sidebar */}
            <div className="sidebar">
                {/* Sidebar user (optional) */}
                <div className="user-panel mt-3 pb-3 mb-3 d-flex">
                    <div className="info">
                        &nbsp;
                    </div>
                    <div className="info">
                        <Link to={"/home"} className="d-block">Entornos de Programación</Link>
                    </div>
                </div>

                <Menu></Menu>
            </div>
            {/* /.sidebar */}
        </aside>

    );
}

export default Sidebar;