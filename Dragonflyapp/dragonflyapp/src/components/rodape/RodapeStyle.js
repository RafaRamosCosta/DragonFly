import styled from 'styled-components';

export const Footer = styled.footer`
  display: flex;
  flex-direction: column;
  background-color: #0c872b;
  color: #fff;
  padding: 1.5rem 2rem;
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
      a {
        color: #fff;
        text-decoration: none;
        transition: all 0.3s ease-in-out;
        :hover {
          color: #000;
          transform: scale(1.25);
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
        }
      }
    }
  }
  h2 {
    margin: 0;
  }
  p {
    margin: 2rem 0 0 0;
  }
`;
