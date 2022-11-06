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
  };

  return (
    <CadDiv>
      <Form method="post" onSubmit={handleSubmit}>
        <h1>Cadastre-se, Funcionário!</h1>

        <label htmlFor="nmFuncionaro">Nome Completo</label>
        <input type="text" name="nmFuncionaro" placeholder="Nome e Sobrenome" onChange={handleInputChange}/>

        <label htmlFor="cpf">CPF</label>
        <input type="number" name="cpf" placeholder=" XXX.XXX.XXX-XX" onChange={handleInputChange}/>

        <label htmlFor="dtNascimento">Data de Nascimento</label>
        <input type="date" name="dtNascimento" placeholder="DD/MM/YYYY" onChange={handleInputChange}/>

        <label htmlFor="login">Login</label>
        <input type="text" name="login" placeholder="Login" onChange={handleInputChange}/>

        <label htmlFor="senha">Senha</label>
        <input type="password" name="senha" placeholder="Senha" onChange={handleInputChange}/>

        <div className="divButtons">
          <Button type="submit">Cadastrar</Button>
          <Button type="reset">Limpar</Button>
        </div>
      </Form>
    </CadDiv>
  );
}
