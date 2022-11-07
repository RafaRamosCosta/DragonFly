import styled from 'styled-components';

export const DivLogin = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 3.64rem;
  margin-top: 10px;
`;

export const FormLogin = styled.form`
  min-width: 300px;
  min-height: 260px;
  background-color: #3d4654;
  padding: 15px;
  border-radius: 5px;
  display: flex;
  flex-direction: column;
  row-gap: 10px;
  h1 {
    color: #8cd19b;
    margin: 0;
    text-align: center;
  }
  input {
    padding: 10px;
    border: none;
    border-radius: 5px;
    :focus {
      outline: solid 2px #8cd19b;
    }
  }
`;

export const Button = styled.button`
  border: none;
  background-color: #0c5c11;
  cursor: pointer;
  padding: 8px;
  border-radius: 5px;
  color: #fff;
  margin-top: 10px;
  transition: all 0.3s ease-in-out;

  :hover {
    background-color: #1c8d19;
    transform: scale(1.05);
  }
  :focus {
    outline: solid 2px #8cd19b;
  }
`;
