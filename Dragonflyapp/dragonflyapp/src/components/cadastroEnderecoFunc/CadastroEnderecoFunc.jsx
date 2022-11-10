import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Button, CadDiv, Form } from '../cadastro/CadastroStyle';
export default function CadastroEnderecoFunc() {
  const [ruas, setRuas] = useState([]);

  useEffect(() => {
    axios('http://localhost:8080/DragonflyAPI/rest/funcionario')
      .then((res) => {
        setEndereco({...endereco, funcionario: res.data[res.data.length - 1]})
      })
      .catch((err) => console.log(err));
      
      axios('http://localhost:8080/DragonflyAPI/rest/enderecoempresa')
        .then((res) => setRuas(res.data))
        .catch((err) => console.log(err));
  }, []);

  
  const [endereco, setEndereco] = useState({
    nmLog: '',
    nrLog: '',
    nmBairro: '',
    zona: 'ZS',
  });

  const handleInputChange = (e) => {
    setEndereco({ ...endereco, [e.target.name]: e.target.value });
    console.log(endereco);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios({
      method: 'POST',
      url: 'http://localhost:8080/DragonflyAPI/rest/enderecofuncionario/',
      headers: {
        'Content-Type': 'application/json',
      },
      data: endereco,
    }).then(() => {
      sessionStorage.setItem('funcionario', JSON.stringify(endereco.funcionario))
      window.location.href = '/cadastroContatoFuncionrio'
    }).catch((err) => console.log(err));
    
  };

  return (
    <CadDiv>
      <Form onSubmit={handleSubmit}>
      <h1>{endereco?.funcionario?.nmFunc} cadastre seu endereço</h1>
        <label htmlFor="logradouro">Rua</label>
        <div className="div-logradouro">
          <select name="nmLog" onChange={handleInputChange}>
            {ruas.map((rua, i) => (
              <option key={i} value={rua.nmLog}>
                {rua.nmLog}
              </option>
            ))}
          </select>
          <input
            type="number"
            name="nrLog"
            id="nrLogradouro"
            placeholder="Nº"
            onChange={handleInputChange}
          />
        </div>

        <label htmlFor="nmBairro">Bairro</label>
        <input
          type="text"
          name="nmBairro"
          placeholder="Bairro"
          onChange={handleInputChange}
        />

        <label htmlFor="zona">Zona da Cidade</label>
        <select name="zona" onChange={handleInputChange}>
          <option value="ZS">Zona Sul</option>
          <option value="ZN">Zona Norte</option>
          <option value="ZL">Zona Leste</option>
          <option value="ZO">Zona Oeste</option>
        </select>

        <div className="divButtons">
          <Button type="submit">Cadastrar</Button>
          <Button type="reset">Limpar</Button>
        </div>
      </Form>
    </CadDiv>
  );
}