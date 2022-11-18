import styled from 'styled-components';

export const PageProd = styled.div`
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  align-items: center;
  justify-content: center;
  row-gap: 20px;
  padding: 20px;
  @media screen and (max-width: 768px) {
    #main-h1 {
      margin-top: 45px;
      font-size: 1rem;
    }
    h2 {
      font-size: 0.8rem;
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
  padding: 8px;
  background-color: #0c872b;
  border-radius: 7px;
  max-width: 400px;
  row-gap: 2px;
  .addCarrinho {
    text-align: center;
    border: none;
    background-color: #0c5c11;
    cursor: pointer;
    padding: 10px;
    border-radius: 5px;
    color: #fff;
    font-size: 0.8rem;
    width: 40%;
    transition: all 0.3s ease-in-out;
    text-decoration: none;
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
  max-width: 500px;
  padding: 20px;
  
  video {
    border-radius: 10px;
    min-width: 300px;
    max-width: 100%;
    min-height: 200px;
    max-height: 100%;
    transition: transform 0.3s ease-in-out;
      :hover {
        outline: 3px solid #35a14d;
        transform: scale(1.07);
      }
  }
  @media screen and (max-width: 768px) {
    padding: 0;
  }
`;

export const DivCurso = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 65vh;
  div {
    display: flex;
    justify-content: center;
    img {
      align-self: center;
      width: 60%;
      min-width: 300px;
      border-radius: 10px;
      transition: transform 0.3s ease-in-out;
      :hover {
        outline: 3px solid #35a14d;
        transform: scale(1.1);
      }
    }
  }
  @media screen and (max-width: 768px) {
    height: 60vh;
  }
  @media screen and (max-width: 720px) {
    height: 40vh;
  }
`;
