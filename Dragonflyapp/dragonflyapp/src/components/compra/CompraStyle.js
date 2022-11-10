import styled from 'styled-components';

export const PageCompra = styled.div`
  display: flex;
  justify-content: center;
  height: 100%;
  padding: 20px;
  form {
    display: flex;
    flex-direction: column;
    input {
      padding: 10px;
    }
  }
`;

export const DivDadosPessoais = styled.div`
  display: flex;
  z-index: 1;
  flex-direction: column;
  padding: 20px;
  background-color: #f5f5f5;
  border-right: 1px solid #0005;
  box-shadow: 5px 0 8px #0008;
  color: #404040;
  h1 {
    align-self: flex-start;
  }

  .divLogo {
    display: flex;
    justify-content: center;
    flex-direction: column;
    align-items: center;
    img {
      width: 200px;
    }
  }
`;

export const CardFinalizarCompra = styled.aside`
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding: 30px;
  background-color: #c3c2c8;
  color: #404040;
  h2 {
    margin-bottom: 20px;
  }
  button {
    padding: 10px;
    margin-top: 10px;
    border: none;
    border-radius: 5px;
    background-color: #085f63;
    font-size: 16px;
    color: #fff;
    transition: all 0.3s ease-in-out;
    :hover {
      background-color: #0a7b80;
      transform: scale(1.1);
    }
  }
`;

export const Item = styled.div`
  color: #fff;
  position: relative;
  margin-bottom: 15px;
  p {
    font-size: 0.8rem;
    color: #5b5b5b;
  }
  span {
    display: flex;
    justify-content: center !important;
    align-items: center !important;
    position: absolute;
    top: 0;
    right: 0;
    transform: translate(30%, -50%);
    background-color: #404040;
    border-radius: 50%;
    height: 15px !important;
    width: 15px !important;
    padding: 10px;
    font-size: 0.7rem;
  }
`;
