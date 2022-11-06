import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { CadDiv, Form } from '../cadastro/CadastroStyle';
export default function () {
  const [ruas, setRuas] = useState([]);
  useEffect(() => {
    axios('http://localhost:8080/DragonflyAPI/rest/enderecoempresa')
      .then((res) => setRuas(res.data))
      .catch((err) => console.log(err));
  }, []);
  const [endereco, setEndereco] = useState({
    empresa: '',
    nmLog: '',
    nrLog: '',
    nmBairro: '',
    zona: '',
  });
  const handleInputChange = (e) => {
    setEndereco({ ...endereco, [e.target.name]: e.target.value });
    console.log(endereco);
  };
  return (
    <CadDiv>
      <Form>
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
            type="text"
            name="nrLogradouro"
            id="nrLogradouro"
            placeholder="Número"
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

        <label htmlFor="dsZona">Zona da Cidade</label>
        <input
          type="text"
          name="dsZona"
          placeholder="Norte-> ZN | Sul-> ZS | Leste-> ZL | Oeste-> ZO"
          style={{ textAlign: 'center', textTransform: 'capitalize' }}
        />
      </Form>
    </CadDiv>
  );
}
