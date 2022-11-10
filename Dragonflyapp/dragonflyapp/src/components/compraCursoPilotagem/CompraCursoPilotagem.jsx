import React, { useState } from 'react';
import IntroCursoPilotagem from '../../videos/videoIntroducaoCurso.mp4';
import { Link } from 'react-router-dom';
import {
  ContainerBuyCourse,
  BuyDiv,
  CompraCursoPage,
  BuyDesc,
} from './CompraCursoPilotagemStyle';
import arrowDown from '../../images/arrow-down.svg';
import arrowUp from '../../images/arrow-up.svg';
import { CardCompra } from '../addCarrinho/AddCarrinhoStyle';
export default function CursoPilotagem() {
  const [open, setOpen] = useState(true);

  const handleOpen = () => {
    setOpen(!open);
  };

  return (
    <CompraCursoPage>
      <CardCompra>
        <ContainerBuyCourse>
          <h1>Curso de Pilotagem</h1>
          <video autoPlay muted controls loop src={IntroCursoPilotagem}></video>
        </ContainerBuyCourse>
        <BuyDesc>
          <button onClick={handleOpen} className="btnDesc">
            {open ? (
              <img
                src={arrowUp}
                alt=""
                style={{ width: '20px' }}
                align="center"
              />
            ) : (
              <img
                src={arrowDown}
                alt=""
                style={{ width: '20px' }}
                align="center"
              />
            )}
            Descrição
          </button>
          {open && (
            <>
              <p>
                Curso de duração de 120 horas com exercícios de pilotagem e
                reflexo.
              </p>
              <p>
                É ideal para quem quer pilotar nossos drones com habilidade, e o
                melhor para o treinamento dos entregadores da sua empresa.
              </p>
            </>
          )}
          <BuyDiv>
            <h2>R$ 199,99</h2>
            <Link>Compre Agora</Link>
          </BuyDiv>
        </BuyDesc>
      </CardCompra>
    </CompraCursoPage>
  );
}
