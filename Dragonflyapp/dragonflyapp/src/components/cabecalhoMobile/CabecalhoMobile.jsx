import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import imgLogo from '../../images/dragonfly.png';
import X from '../../images/x.svg';
import Menu from '../../images/menu-mobile.svg';
import login from '../../images/log-in.svg';
import home from '../../images/home.svg';
import logout from '../../images/log-out.svg';
import cesta from '../../images/basket.svg';
import celular from '../../images/call.svg';
import { HeaderMobile } from './CabecalhoMobileStyles';
import BtnCarrinho from '../btnCarrinho/BtnCarrinho';
import Carrinho from '../carrinho/Carrinho';

export default function CabecalhoMobile(props) {
  const userData = JSON.parse(sessionStorage.getItem('user'));
  const [open, setOpen] = useState(false);
  const [openCarrinho, setOpenCarrinho] = useState(false);
  const handleOpen = () => {
    setOpen(!open);
  };

  const renderCarrinho = () => {
    setOpenCarrinho(!openCarrinho);
    setOpen(!open);
  };
  return (
    <HeaderMobile>
      <div className={open ? 'header-aberto' : 'header-fechado'}>
        <div onClick={handleOpen}>
          <img
            id="menu"
            src={open ? X : Menu}
            alt=""
            style={{ width: '30px' }}
          />
        </div>
        <h2>Dragonfly Drones</h2>
        <Link to="/" onClick={handleOpen}>
          <img id="logo" src={imgLogo} alt="logo libélula" />
        </Link>
        <nav>
          {userData?.nmFunc !== undefined ? (
            <Link to="/cadastroProduto">Cadastro</Link>
          ) : (
            ''
          )}
          <Link to="/" onClick={handleOpen}>
            <img src={home} id="homeIcon" /> Home
          </Link>
          <Link to="/produtos" onClick={handleOpen}>
            <img src={cesta}></img> Produtos
          </Link>
          {userData?.nmFantasia !== undefined ? (
            <button onClick={renderCarrinho}>
              <BtnCarrinho /> Carrinho
            </button>
          ) : (
            ''
          )}
          
          <a href="#contato" onClick={handleOpen}>
            <img src={celular} alt="" /> Contato
          </a>
          <div className="login" onClick={handleOpen}>
            {userData ? (
              <button id="btn-logout" onClick={props.logout}>
                Logout{' '}
                <img
                  src={logout}
                  alt=""
                  align="center"
                  className="logicon"></img>
              </button>
            ) : (
              <Link to="/login">
                <img src={login} alt="" className="logicon"></img> Login
              </Link>
            )}
          </div>
        </nav>
      </div>
      {openCarrinho ? <Carrinho renderCarrinho={renderCarrinho}/> : ''}
    </HeaderMobile>
  );
}
