import React from 'react'
import ShoppingCart from '../../images/shopping-cart.svg'
import { Btn } from './BtnCarrinhoStyle'
export default function BtnCarrinho({ renderCarrinho }) {
  return (
    <Btn onClick={renderCarrinho}>
        <img src={ShoppingCart} alt="Carrinho de compras" />
        <div>{JSON.parse(localStorage.getItem('carrinho'))?.length || 0}</div>
    </Btn>
  )
}
