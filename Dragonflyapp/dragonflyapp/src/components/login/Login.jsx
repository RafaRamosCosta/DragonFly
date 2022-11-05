import React from 'react';
import { FormLogin, Button, DivLogin } from './LoginStyle';

export default function Login() {
  return (
      <DivLogin>
        <FormLogin>
          <h1>Faça seu Login</h1>
          <label htmlFor="login">Login</label>
          <input type="text" name="login" placeholder="Login" />

          <label htmlFor="senha">Senha</label>
          <input type="password" name="senha" placeholder="Senha" />

          <Button type="submit">Logar</Button>
        </FormLogin>
      </DivLogin>
  );
}
