import React, { useEffect, useState } from 'react';
import axios from 'axios';
import tutorial from '../../videos/tutorial.mp4';
import poster from '../../images/postertutorial.png';
import cursoDragonfly from '../../images/cursoDragonfly.gif';
import { Link } from 'react-router-dom';
import { DivCurso, DivProd, DivVideoWrapper, PageProd } from './ProdutoStyle';

export default function Produto() {
  const userData = JSON.parse(sessionStorage.getItem('user'));

  const [produtos, setProdutos] = useState([]);

  useEffect(() => {
    if (userData) {
      axios('http://localhost:8080/DragonflyAPI/rest/produto').then(
        (response) => setProdutos(response.data)
      );
    }
    else {
      window.location = '/login';
    }
  }, []);

  return (
    <PageProd>
      <h1 id="main-h1">
        {userData?.nmFantasia
          ? `Olá ${userData.nmFantasia}, aproveite nossas ofertas!`
          : `Produtos cadastrados!`}
      </h1>
      <h2>Confira o pacote do curso de pilotagem!</h2>

      <Link to="/compraCursoPilotagem">
        <DivCurso>
          <div>
            <img src={cursoDragonfly} alt="" />
          </div>
        </DivCurso>
      </Link>
      {produtos.map((produto) => (
        <DivProd key={produto.idProdruto} id="divProd">
          <h1>{produto.nmProduto}</h1>
          <p>
            "<img src="imagem_drone" alt="" />"
          </p>
          <p style={{ color: '#fff', fontWeight: 'bold', fontSize: '20px' }}>
            R$ {produto.vlUnitario}
          </p>
          <Link
            to="/addCarrinho"
            className="addCarrinho"
            onClick={() => sessionStorage.setItem('prodId', produto.idProduto)}>
            + Ver mais
          </Link>
        </DivProd>
      ))}

      <section>
        <DivVideoWrapper id="tutorial">
          <h1>Tutorial de Configuração</h1>
          <video controls loop src={tutorial} poster={poster}/>
        </DivVideoWrapper>
      </section>
    </PageProd>
  );
}
