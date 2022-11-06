import styled from 'styled-components';

export const HeaderMobile = styled.header`
  display: flex;
  position: fixed;
  width: 100%;
  z-index: 10;
  top: 0;
  background-color: #0c872b;
  justify-content: space-around;
  @media screen and (min-width: 769px) {
    width: 100%;
    display: none;
  }

  div,
  h2 {
    display: inline;
    @media screen and (max-width: 384px) {
      font-size: 1rem;
    }
  }
  h2 {
    @media screen and (max-width: 800px) {
      margin-left: 30vw;
      margin-right: 10vw;
    }
    @media screen and (max-width: 550px) {
      margin-left: 20vw;
      margin-right: 5vw;
    }
    @media screen and (max-width: 455px) {
      margin-left: 10vw;
    }
  }
  img {
    width: 100px;
  }

  nav {
    position: absolute;
    top: 55px;
    left: 0;
    display: flex;
    padding-left: 20px;
    align-self: flex-start;
    flex-direction: column;
    align-items: flex-start;
    height: 100vh;
    background-color: #0c872b;
    width: 220px;
    #login-icon {
      width: 25px;
    }
    a {
      color: #fff;
      text-decoration: none;
      font-size: 1.5rem;
      transition: all 0.3s ease-in-out;
      :hover {
        transform: scale(1.25);
        color: #303630;
      }
    }
    .login {
      color: #fff;
      text-decoration: none;
      font-size: 1.5rem;
      align-content: center;
      transition: all 0.3s ease-in-out;
      :hover {
        transform: scale(1.25);
        color: #303630;
      }
    }
  }
  .header-fechado {
    display: flex;
    align-items: center;
    justify-content: space-between;
    nav {
      display: none;
    }
  }
  .header-aberto {
    display: flex;
    align-items: center;
    justify-content: space-between;
    nav {
      padding-top: 5rem;
      row-gap: 50px;
      font-size: 25px;
    }
  }
`;
