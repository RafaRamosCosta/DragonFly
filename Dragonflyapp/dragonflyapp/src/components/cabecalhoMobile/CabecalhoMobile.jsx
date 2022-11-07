import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import imgLogo from '../../images/dragonfly.png';
import X from '../../images/x.svg';
import Menu from '../../images/menu-mobile.svg';
import login from '../../images/log-in.svg';
import logout from '../../images/log-out.svg';
import { HeaderMobile } from './CabecalhoMobileStyles';

export default function CabecalhoMobile(props) {
  const userData = JSON.parse(sessionStorage.getItem('user'));

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
        <Link to="/" onClick={handleOpen}>
          <img id="logo" src={imgLogo} alt="logo libélula" />
        </Link>
        <nav>
          <Link to="/cadastro" onClick={handleOpen}>Cadastro</Link>

          <Link to="/produtos" onClick={handleOpen}>Produtos</Link>
          <a href="#contato" onClick={handleOpen}>Contato</a>
          <div className='login' onClick={handleOpen}>
            { userData ? (<><img src={logout} alt="" className="logicon"></img><button id="btn-logout" onClick={props.logout}>Logout</button></>) 
            : (<><img src={login} alt="" className="logicon"></img><Link to="/login">Login</Link></>)
            }
          </div>
        </nav>
      </div>
    </HeaderMobile>
  );
}
