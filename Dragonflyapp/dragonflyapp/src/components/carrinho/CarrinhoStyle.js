import styled from 'styled-components';

export const PageCarrinho = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  position: fixed;
  height: 100vh;
  top: 0;
  right: 0;
  background: rgba(3, 100, 5, 0.65);
  backdrop-filter: blur(2.5px);
  -webkit-backdrop-filter: blur(2.5px);
  border-radius: 10px;
  border: 1px solid rgba(255, 255, 255, 0.18);
  z-index: 10;
  padding: 20px;
  span {
    align-self: flex-start;
  }
  @media screen and (max-width: 768px) {
    font-size: 10px;
  }
`;

export const CardProduto = styled.div`
  display: flex;
  position: relative;
  flex-direction: column;
  align-items: center;
  background-color: #fff;
  color: #303630;
  padding: 10px;
  border-radius: 5px;
  p {
    row-gap: 2px;
    color: #000;
  }
  span {
    position: absolute;
    top: 0;
    right: 0;
    transform: translate(20%, -45%);
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 50%;
    padding: 5px;
    background-color: red;
    :hover {
      cursor: pointer;
      img {
        transform: none;
      }
    }
    img {
      width: 20px;
    }
  }
`;
