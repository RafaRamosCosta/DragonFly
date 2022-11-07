import axios from 'axios';
import React, { useState } from 'react';
import { FormLogin, Button, DivLogin } from './LoginStyle';

export default function Login() {
  const [userType, setUserType] = useState('');
  const [user, setUser] = useState({});

  const handleRadioBtnChange = (e) => {
    setUserType(e.target.value);
    console.log(userType);
  };

  const handleInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
    console.log(user);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios({
      method: 'POST',
      url: `http://localhost:8080/DragonflyAPI/rest/login/${userType}`,
      headers: {
        'Content-Type': 'application/json',
      },
      data: user,
    })
      .then((response) => {
        if (response) {
          sessionStorage.setItem("user", JSON.stringify(response.data));
          console.log(response);
          if (userType === 'emp') {
            window.location.href = '/produtos';
          } else {
            window.location.href = '/cadastroProduto';
          }
        } else {
          alert('Usuário ou senha inválidos');
        }
        
      })
      .catch((error) => {
        if (error.response) {
          console.log(error.response);
        } else if (error.request) {
          console.log(error.request);
        } else {
          console.log('Error', error.message);
        }
      });
  };
  return (
    <DivLogin>
      <FormLogin onSubmit={handleSubmit}>
        <h1>Faça seu Login</h1>
        <label htmlFor="user">Empresa</label>
        <input
          type="radio"
          name="user"
          value="emp"
          onChange={handleRadioBtnChange}
        />
        <label htmlFor="user">Funcionario</label>
        <input
          type="radio"
          name="user"
          value="func"
          onChange={handleRadioBtnChange}
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

        <Button type="submit">Logar</Button>
      </FormLogin>
    </DivLogin>
  );
}
