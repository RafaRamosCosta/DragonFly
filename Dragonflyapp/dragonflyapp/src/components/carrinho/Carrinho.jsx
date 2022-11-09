import React, { useState, useEffect } from 'react';
import { CardProduto, PageCarrinho } from './CarrinhoStyle';
import drone from '../../images/droneCima.jpg';
import x from '../../images/x.svg';
import trash from '../../images/trash.svg';
export default function Carrinho({ renderCarrinho }) {
  const [carrinho, setCarrinho] = useState(
    JSON.parse(localStorage.getItem('carrinho'))
  );

  useEffect(() => {
    setCarrinho(JSON.parse(localStorage.getItem('carrinho')));
  }, []);

  const handleRemove = (id) => {
    const newCarrinho = carrinho.filter((item) => item.idProduto !== id);
    localStorage.setItem('carrinho', JSON.stringify(newCarrinho));
    setCarrinho(newCarrinho);
  };

  return (
    <PageCarrinho>
      <span onClick={renderCarrinho}>
        <img src={x} style={{ width: '20px' }} alt="" />
      </span>
      {carrinho.map((produto) => (
        <>
          {produto.qtProduto ? (
            <CardProduto key={produto.idProduto}>
              <span onClick={() => handleRemove(produto.idProduto)}>
                <img src={trash} alt="" />
              </span>
              <h3>{produto.nmProduto}</h3>
              <img
                src={drone}
                style={{ width: '200px', transform: 'none' }}></img>
              <p>
                Unidades:{produto.qtProduto} R${produto.vlUnitario}
              </p>
              <p>Total: R${produto.qtProduto * produto.vlUnitario}</p>
            </CardProduto>
          ) : (
            ''
          )}
        </>
      ))}
    </PageCarrinho>
  );
}
