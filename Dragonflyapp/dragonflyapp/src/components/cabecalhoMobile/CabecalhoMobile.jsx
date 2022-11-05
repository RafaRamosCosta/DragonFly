import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import imgLogo from '../../images/dragonfly.png';
import X from '../../images/x.svg';
import Menu from '../../images/menu-mobile.svg';
import login from '../../images/log-in.svg';
import { HeaderMobile } from './CabecalhoMobileStyles';

export default function CabecalhoMobile() {
  const [open, setOpen] = useState(false);

  const handleOpen = () => {
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
        <Link to="/">
          <img id="logo" src={imgLogo} alt="logo libélula" />
        </Link>
        <nav>
          <Link to="/cadastro">Cadastro</Link>

          <Link to="/produtos">Produtos</Link>
          <a href="#contato">Contato</a>
          <div className='login'>
            <img src={login} alt="" id="login-icon"></img>&nbsp;
            <Link to="/login" >Login</Link>
          </div>
        </nav>
      </div>
    </HeaderMobile>
  );
}
