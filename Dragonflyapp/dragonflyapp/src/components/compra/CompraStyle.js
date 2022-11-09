import styled from 'styled-components';

export const PageCompra = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 20px;
`;

export const CardCompra = styled.div`
  display: flex;
  justify-content: space-around;
  width: 50%;
  height: 60%;
  max-width: 700px;
  padding: 10px;
  color: #303630;
  background-color: #fff;
  border-radius: 8px;
  background-color: #b8bab8;

  .valor {
    font-weight: bold;
    font-size: 30px;
  }
  figure {
    width: 40%;
    display: flex;
    justify-content: center;
    align-items: center;
    img {
      width: 100%;
      border-radius: 5px;
    }
  }
  @media screen and (max-width: 500px) {
    flex-direction: column;
    width: 100%;
    align-items: center;

    figure {
      justify-content: center;
      width: 80%;
    }
  }
  @media screen and (min-width: 501px) {
    width: 100%;
    column-gap: 10px;
    figure {
      width: 80%;
    }
  }
  @media screen and (max-width: 768px) {
    margin-top: 70px;
  }
`;

export const DescProd = styled.div`
  display: flex;
  flex-direction: column;
  width: 50%;
  row-gap: 5px;
  select {
    padding: 5px;
    border: none;
    border-radius: 5px;
  }
  #btnCompra {
    color: #fff;
    background-color: #0c872b;
    border: none;
    border-radius: 5px;
    padding: 10px;
    transition: all 0.3s ease-in-out;
    :hover {
      cursor: pointer;
      background-color: #0c5f1b;
    }
  }
  @media screen and (max-width: 768px) {
    width: 100%;
    h1 {
      font-size: 1.5rem;
    }
  }
`;
