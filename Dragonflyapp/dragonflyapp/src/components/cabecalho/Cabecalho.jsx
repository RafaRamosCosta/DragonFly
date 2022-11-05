import React from 'react';
import { Link } from 'react-router-dom';
import imgLogo from '../../images/dragonfly.png';
import { Header } from './CabecalhoStyle';

export default function Cabecalho() {
  return (
    <Header>
      <Link to="/">
        <img src={imgLogo} alt="logo libélula" />
      </Link>
      <h2>Dragonfly Drones</h2>
      <nav>
        <Link to="/cadastro">Cadastro</Link>
        <Link to="/login">Login</Link>
        <Link to="/produtos">Produtos</Link>
        <a href="#contato">Contato</a>
      </nav>
    </Header>
  );
}
