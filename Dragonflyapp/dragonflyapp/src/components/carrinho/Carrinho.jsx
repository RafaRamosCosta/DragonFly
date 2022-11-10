import React, { useState, useEffect } from 'react';
import { CardProduto, PageCarrinho } from './CarrinhoStyle';
import { Link } from 'react-router-dom';
import drone from '../../images/droneCima.jpg';
import x from '../../images/x.svg';
import trash from '../../images/trash.svg';
import logo from '../../images/dragonfly.png';
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
      {carrinho.length <= 0 ? (
        <h2 id="msgCarrinho">Você não possui itens no carrinho!</h2>
      ) : (
        ''
      )}
      <div className="divProdutos">
        {carrinho.length <= 0 ? (
          <img src={logo} alt="" />
        ) : (
          carrinho?.map((produto, i) => (
            <CardProduto key={i}>
              <span onClick={() => handleRemove(produto.idProduto)}>
                <img src={trash} alt="" />
              </span>
              <h3>{produto.nmProduto}</h3>
              <img
                src={drone}
                style={{ width: '200px', transform: 'none' }}></img>
              <p>
                Unidade(s): {produto.qtProduto}&nbsp;&nbsp;&nbsp;R$
                {produto.vlUnitario}
              </p>
              <p>Total: R${produto.qtProduto * produto.vlUnitario}</p>
            </CardProduto>
          ))
        )}
      </div>
      {carrinho.length < 0 ? (
        <Link to="/compra" onClick={renderCarrinho}>
          Finalizar Compra
        </Link>
      ) : (
        <Link to="/produtos" onClick={renderCarrinho}>
          Continuar Comprando
        </Link>
      )}
    </PageCarrinho>
  );
}
