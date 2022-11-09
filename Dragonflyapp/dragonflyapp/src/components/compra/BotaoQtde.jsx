import React from 'react';
import styled from 'styled-components';

export default function BotaoQtde({quantidade, setQuantidade}) {
  const incremento = () => {
    setQuantidade(quantidade + 1);
  };
  const decremento = () => {
    if (quantidade <= 1) {
      setQuantidade(1);
    } else {
      setQuantidade(quantidade - 1);
    }
  };
  const hanldeChange = async (e) => {
    setQuantidade(Number(e.target.value));
  };
  
  const DivBtn = styled.div`
    display: flex;
    flex-direction: row;
    column-gap: 5px;
    input {
      text-align: center;
      width: 50px;
      ::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
      }
      border: none;
      cursor: default;
    }
    :focus {
      outline: 3px solid #35a14d;
    }
  `;

  const Btn = styled.button`
    height: 30px;
    width: 30px;
    background-color: #fff;
    border: none;
    color: #000000be;
    font-size: 20px;
    font-family: 'Roboto', sans-serif;
    transition: all 0.1s ease-in-out;
    :hover {
      background-color: #c4c2c2;
      cursor: pointer;
    }
    :focus {
      background-color: #a19f9f;
    }
  `;

  return (
    <DivBtn>
      <Btn className="diminui" onClick={decremento}>
        -
      </Btn>
      <input
        className="quantidade-texto"
        type="number"
        onChange={hanldeChange}
        value={quantidade}
        pattern="[0-9]*"
      />
      <Btn className="aumenta" onClick={incremento}>
        +
      </Btn>
    </DivBtn>
  );
}
