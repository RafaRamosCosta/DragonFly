import styled from 'styled-components';

export const CompraCursoPage = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
`;
export const ContainerBuyCourse = styled.div`
  display: flex;
  flex-direction: column;
  row-gap: 10px;
  width: 100%;
  max-width: 400px;
  
  video {
    
    width: 100%;
    min-width: 300px;
    max-width: 400px;
  }
  @media (max-width: 355px) {
    h1{
        font-size: 1.5rem;
    }
    video{
      min-width: 250px;
    }
  }
`;
export const BuyDesc = styled.div`
  
  .btnDesc{
    margin-top: 10px;
    width: fit-content;
    border: none;
    background-color: #0c872b;
    color: #fff;
    text-align: left;
    padding: 5px 5px 0 0;
    border-radius: 5px;
    font: 12px bold -apple-system, BlinkMacSystemFont, 
          'Segoe UI', 'Roboto', 'Oxygen', 'Ubuntu', 'Cantarell', 
          'Fira Sans', 'Droid Sans', 'Helvetica Neue', sans-serif;

    
    @media (min-width: 501px) {
      display: none;
    }
  }
  div {
    height: fit-content;
  }
  
  p{
    width: 100%;
    margin-top: 10px;
  }
  @media (max-width: 500px){
    p{
      width: 100%;
      margin-top: 10;
    }
  }

`
export const BuyDiv = styled.div`

  display: flex;
  flex-direction: column;
  width: 60%;
  justify-content: center;
  margin-top: 20px;
  height: 120px;
    h2 {
      margin-left: 5px;
      color: #0c872b;
      font-size: 30px;
    }
    a {
      font-size: 18px;
      padding: 8px;
      color: #0c872b;
      text-decoration: none;
      border: #0c872b solid 2px;
      border-radius: 50px;
      transition: all 0.3s ease-in-out;
      text-align: center;
      width: fit-content;
      :hover {
        background-color: #0c872b;
        color: #fff;
      }
    }
    @media (max-width: 500px) {
      width: 100%;
      justify-content: top;
      align-items: flex-start;
      margin-top: 0;
    }
`;