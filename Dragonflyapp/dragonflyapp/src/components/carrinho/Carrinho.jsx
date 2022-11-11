import React, { useState, useEffect } from 'react';
import { CardProduto, PageCarrinho } from './CarrinhoStyle';
import { Link } from 'react-router-dom';
import drone from '../../images/droneCima.jpg';
import x from '../../images/x.svg';
import trash from '../../images/trash.svg';
import logo from '../../images/dragonfly.png';
import axios from 'axios';
export default function Carrinho({ renderCarrinho }) {
  const [carrinho, setCarrinho] = useState(
    JSON.parse(localStorage.getItem('carrinho'))
  );
  const userData = JSON.parse(sessionStorage.getItem('user'));
  var pedido = {
    empresa: userData,
    dtPedido: new Date().toLocaleDateString('pt-BR'),
  };
  useEffect(() => {
    setCarrinho(JSON.parse(localStorage.getItem('carrinho')));
  }, []);

  const handleRemove = (id) => {
    const newCarrinho = carrinho.filter((item) => item.idProduto !== id);
    localStorage.setItem('carrinho', JSON.stringify(newCarrinho));
    setCarrinho(newCarrinho);
  };

  const handlePostPedido = (e) => {
    axios({
      method: 'POST',
      url: 'http://localhost:8080/DragonflyAPI/rest/pedido/',
      headers: {
        'Content-Type': 'application/json',
      },
      data: pedido,
    }).then((res) => {
        if (res.status === 201) {
          axios(`http://localhost:8080/DragonflyAPI/rest/pedido/${userData.idEmpresa}`)
          .then((res) => {
            let idPedido = res.data[res.data.length - 1].idPedido;
            carrinho.forEach(produto => {
              console.log(produto.qtProduto);
              let itemPedido = {
                pedido: {idPedido: idPedido},
                produto: {idProduto: produto.idProduto},
                qtItemPedido: produto.qtProduto,
              }
              axios({
                method: 'POST',
                url: `http://localhost:8080/DragonflyAPI/rest/itempedido/`,
                headers: {
                  'Content-Type': 'application/json',
                },
                data: itemPedido,
              }).then(res => {
                if (res.status === 201) {
                  sessionStorage.setItem('pedido', JSON.stringify(itemPedido.pedido));
                  window.location = '/compra';
                } else {
                  console.log("Erro ao cadastrar item do pedido");
                }
              }).catch(error => console.log(error));
            })
          }).catch(error => console.log(error));
        }
      }).catch((err) => console.log(err));
  };
  return (
    <PageCarrinho>
      <span onClick={renderCarrinho}>
        <img src={x} style={{ width: '20px' }} alt="" />
      </span>
      {carrinho === null || carrinho.length <= 0 ? (
        <h2 id="msgCarrinho">Você não possui itens no carrinho!</h2>
      ) : (
        ''
      )}
      <div className="divProdutos">
        {carrinho === null || carrinho.length <= 0 ? (
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
      {carrinho === null || carrinho.length > 0 ? (
        <Link
          to=""
          onClick={(e) => {
            e.preventDefault();
            // renderCarrinho();
            handlePostPedido();
          }}>
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
