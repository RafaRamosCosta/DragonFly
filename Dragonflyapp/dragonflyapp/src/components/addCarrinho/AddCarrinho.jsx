import axios from 'axios';
import React, { useState, useEffect } from 'react';
import { CardCompra, DescProd, PageCompra } from './AddCarrinhoStyle';
import BotaoQtde from './BotaoQtde';

import droneNaMao from '../../images/droneNaMao.jpg';

export default function AddCarrinho() {
  const userData = JSON.parse(sessionStorage.getItem('user'));
  const id = JSON.parse(sessionStorage.getItem('prodId'));
  const [quantidade, setQuantidade] = useState(1);
  const [produto, setProduto] = useState({});

  useEffect(() => {
    if (userData) {
      axios(`http://localhost:8080/DragonflyAPI/rest/produto/${id}`).then(
        (response) => setProduto(response.data)
      );
    } else {
      window.location = '/login';
    }
  }, []);

  const handleAdd = () => {
    const carrinho = JSON.parse(localStorage.getItem('carrinho')) || [];
    const produtoCarrinho = carrinho.find((item) => item.idProduto === id);
    if (produtoCarrinho) {
      produtoCarrinho.qtProduto = quantidade;
    } else {
      carrinho.push({ ...produto, qtProduto: quantidade });
    }
    localStorage.setItem('carrinho', JSON.stringify(carrinho));
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
          {userData.nmFantasia ? (
            <>
              <BotaoQtde
                quantidade={quantidade}
                setQuantidade={setQuantidadEse}
              />
              <button id="btnCompra" onClick={() => handleAdd()}>
                Adicionar ao carrinho
              </button>
            </>
          ) : (
            ''
          )}
        </DescProd>
      </CardCompra>
    </PageCompra>
  );
}
