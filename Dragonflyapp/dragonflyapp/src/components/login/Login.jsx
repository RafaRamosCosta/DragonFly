import axios from 'axios';
import React, { useRef } from 'react';
import { FormLogin, Button, DivLogin } from './LoginStyle';

export default function Login() {
  const login = useRef();
  const senha = useRef();
  const user = useRef();
  let usuario = {
    login: login.current,
    senha: senha.current,
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const response = await axios({
      method: 'POST',
      url: `http://localhost:8080/DragonflyAPI/rest/login/${user?.current?.value}`,
      headers: {
        'Content-Type': 'application/json',
      },
      data: usuario,
    });
    if (response) {
      sessionStorage.setItem(user?.current, response.data);
      console.log(response.data);
      // window.location = '/cadastroProduto';
    } else {
      alert('Usuário ou senha inválidos');
    }
  };
  return (
    <DivLogin>
      <FormLogin onSubmit={handleSubmit}>
        <h1>Faça seu Login</h1>
        <label htmlFor="user">Empresa</label>
        <input type="radio" name="user" value="emp" ref={user} />
        <label htmlFor="user">Funcionario</label>
        <input type="radio" name="user" value="func" ref={user} />
        <label htmlFor="login">Login</label>
        <input ref={login} type="text" name="login" placeholder="Login" />

        <label htmlFor="senha">Senha</label>
        <input ref={senha} type="password" name="senha" placeholder="Senha" />

        <Button type="submit">Logar</Button>
      </FormLogin>
    </DivLogin>
  );
}
