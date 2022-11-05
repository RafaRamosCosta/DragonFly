import React from 'react';
import { CadDiv, Form, Button } from './CadastroStyle';

export default function Cadastro() {
  return (
    <CadDiv>
      <Form method="post">
        <h1>Cadastre sua empresa!</h1>
        <label htmlFor="nmFantasia">Nome Fantasia</label>
        <input type="text" name="nmFantasia" placeholder="Nome Fantasia" />

        <label htmlFor="rzSocial">Razão Social</label>
        <input type="text" name="rzSocial" placeholder="Razão Social" />

        <label htmlFor="cnpj">CNPJ</label>
        <input type="number" name="cnpj" placeholder="XXXXXXXXXXXXXX" />

        <label htmlFor="logradouro">Rua</label>
        <div className="div-logradouro">
          <input
            type="text"
            name="nmLogradouro"
            placeholder="Nome da rua, avenida, etc"
          />
          <input
            type="text"
            name="nrLogradouro"
            id="nrLogradouro"
            placeholder="Número"
          />
        </div>

        <label htmlFor="nmBairro">Bairro</label>
        <input type="text" name="nmBairro" placeholder="Bairro" />

        <label htmlFor="dsZona">Zona da Cidade</label>
        <input
          type="text"
          name="dsZona"
          placeholder="Norte-> ZN | Sul-> ZS | Leste-> ZL | Oeste-> ZO"
          style={{ textAlign: 'center', textTransform: 'capitalize' }}
        />

        <label htmlFor="email">Email</label>
        <input type="text" name="email" placeholder="seu_email.@gmail.com" />

        <label htmlFor="telefone">Telefone</label>
        <input type="number" name="telefone" placeholder="XXXX-XXXXX" />

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
