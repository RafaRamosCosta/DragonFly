import axios from 'axios';
import React, { useState, useEffect } from 'react';
import { CardCompra, DescProd, PageCompra } from './CompraStyle';
import BotaoQtde from './BotaoQtde';

import droneNaMao from '../../images/droneNaMao.jpg';

export default function Compra() {
  const id = JSON.parse(sessionStorage.getItem('prodId'));
  const [produto, setProduto] = useState({});
  const [quantidade, setQuantidade] = useState(1);

  useEffect(() => {
    axios(`http://localhost:8080/DragonflyAPI/rest/produto/${id}`).then(
      (response) => setProduto(response.data)
    );
  }, []);

  const handleAdd = () => {
    console.log(quantidade);
    setProduto({ ...produto, qtProduto: quantidade });
    if (quantidade > 0) {
      let carrinho = JSON.parse(localStorage.getItem('carrinho')) || [];
      carrinho.push(produto);
      localStorage.setItem('carrinho', JSON.stringify(carrinho));
    }
  };

  return (
    <PageCompra>
      <CardCompra>
        <figure>
          <img src={droneNaMao} alt="" />
        </figure>
        <DescProd>
          <h1>{produto.nmProduto}</h1>
          <p>{produto.dsProduto}</p>
          <p className="valor">R$ {produto.vlUnitario}</p>
          <BotaoQtde quantidade={quantidade} setQuantidade={setQuantidade} />
          <button id="btnCompra" onClick={() => handleAdd()}>
            Adicionar ao carrinho
          </button>
        </DescProd>
      </CardCompra>
    </PageCompra>
  );
}
