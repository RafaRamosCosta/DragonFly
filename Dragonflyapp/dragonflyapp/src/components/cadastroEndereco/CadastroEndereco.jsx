import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Button, CadDiv, Form } from '../cadastro/CadastroStyle';
export default function CadastroEndereco() {
  const [ruas, setRuas] = useState([]);
  const [bairros, setBairros] = useState([]);

  useEffect(() => {
    axios('http://localhost:8080/DragonflyAPI/rest/empresa')
      .then((res) => {
        setEndereco({ ...endereco, empresa: res.data[res.data.length - 1] });
      })
      .catch((err) => console.log(err));
    axios('http://localhost:8080/DragonflyAPI/rest/bairro')
      .then((res) => setBairros(res.data))
      .catch((err) => console.log(err));
  }, []);

  const [endereco, setEndereco] = useState({
    log: '',
    nrLog: '',
  });

  const handleBairroChange = async (e) => {
    await axios(
      `http://localhost:8080/DragonflyAPI/rest/logradouro/${e.target.value}`
    ).then((res) => setRuas(res.data));
  };

  const handleLogChange = (e) => {
    setEndereco({ ...endereco, log: JSON.parse(e.target.value) });
    console.log(endereco);
  };

  const handleInputChange = async (e) => {
    setEndereco({ ...endereco, [e.target.name]: e.target.value });
    console.log(endereco);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios({
      method: 'POST',
      url: 'http://localhost:8080/DragonflyAPI/rest/enderecoempresa/',
      headers: {
        'Content-Type': 'application/json',
      },
      data: endereco,
    })
      .then((res) => {
        if (res.status === 201) {
          sessionStorage.setItem('empresa', JSON.stringify(endereco.empresa));
          sessionStorage.setItem('endereco', JSON.stringify(endereco));
          window.location.href = '/cadastroContatoEmpresa';
        } else {
          alert('Erro ao cadastrar endereço, informe dados válidos!');
        }
      })
      .catch((err) => console.log(err));
  };

  return (
    <CadDiv>
      <Form onSubmit={handleSubmit}>
        <h1>{endereco?.empresa?.nmFantasia} Cadastre o endereço da empresa</h1>

        <label htmlFor="bairro">Bairro</label>
        <select name="bairro" defaultValue={bairros[0]?.idBairro} onChange={handleBairroChange}>
          {bairros.map((bairro, i) => (
            <option key={i} value={bairro.idBairro}>
              {bairro.nmBairro}
            </option>
          ))}
        </select>

        <label htmlFor="log">Rua</label>
        <div className="div-logradouro">
          <select name="log" defaultValue={ruas[0]} onChange={handleLogChange}>
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
