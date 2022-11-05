import React from 'react';
import { Link } from 'react-router-dom';
import {DivProd} from './ProdutoStyle';


export default function Produto() {
    return (
        <DivProd>
            <h1>Drone XXX</h1>
            <p>"<img src="imagem_drone" alt="" />"</p>
            <h2>Descrição do Produto</h2>
            <p style={{color: "#fffa6b"}}>Made In Heaven</p>
            <h2>Preço do Produto</h2>
            <p style={{color: "#ff0400"}}>Highway to Hell</p>
            <Link to="algum_lugar_pra_relaxar" className='compra'>🛒Comprar</Link>
        </DivProd>
    );
}