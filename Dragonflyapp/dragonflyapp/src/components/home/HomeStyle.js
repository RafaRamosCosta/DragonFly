import styled from 'styled-components';

export const DivHome = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  row-gap: 3rem;
  width: 100%;
  section {
    display: flex;
    flex-direction: column;
    margin-bottom: 30px;
    padding: 10px;
    width: 60vw;
    img {
      min-width: 80px;
      max-width: 20%;
      transition: all 0.3s ease-in-out;
      :hover {
        transform: scale(1.1);
      }
    }
    @media screen and (max-width: 610px) {
      text-align: center;
      font-size: 0.8rem;
      row-gap: 20px;
    }
  }
`;

export const DivLinkProdutos = styled.div`
  margin-top: 25px;
  display: flex;
  justify-content: center;
  align-items: center;
  .link-produtos {
    padding: 5px;
    font-size: 20px;
    color: #0c872b;
    text-decoration: none;
    border: #0c872b solid 2px;
    border-radius: 50px;
    
    transition: all 0.3s ease-in-out;
    :hover {
      transform: scale(1.1);
      background-color: #0c872b;
      color: #fff;
    }
    :focus {
      outline: solid 2px #8cd19b;
    }
  }
  .link-produtos-div {
    @media screen and (max-width: 500px) {
      font-size: 12px;
    }
  }
`;

export const DivApp = styled.div`
  margin-top: 50px;
  max-width: 900px;
  display: flex;
  align-items: center;
  width: 100%;
  
  @media screen and (max-width: 900px) {
    margin-top: 150px;
    height: 400px;
  }
`;

export const DivInner = styled.div`
  display: flex;
`;

export const DivCarrossel = styled.div`
  cursor: grab;
  overflow: hidden;
  
`;

export const DivItem = styled.div`
  min-width: 400px;
  min-height: 400px;
  padding: 8px;
  transition: all 0.2s ease-in-out;
  text-align: center;
  :hover {
    transform: scale(1.02);
  }

  img {
    border-radius: 10px;
    pointer-events: none;
    @media screen and (max-width: 900px) {
      width: 50%;
    }
  }
`;
