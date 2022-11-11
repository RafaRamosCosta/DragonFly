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
  const [total, setTotal] = useState(0);
  const [formasPagto, setFormasPagto] = useState([]);
  let carrinho = JSON.parse(localStorage.getItem('carrinho'));
  let endereco = JSON.parse(sessionStorage.getItem('endereco'));

  useEffect(() => {
    if (!userData) {
      window.location = '/login';
    }
    axios(
      `http://localhost:8080/DragonflyAPI/rest/contatoempresa/${userData.idEmpresa}`
    )
      .then((response) => {
        setContato(response.data);
      })
      .catch((error) => console.log(error));
    axios('http://localhost:8080/DragonflyAPI/rest/formapagto')
      .then((response) => {
        setFormasPagto(response.data);
      })
      .catch((error) => console.log(error));
    setTotal(handleTotal);
  }, []);

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
        <div className="divLogo">
          <img src={logo} alt="" />
          <i>DragonflyDrones</i>
        </div>
        <div>
          <form action="">
            <h3>Verifique as informações da sua empresa</h3>
            <label htmlFor="nome">Nome</label>
            <input
              type="text"
              readOnly
              disabled
              name="nome"
              id="nome"
              value={userData.nmFantasia}
            />
            <label htmlFor="email">Email</label>
            <input
              type="email"
              readOnly
              disabled
              name="email"
              id="email"
              value={contato.emailEmp}
            />
            <label htmlFor="telefone">Telefone</label>
            <input
              type="telefone"
              readOnly
              disabled
              name="telefone"
              id="telefone"
              value={contato.nrTelefone}
            />
            <label htmlFor="logradouro">Endereço</label>
            <input
              type="text"
              readOnly
              disabled
              name="logradouro"
              id="logradouro"
              value={
                endereco?.log?.nmLog +
                ' ' +
                endereco?.nrLog +
                ', ' +
                endereco?.log?.bairro?.nmBairro
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
        <h3>Total: R${(total).toFixed(2)}</h3>
        <select name="formaPagto" id="">
          {formasPagto.map((forma, i) =>(
            <option key={i} value={JSON.stringify(forma)}>{forma.nmFormaPagto}</option>
          ))}
        </select>
        <button>Finalizar compra</button>
      </CardFinalizarCompra>
    </PageCompra>
  );
}
