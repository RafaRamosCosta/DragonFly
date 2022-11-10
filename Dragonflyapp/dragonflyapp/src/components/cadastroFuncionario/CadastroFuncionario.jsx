  import axios from 'axios';
import React, { useState } from 'react';
import { CadDiv, Form, Button } from './CadastroFuncionarioStyle';

export default function CadastroFuncionario() {
  const [novoFuncionario, setNovoFuncionario] = useState({});

  const handleInputChange = (e) => {
    setNovoFuncionario({ ...novoFuncionario, [e.target.name]: e.target.value });
    console.log(novoFuncionario);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios({
      method: 'POST',
      url: 'http://localhost:8080/DragonflyAPI/rest/funcionario/',
      headers: {
        'Content-Type': 'application/json',
      },
      data: novoFuncionario,
    });
    console.log(novoFuncionario);
    window.location = "/cadastroEnderecoFuncionario";
  };

  const handleInputDate = (e) => {
    let data = new Date(e.target.value + 'T00:00:00');
    data = data.toLocaleDateString('pt-BR');
    console.log(data);
    setNovoFuncionario({ ...novoFuncionario, dtNasc: data });
  };

  return (
    <CadDiv>
      <Form method="post" onSubmit={handleSubmit}>
        <h1>Cadastre-se, Funcionário!</h1>

        <label htmlFor="nmFunc">Nome Completo</label>
        <input
          type="text"
          name="nmFunc"
          placeholder="Nome e Sobrenome"
          onChange={handleInputChange}
        />

        <label htmlFor="cpf">CPF</label>
        <input
          type="number"
          name="cpf"
          placeholder=" XXX.XXX.XXX-XX"
          onChange={handleInputChange}
        />

        <label htmlFor="dtNasc">Data de Nascimento</label>
        <input
          type="date"
          name="dtNasc"
          placeholder="DD/MM/YYYY"
          onChange={handleInputDate}
        />

        <label htmlFor="login">Login</label>
        <input
          type="text"
          name="login"
          placeholder="Login"
          onChange={handleInputChange}
        />

        <label htmlFor="senha">Senha</label>
        <input
          type="password"
          name="senha"
          placeholder="Senha"
          onChange={handleInputChange}
        />

        <div className="divButtons">
          <Button type="submit">Cadastrar</Button>
          <Button type="reset">Limpar</Button>
        </div>
      </Form>
    </CadDiv>
  );
}
