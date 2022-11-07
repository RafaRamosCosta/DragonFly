import React, { useEffect, useState } from 'react';
import axios from 'axios';
import tutorial from '../../videos/tutorial.mp4';
import poster from '../../images/postertutorial.png';
import { Link } from 'react-router-dom';
import { DivProd, DivVideoWrapper, PageProd } from './ProdutoStyle';

export default function Produto() {
  const userData = JSON.parse(sessionStorage.getItem('user'));
  const [produtos, setProdutos] = useState([]);

  useEffect(() => {
    if (userData) {
      axios('http://localhost:8080/DragonflyAPI/rest/produto').then(
        (response) => setProdutos(response.data)
      );
    } else {
      window.location = '/login';
    }
  }, []);
  return (
    <PageProd>
      <h1 id="main-h1">
        {userData?.nmFantasia
          ? `Aproveite nossas ofertas ${userData.nmFantasia}!`
          : `Produtos cadastrados!`}
      </h1>
       <a id="linkTutorial" href="#tutorial">Assista o Tutorial de Pilotagem</a>   
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
      <section>
        <DivVideoWrapper id='tutorial'>
        <h1>Tutorial de Pilotagem</h1>
          <video
            controls
            loop
            src={tutorial}
            poster={poster}
          />
        </DivVideoWrapper>
      </section>
    </PageProd>
  );
}
