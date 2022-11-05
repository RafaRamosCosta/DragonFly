import React from 'react';
import { CadDiv, Form, Button } from './CadastroFuncionarioStyle';

export default function CadastroFuncionario() {
  return (
    <CadDiv>
      <Form method="post">
        <h1>Cadastre-se, Funcionário!</h1>

        <label htmlFor="nmFuncionarop">Nome Completo</label>
        <input
          type="text"
          name="nmFuncionarop"
          placeholder="Nome e Sobrenome"
        />

        <label htmlFor="cpf">CPF</label>
        <input type="number" name="cpf" placeholder=" XXX.XXX.XXX-XX" />

        <label htmlFor="dtNascimento">Data de Nascimento</label>
        <input type="date" name="dtNascimento" placeholder="DD/MM/YYYY" />

        <label htmlFor="login">Login</label>
        <input type="text" name="login" placeholder="Login" />

        <label htmlFor="senha">Senha</label>
        <input type="password" name="senha" placeholder="Senha" />

        <div className="divButtons">
          <Button type="submit">Cadastrar</Button>
          <Button type="reset">Limpar</Button>
        </div>
      </Form>
    </CadDiv>
  );
}
