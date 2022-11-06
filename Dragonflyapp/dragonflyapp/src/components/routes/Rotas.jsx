import React from 'react';
import { Route, Routes } from 'react-router-dom';

import Cadastro from '../cadastro/Cadastro';
import CadastroFuncionario from '../cadastroFuncionario/CadastroFuncionario';
import CadastroProduto from '../cadastroProduto/ CadastroProduto';
import Produto from '../produto/Produto';
import Login from '../login/Login';
import Home from '../home/Home';
import CadastroEndereco from '../cadastroEndereco/CadastroEndereco';
import CadastroContato from '../cadastroContato/CadastroContato';

export default function Rotas() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/produtos" element={<Produto />} />
      <Route path="/cadastro" element={<Cadastro />} />
      <Route path="/cadastroEnderecoEmpresa" element={<CadastroEndereco />} />
      <Route path="/cadastroContatoEmpresa" element={<CadastroContato />} />
      <Route path="/login" element={<Login />} />
      <Route path="/cadastroProduto" element={<CadastroProduto />} />
      <Route path="/cadastroFuncionario" element={<CadastroFuncionario />} />
    </Routes>
  );
}
