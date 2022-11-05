import styled from 'styled-components';

export const Header = styled.header`
  display: flex;
  align-items: center;
  text-align: center;
  justify-content: space-around;
  background-color: #0c872b;
  padding: 0.2rem 0rem 0.2rem 1rem;
  @media screen and (max-width: 768px) {
    display: none;
  }
  img {
    width: 12vw;
    transition: all 0.3s ease-in-out;
      :hover {
        transform: scale(1.25);
      }
  }
  h2 {
    font-size: 2rem;
  }
  nav {
    display: flex;
    justify-content: flex-end;
    column-gap: 20px;
    a {
      color: #fff;
      text-decoration: none;
      transition: all 0.3s ease-in-out;
      :hover {
        transform: scale(1.25);
        color: #303630;
      }
    }
  }
`;
