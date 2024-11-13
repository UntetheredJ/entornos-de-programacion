import React from 'react';
import { Link } from 'react-router-dom';

const Footer = () => {
    return (
        <footer className="main-footer">
            <div className="float-right d-none d-sm-block">
                <b>Version</b> 1.0.0
            </div>
            <strong>Entornos de Programación | 2024 - II | <Link to={"https://uis.edu.co"}>Universidad Industrial de Santander</Link>.</strong>
        </footer>

    );
}

export default Footer;