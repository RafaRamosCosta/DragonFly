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
            <li>📞 (11) 9111-1111</li>
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
      </div>
      <p>&copy;2022 Dragonfly Drones - Todos os direitos reservados</p>
    </Footer>
  );
}
