import React from 'react';
import Cabecalho from './components/cabecalho/Cabecalho';
import CabecalhoMobile from './components/cabecalhoMobile/CabecalhoMobile';
import Rodape from './components/rodape/Rodape';
import Rotas from './components/routes/Rotas';

export default function App() {
  const handleLogout = () => {
    sessionStorage.removeItem('user');
    window.location = '/';
  }

  return (
    <div>
      <Cabecalho logout={handleLogout}/>
      <CabecalhoMobile logout={handleLogout}/>
      <Rotas />
      <Rodape />
    </div>
  );
}
