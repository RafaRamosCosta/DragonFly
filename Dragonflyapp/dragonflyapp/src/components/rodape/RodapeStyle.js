import styled from 'styled-components';

export const Footer = styled.footer`
  display: flex;
  flex-direction: column;
  background-color: #0c872b;
  color: #fff;
  padding: 1.5rem 2rem;
  .ContatoFormDiv {
    display: flex;
    justify-content: center;
    align-items: center;
    form {
      display: flex;
      flex-direction: column;
      row-gap: 5px;
      width: fit-content;
      min-width: 100px;
      input, textarea {
        padding: 5px;
        border-radius: 5px;
        border: none;
        resize: none;
      }
      textarea {
        height: 80px;
      }
    }
  }
  div {
    display: flex;
    justify-content: center;
    column-gap: 10rem;
    section {
      display: flex;
      flex-direction: column;
      text-align: center;
      row-gap: 5px;
      .divLinks {
        display: flex;
        justify-content: center;
        column-gap: 13px;
        flex-wrap: wrap;
      }
      .ContatoFormDiv{
        button {
          color: #fff;
          background-color: #0c5f1b;
          border: none;
          border-radius: 5px;
          padding: 10px;
          transition: all 0.3s ease-in-out; 
          :hover {
            background-color: #074212;
          }
          
        }
         input, textarea, button{
          transition: all 0.3s ease-in-out; 
          :hover {
            cursor: pointer;
            
            transform: scale(1.02);
          }
        }
      }
      }
      a {
        color: #fff;
        text-decoration: none;
        transition: all 0.3s ease-in-out;
        :hover {
          color: #000;
          transform: scale(1.25);
        }
        :focus {
          outline: solid 2px #8cd19b;
        }
      }
      ul {
        margin: 0;
        display: flex;
        flex-direction: column;
        row-gap: 5px;
        padding: 0;

        li {
          list-style-type: none;
          transition: all 0.3s ease-in-out;
          :hover {
            color: #000;
            transform: scale(1.05);
          }
        }
      }
    }
  
  .mapa, .redes, .cursos{
    margin-top: 4.5rem;
  }
  h2 {
    margin: 0;
  }
  p {
    margin: 2rem 0 0 0;
    text-align: center;
  }
  @media screen and (max-width: 700px) {
    font-size: 0.8rem;
    .divLinks {
      
    }
    div {
      flex-direction: column;
      row-gap: 10px;
    }
  }
  @media screen and (min-width: 702px) and (max-width: 1255px) {
    div {
      column-gap: 20px;
    }
  }
`;
