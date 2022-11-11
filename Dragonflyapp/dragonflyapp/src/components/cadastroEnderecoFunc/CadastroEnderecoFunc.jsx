import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Button, CadDiv, Form } from '../cadastro/CadastroStyle';
export default function CadastroEnderecoFunc() {
  const [bairros, setBairros] = useState([]);
  const [ruas, setRuas] = useState([]);
  
  useEffect(() => {
    axios('http://localhost:8080/DragonflyAPI/rest/funcionario')
      .then((res) => {
        setEndereco({ ...endereco, func: res.data[res.data.length - 1] });
      }).catch((err) => console.log(err));
    axios('http://localhost:8080/DragonflyAPI/rest/bairro')
      .then((res) => setBairros(res.data))
      .catch((err) => console.log(err));
  }, []);

  const [endereco, setEndereco] = useState({
    log: ruas[0],
    nrLog: '',
  });

  const handleInputChange = (e) => {
    setEndereco({ ...endereco, [e.target.name]: e.target.value });
    console.log(endereco);
  };

  const handleBairroChange = (e) => {
    axios(
      `http://localhost:8080/DragonflyAPI/rest/logradouro/${e.target.value}`
    )
      .then((res) => {
        setRuas(res.data);
        console.log(res.data);
      })
      .catch((err) => console.log(err));
  };

  const handleLogChange = (e) => {
    setEndereco({ ...endereco, log: JSON.parse(e.target.value) });
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
    })
      .then((res) => {
        if (res.status === 201) {
          sessionStorage.setItem('funcionario', JSON.stringify(endereco.func));
          window.location.href = '/cadastroContatoFuncionario';
        } else {
          alert('Erro ao cadastrar endereço, informe dados válidos!');
        }
      })
      .catch((err) => console.log(err));
  };

  return (
    <CadDiv>
      <Form onSubmit={handleSubmit}>
        <h1>{endereco?.func?.nmFunc} cadastre seu endereço</h1>
        <label htmlFor="cidade">Cidade</label>
        <input type="text" readonly disabled value={'São Paulo'} />
        <label htmlFor="bairro">Bairro</label>
        <select name="bairro" defaultValue={bairros[0]?.idBairro} onChange={handleBairroChange}>
          {bairros.map((bairro, i) => (
            <option key={i} value={bairro.idBairro}>
              {bairro.nmBairro}
            </option>
          ))}
        </select>

        <label htmlFor="logradouro">Rua</label>
        <div className="div-logradouro">
          <select name="log" onChange={handleLogChange}>
            {ruas?.map((rua, i) => (
              <option key={i} value={JSON.stringify(rua)}>
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
        <div className="divButtons">
          <Button type="submit">Cadastrar</Button>
          <Button type="reset">Limpar</Button>
        </div>
      </Form>
    </CadDiv>
  );
}
