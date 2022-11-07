import styled from 'styled-components';

export const PageProd = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  row-gap: 20px;
  padding: 20px;
  @media screen and (max-width: 768px) {
    #main-h1 {
      margin-top: 45px;
      font-size: 1.6rem;
    }
  }
  #linkTutorial {
    color: #0c872b;
    text-decoration: none;
    border: #0c872b solid 2px;
    border-radius: 50px;
    padding: 5px; 
    transition: all 0.3s ease-in-out;
    :hover {
      background-color: #0c872b;
      color: #fff;
    }
  }
`;
export const DivProd = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 10px;
  background-color: #0f521d;
  border-radius: 7px;
  max-width: 500px;
  row-gap: 2px;
  .compra {
    text-align: center;
    border: none;

    background-color: #0c5c11;
    cursor: pointer;

    padding: 10px;
    border-radius: 5px;
    color: #fff;
    width: 40%;
    transition: all 0.3s ease-in-out;
    :hover {
      background-color: #1c8d19;
      transform: scale(1.1);
    }
  }
  @media screen and (max-width: 550px) {
    h1 {
      font-size: 1.5rem;
    }
    h2 {
      font-size: 1.2rem;
    }
    p {
      font-size: 0.8rem;
    }
  }
`;

export const DivVideoWrapper = styled.div`
  display: flex;
  flex-direction: column;
  row-gap: 20px;
  justify-content: center;
  align-items: center;
  video {
    min-width: 300px;
    max-width: 50%;
    min-height: 200px;
    max-height: 50%;
  }
`;
