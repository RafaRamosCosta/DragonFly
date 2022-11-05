import styled from 'styled-components';

export const DivForm = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top: 40px;
  border-radius: 3px;
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
    ::-webkit-inner-spin-button{
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
  button {
    padding: 5px;
    border: none;
    background-color: #0c5c11;
    cursor: pointer;
    margin-top: 10px;
    padding: 10px;
    border-radius: 5px;
    color: #fff;
    :hover {
      background-color: #1c8d19;
      transform: scale(1.1);
    }
  }
`;

