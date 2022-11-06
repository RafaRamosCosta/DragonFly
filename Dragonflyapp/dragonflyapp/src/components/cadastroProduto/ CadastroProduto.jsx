import axios from 'axios';
import React, { useState } from 'react';
import { DivForm, FormProd } from './CadastroProdutoStyle';

export default function CadastroProduto() {
  const [novoProduto, setNovoProduto] = useState({
    nmProduto: '',
    dsProduto: '',
    vlUnitario: '',
  });

  const handleInputChange = (e) => {
    setNovoProduto({ ...novoProduto, [e.target.name]: e.target.value });
    console.log(novoProduto);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios({
      method: 'POST',
      url: 'http://localhost:8080/DragonflyAPI/rest/produto/',
      headers: {
        'Content-Type': 'application/json',
      },
      data: novoProduto,
    });
  };
  return (
    <DivForm>
      <h1>Cadastre um Produto!</h1>
      <FormProd onSubmit={handleSubmit}>
        <label htmlFor="nmProduto">Nome do Produto</label>
        <input
          type="text"
          name="nmProduto"
          placeholder="Ex.: Drone X"
          onChange={handleInputChange}
        />

        <label htmlFor="dsProduto">Descrição do Produto</label>
        <textarea
          name="dsProduto"
          cols="30"
          rows="10"
          placeholder="Ex.: Espeficações técnicas"
          onChange={handleInputChange}></textarea>

        <label htmlFor="vlUnitario">Valor Unitário</label>
        <input
          type="number"
          name="vlUnitario"
          placeholder="R$"
          onChange={handleInputChange}
        />

        <button type="submit">Cadastrar</button>
        <button type="reset">Limpar</button>
      </FormProd>
    </DivForm>
  );
}
