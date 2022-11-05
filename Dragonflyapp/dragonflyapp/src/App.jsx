import React from 'react';
import Cabecalho from './components/cabecalho/Cabecalho';
import CabecalhoMobile from './components/cabecalhoMobile/CabecalhoMobile';
import Rodape from './components/rodape/Rodape';
import Rotas from './components/routes/Rotas';

export default function App() {
  return (
    <div>
      <Cabecalho />
      <CabecalhoMobile />
      <Rotas />
      <Rodape />
    </div>
  );
}
