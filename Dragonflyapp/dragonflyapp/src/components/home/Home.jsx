import React, { useState, useEffect, useRef } from 'react';

import stellantis from '../../images/stell-logo-blue.svg';
import controleDroneCelular from '../../images/controleDroneCelular.jpg';
import droneNaMao from '../../images/droneNaMao.jpg';
import dronesGemeos from '../../images/dronesGemeos.jpg';
import droneCima from '../../images/droneCima.jpg';

import { motion } from 'framer-motion';
import {
  DivApp,
  DivCarrossel,
  DivHome,
  DivInner,
  DivItem,
  DivLinkProdutos,
} from './HomeStyle';

import dragonfly from '../../images/dragonfly.png';
import { Link } from 'react-router-dom';

const images = [controleDroneCelular, droneNaMao, dronesGemeos, droneCima];

export default function Home() {
  const carousel = useRef();

  const [width, setWidth] = useState(0);

  useEffect(() => {
    setWidth(carousel.current?.scrollWidth - carousel.current?.offsetWidth);
  }, []);

  return (
    <DivHome>
      <DivApp>
        <DivCarrossel
          ref={carousel}
          as={motion.div}
          whileTap={{ cursor: 'grabbing' }}>
          <DivInner
            as={motion.div}
            drag="x"
            dragConstraints={{ right: 0, left: -width }}>
            {images.map((img, i) => (
              <DivItem key={i}>
                {img === controleDroneCelular ? (
                  <h2>Controle pelo celular 📱</h2>
                ) : img === droneNaMao ? (
                  <h2>Drones fáceis de manusear 🕹️</h2>
                ) : img === dronesGemeos ? (
                  <h2>Os mais velozes do mercado 🚀</h2>
                ) : (
                  <h2>Ache o ideal para sua empresa 💡</h2>
                )}
                <img src={img} alt="drone" style={{ width: '100%' }} />
                <DivLinkProdutos
                  className="link-produtos-div"
                  style={{ width: '100%' }}>
                  <Link to="/produtos" className="link-produtos">
                    Confira
                  </Link>
                </DivLinkProdutos>
              </DivItem>
            ))}
          </DivInner>
        </DivCarrossel>
      </DivApp>
      <section>
        <h1>
          Sobre nós
          <img src={dragonfly} alt="" align="center" />
        </h1>
        <p>
          A Dragonfly Drones é um e-commerce de drones para entregas, em busca
          de apoiar o meio ambiente diminuindo a poluição e também preservar a
          vida humana diminuindo os acidentes de trânsito.
        </p>
        <p>
          Temos como nossa parceira e fornecedora a empresa &nbsp;&nbsp;
          <a href="https://www.stellantis.com" target="_blank" rel="noreferrer">
            <img src={stellantis} alt="" />
          </a>
          &nbsp;&nbsp;, a melhor montadora de veículos do mundo, e juntos
          fornecemos a solução ideal para sua empresa e para o meio ambiente.
        </p>
        <p>
          Nós estamos sempre atrás de inovação e por isso buscamos trazê-la para
          todos, dessa maneira a Dragonfly disponibiliza drones para qualquer
          tamanho de empresa, desde as pequenas até as grandes.
        </p>
        <p>
          Se você busca dar um upgrade nas entregas da sua empresa e ao mesmo
          tempo auxiliar na preservação do meio ambiente, você está no lugar
          certo.
        </p>
        <DivLinkProdutos className="link-produtos-div">
          <Link
            id="link-produto-section"
            to="/produtos"
            className="link-produtos">
            Confira nossos produtos
          </Link>
        </DivLinkProdutos>
      </section>
    </DivHome>
  );
}
