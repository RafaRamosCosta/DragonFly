import styled from 'styled-components';

export const PageCarrinho = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center !important;
  justify-content: center !important;
  position: fixed;
  height: 100%;
  top: 0;
  right: 0;
  background: rgba(3, 100, 5, 0.65);
  backdrop-filter: blur(2.5px);
  -webkit-backdrop-filter: blur(2.5px);
  border-radius: 10px;
  border: 1px solid rgba(255, 255, 255, 0.18);
  z-index: 10;
  padding: 20px;
  #msgCarrinho {
    margin: 0;
    font-size: 1.5rem;
    @media screen and (max-width: 768px) {
      font-size: 1rem;
    }
  }

  span {
    align-self: flex-start;
  }
  .divProdutos {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    row-gap: 15px;
    margin-top: 20px;
    padding: 15px;
    overflow-y: auto;
    overflow-x: hidden;
    height: 80%;
    ::-webkit-scrollbar {
      width: 10px;
    }
    ::-webkit-scrollbar-track {
      box-shadow: inset 0 0 5px grey;
    }
    ::-webkit-scrollbar-thumb {
      background: #6dcd3f;
    }
    img {
      align-self: center;
      width: 300px;
    }
    @media screen and (max-width: 768px) {
      margin: 0;
      img {
        width: 200px;
      }
    }
  }

  a {
    background: #56a431;
    padding: 10px;
    border-radius: 5px;
    transition: all 0.3s ease-in-out;
    margin-top: 5px;
    text-decoration: none;
    color: #fff;
    :hover {
      margin-top: 10px;
      color: #fff !important;
    }
  }
  @media screen and (max-width: 768px) {
    margin: 0;
    padding: 20px;
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
      width: 20px !important;
    }
  }
`;
