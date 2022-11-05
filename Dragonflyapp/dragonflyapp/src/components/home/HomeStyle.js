import styled from 'styled-components';

export const DivHome = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  row-gap: 3rem;
  section {
    width: 80vw;
    height: 90vh;
    img {
      width: 15%;
      transition: all 0.3s ease-in-out;
      :hover {
        transform: scale(1.1);
      }
    }
  }
`;

export const DivLinkProdutos = styled.div`
  transition: all 0.3s ease-in-out;
  margin-top: 25px;
  width: fit-content;

  .link-produtos {
    padding: 5px;
    font-size: 20px;
    color: #0c872b;
    text-decoration: none;
    border: #0c872b solid 2px;
    border-radius: 50px;
    transition: all 0.3s ease-in-out;
    :hover {
      background-color: #0c872b;
      color: #fff;
    }
  }
`;

export const DivApp = styled.div`
  max-width: 900px;
  display: flex;
  align-items: center;
  @media screen and (max-width: 900px) {
    margin-top: 150px;
    height: 400px;
  }
`;

export const DivInner = styled.div`
  display: flex;
  @media screen and (max-width: 780px) {
    padding-left: 280px;
   
  }
`;

export const DivCarrossel = styled.div`
  cursor: grab;
  overflow: hidden;
`;

export const DivItem = styled.div`
  min-width: 400px;
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
