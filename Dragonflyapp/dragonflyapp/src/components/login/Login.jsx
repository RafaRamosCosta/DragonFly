import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { FormLogin, Button, DivLogin } from './LoginStyle';

export default function Login() {
  const [userType, setUserType] = useState('emp');
  const [user, setUser] = useState({});
  const [link, setLink] = useState('/cadastro');


  const handleRadioBtnClick = (e) => {
    setUserType(e.target.value);
    console.log(userType);
  };

  const handleInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };
  
  useEffect(() => {
    userType === 'emp' ? setLink('/cadastro') : setLink('/cadastroFuncionario');
    console.log(link);
  }, [userType]);

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
        if (response.data !== '') {
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
          alert('Erro ao conectar com o servidor');
        } else if (error.request) {
          console.log(error.request);
          alert('Erro ao conectar com o servidor');
        } else {
          console.log('Error', error.message);
        }
      });
  };

  
  return (
    <DivLogin>
      <FormLogin onSubmit={handleSubmit}>
        <h1>Faça seu Login</h1>

        <div>
          <input
              type="radio"
              name="user"
              value="emp"
              onClick={handleRadioBtnClick}
              id='r1'
              defaultChecked/>
          <label htmlFor="user" for='r1'>Empresa</label>

          <input
              type="radio"
              name="user"
              value="func"
              onClick={handleRadioBtnClick}
              id='r2'/>
          <label htmlFor="user" for='r2'>Funcionário</label>
        </div>

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
        <p>Não tem uma conta?<Link to={link}>Cadastre-se aqui!</Link> </p>
      </FormLogin>
    </DivLogin>
  );
}
