import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import imgLogo from '../../images/dragonfly.png';
import { Header } from './CabecalhoStyle';
import login from '../../images/log-in.svg';
import logout from '../../images/log-out.svg';
import BtnCarrinho from '../btnCarrinho/BtnCarrinho';
import Carrinho from '../carrinho/Carrinho';

export default function Cabecalho(props) {
  const [open, setOpen] = useState(false);
  const userData = JSON.parse(sessionStorage.getItem('user'));

  const renderCarrinho = () => {
    setOpen(!open);
  }
  
  return (
    <Header>
      <Link to="/">
        <img src={imgLogo} alt="logo libélula" />
      </Link>
      <h2>Dragonfly Drones</h2>
      <nav>
        <Link to="/">Home</Link>
        {userData?.nmFunc !== undefined ? (
          <Link to="/cadastroProduto">Cadastro</Link>
        ) : (
          ''
        )}
        <Link to="/produtos">Produtos</Link>
        <a href="#contato">Contato</a>
        {userData ? (
          <>
            {userData?.nmFantasia !== undefined ? <BtnCarrinho renderCarrinho={renderCarrinho}/> : ''}
            <button id="btn-logout" onClick={props.logout}>
              Logout
              <img
                src={logout}
                alt=""
                align="center"
                style={{ width: '22px' }}
              />
            </button>
            {open ? <Carrinho renderCarrinho={renderCarrinho}/> : ''}
          </>
        ) : (
          <Link id="loginLink" to="/login">
            Login <img src={login} alt="ícone login" align="center" />
          </Link>
        )}
      </nav>
    </Header>
  );
}
