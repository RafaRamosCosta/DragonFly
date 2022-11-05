import styled from 'styled-components';

export const CadDiv = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top: 40px;
  border-radius: 3px;
`;

export const Form = styled.form`
  background-color: #3d4654;
  padding: 20px;
  border-radius: 5px;
  margin-bottom: 40px;
  display: flex;
  flex-direction: column;

  h1 {
    color: #8cd19b;
    margin: 0;
  }
  input {
    outline: none;
    border: none;
    height: 1.5rem;
    margin: 5px 0;
    border-radius: 5px;
    padding: 5px;
    :focus {
      outline: solid 2px #8cd19b;
    }
    ::-webkit-inner-spin-button {
      -webkit-appearance: none;
      margin: 0;
    }
  }
  .divButtons {
    display: flex;
    justify-content: space-around;
  }
`;

export const Button = styled.button`
  border: none;
  background-color: #0c5c11;
  cursor: pointer;
  margin-top: 10px;
  padding: 10px;
  border-radius: 5px;
  color: #fff;
  width: 40%;
  transition: all 0.3s ease-in-out;
  :hover {
    background-color: #1c8d19;
    transform: scale(1.1);
  }
  
`;
