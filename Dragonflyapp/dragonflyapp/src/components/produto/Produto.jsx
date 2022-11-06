import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import { DivProd, PageProd } from './ProdutoStyle';

export default function Produto() {
  const userData = sessionStorage.getItem("emp");

  const [produtos, setProdutos] = useState([]);
  useEffect(() => {
    axios('http://localhost:8080/DragonflyAPI/rest/produto').then((response) =>
      setProdutos(response.data)
    );
    if (!userData) {
      window.location = "/login";
    }
  }, []);

  
  return (
    <PageProd>
      <section>
        <h1>Tutorial de Pilotagem</h1>
      </section>
      {produtos.map((produto, i) => (
        <DivProd key={i}>
          <h1>{produto.nmProduto}</h1>
          <p>
            "<img src="imagem_drone" alt="" />"
          </p>
          <h2>Descrição do Produto</h2>
          <p style={{ color: '#fffa6b' }}>{produto.dsProduto}</p>
          <h2>Preço do Produto</h2>
          <p style={{ color: '#fff' }}>R$ {produto.vlUnitario}</p>
          <Link to="algum_lugar_pra_relaxar" className="compra">
            🛒Comprar
          </Link>
        </DivProd>
      ))}
    </PageProd>
  );
}
