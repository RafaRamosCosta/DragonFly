import axios from 'axios';
import React from 'react';
import { useEffect } from 'react';
import { useState } from 'react';
import {
  PageCompra,
  CardFinalizarCompra,
  Item,
  DivDadosPessoais,
} from './CompraStyle';
import logo from '../../images/dragonfly.png';

export default function Compra() {
  const userData = JSON.parse(sessionStorage.getItem('user'));
  const [contato, setContato] = useState({});
  const [endereco, setEndereco] = useState({});
  const [total, setTotal] = useState(0);
  let carrinho = JSON.parse(localStorage.getItem('carrinho'));
  useEffect(() => {
    if (!userData) {
      window.location = '/login';
    }
    axios(
      `http://localhost:8080/DragonflyAPI/rest/enderecoempresa/${userData.idEmpresa}`
    )
      .then((response) => setEndereco(response.data))
      .catch((error) => console.log(error));
    axios(
      `http://localhost:8080/DragonflyAPI/rest/contatoempresa/${userData.idEmpresa}`
    )
      .then((response) => setContato(response.data))
      .catch((error) => console.log(error));
    setTotal(handleTotal);
  }, [carrinho]);

  const handleTotal = () => {
    let total = 0;
    carrinho.map((produto) => {
      let valor = Number(produto.qtProduto * produto.vlUnitario);
      total += valor;
    });
    return total;
  };

  return (
    <PageCompra>
      <DivDadosPessoais>
        <h1>Finalize sua compra {userData.nmFantasia}</h1>
        <div className='divLogo'>
          <img src={logo} alt="" />
          <i>DragonflyDrones</i>
        </div>
        <div>
          <form action="">
            <h3>Verifique as informações da sua empresa</h3>
            <label htmlFor="nome">Nome</label>
            <input
              type="text"
              readonly
              disabled
              name="nome"
              id="nome"
              value={userData.nmFantasia}
            />
            <label htmlFor="email">Email</label>
            <input
              type="email"
              readonly
              disabled
              name="email"
              id="email"
              value={contato.emailEmp}
            />
            <label htmlFor="telefone">Telefone</label>
            <input
              type="telefone"
              readonly
              disabled
              name="telefone"
              id="telefone"
              value={contato.nrTelefone}
            />
            <label htmlFor="logradouro">Endereço</label>
            <input
              type="text"
              readonly
              disabled
              name="logradouro"
              id="logradouro"
              value={
                endereco.nmLog + ' ' + endereco.nrLog + ', ' + endereco.nmBairro
              }
            />
          </form>
        </div>
      </DivDadosPessoais>
      <CardFinalizarCompra>
        <h2>Resumo do pedido</h2>
        {carrinho?.map((produto, i) => (
          <>
            <Item key={i}>
              <h3>{produto.nmProduto}</h3>
              <p>R$ {produto.vlUnitario}</p>
              <span>{produto.qtProduto}</span>
            </Item>
          </>
        ))}
        <h3>Total: {total}</h3>
        <button>Finalizar compra</button>
      </CardFinalizarCompra>
    </PageCompra>
  );
}
