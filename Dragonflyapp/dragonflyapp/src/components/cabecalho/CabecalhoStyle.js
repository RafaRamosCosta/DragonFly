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
    font-style: italic;
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
      img {
        width: 25px;
        :hover {
          transform: none;
        }
      }
    }
    button {
      background-color: transparent;
      border: none;
      hover {
        img {
          transform: none;
        }
      }
      img {
        width: 25px;
      }
    }
    #btn-logout {
      background-color: #0c872b;
      border: none;
      color: white;
      font-size: 15px;
      padding-top: 2px;
      transition: all 0.3s ease-in-out;
      :hover {
        transform: scale(1.25);
        color: #303630;
        cursor: pointer;
        img {
          transform: none;
        }
      }
    }
    #loginLink {
      img:hover {
        transform: none;
      }
    }
  }
`;
