import React from 'react';
import { Link } from 'react-router-dom';
import imgLogo from '../../images/dragonfly.png';
import { Header } from './CabecalhoStyle';
import login from '../../images/log-in.svg';
import logout from '../../images/log-out.svg';

export default function Cabecalho(props) {
  const userData = sessionStorage.getItem('user');
  return (
    <Header>
      <Link to="/">
        <img src={imgLogo} alt="logo libélula" />
      </Link>
      <h2>Dragonfly Drones</h2>
      <nav>
        <Link to="/cadastro">Cadastro</Link>
        <Link to="/produtos">Produtos</Link>
        <a href="#contato">Contato</a>
        {userData ? (
            <button id="btn-logout" onClick={props.logout}>Logout <img src={logout} alt="" align="center" style={{ width: '22px' }} /></button>
        ) : (
            <Link id="loginLink" to="/login">Login <img src={login} alt="" align="center" style={{ width: '25px' }} /></Link>
        )}
      </nav>
    </Header>
  );
}
