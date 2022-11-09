import styled from 'styled-components';

export const DivForm = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top: 40px;
  border-radius: 3px;
  h1 {
    @media screen and (max-width: 410px) {
      font-size: 1rem;
      margin: 30px 0 10px 0;
    }
    @media screen and (min-width: 411px) {
      font-size: 1.2rem;
      margin: 30px 0 10px 0;
    }
    @media screen and (min-width: 700px) {
      font-size: 2rem;
      margin: 30px 0;
    }
  }
`;

export const FormProd = styled.form`
  background-color: #3d4654;
  width: 50%;
  padding: 20px;
  border-radius: 5px;
  margin-bottom: 40px;
  display: flex;
  flex-direction: column;
  row-gap: 10px;

  input {
    ::-webkit-inner-spin-button {
      -webkit-appearance: none;
      margin: 0;
    }
    padding: 8px;
    appearance: none;
  }
  textarea {
    resize: none;
    outline: none;
  }
  .divBtnProd {
    display: flex;
    justify-content: space-around;
    button {
      align-self: center;
      padding: 5px;
      border: none;
      background-color: #0c5c11;
      cursor: pointer;
      margin-top: 10px;
      padding: 10px;
      border-radius: 5px;
      width: 40%;
      color: #fff;
      transition: all 0.3s ease;
      :hover{
        background-color: #1c8d19;
      }
    }
    @media screen and (max-width: 600px) {
      flex-direction: column;
      button {
        width: 100%;
      }
    }
  }
  @media screen and (max-width: 600px) {
    width: 80%;
  }
`;
