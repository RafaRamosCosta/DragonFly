import React from 'react';
import { Link } from 'react-router-dom';
import { Footer } from './RodapeStyle';

export default function Rodape() {
  return (
    <Footer>
      <div>
        <section id='contato'>
          <h2>Fale conosco</h2>
          <ul>
            <li>
              <a href="#">📞 (11) 91111-1111</a>
            </li>
            <li>
              <a href="mailto:dragonfly.@gmail.com">📧 dragonfly.@gmail.com</a>
            </li>
          </ul>
          OU
          <div className="ContatoFormDiv">
          <form action="">
            <label>Nos mande uma mensagem</label>
            <input type="text" placeholder="Seu nome" />
            <textarea placeholder="Nos mande uma mensagem" />
            <button onClick={"submit"}>Enviar</button>
          </form>
          </div>
        </section>

        <section className='mapa'>
          <h2>Mapa do site</h2>
          <div className="divLinks">
            <Link to="/">Página Inicial</Link>
            <Link to="/cadastro">Cadastro</Link>
            <Link to="/login">Login</Link>
            <Link to="/produtos">Produtos</Link>
          </div>
        </section>

        <section className='redes'>
          <h2>Redes Sociais</h2>
          <div className="divLinks">
              <a href="https://www.facebook.com/" target="_blank" rel="noreferrer">
                <img width="30px" src="https://img.icons8.com/fluent/48/000000/facebook-new.png" alt="Facebook" />
              </a>
              <a href="https://www.instagram.com/" target="_blank" rel="noreferrer">
                <img width="30px" src="https://img.icons8.com/fluent/48/000000/instagram-new.png" alt="Instagram" />
              </a>
              <a href="https://twitter.com/" target="_blank" rel="noreferrer">
                <img width="30px" src="https://img.icons8.com/fluent/48/000000/twitter.png" alt="Twitter" />
              </a>
              <a href="https://linkedin.com/" target="_blank" rel="noreferrer">
                <img width="30px" src="https://img.icons8.com/fluent/48/000000/linkedin.png" alt="Linkedin" />
              </a>
          </div>  
        </section>

        <section className='cursos'>
          <h2>Pilotagem</h2>
          <Link to="/produtos">Tutorial</Link>
          <Link to="/curso">Curso de Pilotagem</Link>
        </section>
      </div>
      <p>&copy;2022 Dragonfly Drones - Todos os direitos reservados</p>
    </Footer>
  );
}
