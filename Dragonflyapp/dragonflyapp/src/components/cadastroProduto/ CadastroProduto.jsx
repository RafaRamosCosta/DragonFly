import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { DivForm, FormProd } from './CadastroProdutoStyle';

export default function CadastroProduto() {
  const userData = JSON.parse(sessionStorage.getItem('user'));

  useEffect(() => {
    if (userData === null) {
      window.location.href = '/login';
    }
  }, []);

  const [novoProduto, setNovoProduto] = useState({
    func: userData,
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
    }).then((res) => {
      console.log(res);
      if (res.status === 201) {
        window.location.href = '/produtos';
      } else {
        alert('Erro ao cadastrar produto, informe dados válidos!');
      }
    });
  };
  return (
    <DivForm>
      <h1>Olá {userData?.nmFunc}, Cadastre um Produto!</h1>
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
        <div className="divBtnProd">
          <button type="submit">Cadastrar</button>
          <button type="reset">Limpar</button>
        </div>
      </FormProd>
    </DivForm>
  );
}
