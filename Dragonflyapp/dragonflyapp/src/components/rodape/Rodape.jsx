import React from 'react';
import { Link } from 'react-router-dom';
import { Footer } from './RodapeStyle';

export default function Rodape() {
  return (
    <Footer>
      <div>
        <section>
          <h2 id="contato">Fale conosco</h2>
          <ul>
            <li>📞 (11) 91111-1111</li>
            <li>📧 dragonfly.@gmail.com</li>
          </ul>
        </section>

        <section>
          <h2 id="mapa">Mapa do site</h2>
          <div className="divLinks">
            <Link to="/">Página Inicial</Link>
            <Link to="/cadastro">Cadastro</Link>
            <Link to="/login">Login</Link>
            <Link to="/produtos">Produtos</Link>
          </div>
        </section>

        <section>
          <h2 id="redes">Redes Sociais</h2>
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

        <section>
          <h2>Pilotagem</h2>
          <Link to="/produtos">Tutorial</Link>
          <Link to="/curso">Curso de Pilotagem</Link>
        </section>
      </div>
      <p>&copy;2022 Dragonfly Drones - Todos os direitos reservados</p>
    </Footer>
  );
}
