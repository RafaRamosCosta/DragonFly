import styled from 'styled-components';

export const Btn = styled.button`
  background-color: #0c872b;
  border: none;
  color: white;
  border-radius: 50%;
  position: relative;
  padding: 0;
  :hover {
    cursor: pointer;
  }
  img {
    width: 22px;
  }
  div {
    display: flex;
    justify-content: center !important;
    align-items: center !important;
    position: absolute;
    bottom: 0;
    right: 0;
    background-color: red;
    border-radius: 50%;
    width: 15px !important;
    height: 15px !important;
    font-size: 10px !important;
    text-align: center;
    transform: translate(45%, 25%);
  }
`;
