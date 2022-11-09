import React from 'react'
import ShoppingCart from '../../images/shopping-cart.svg'
import { Btn } from './BtnCarrinhoStyle'
export default function BtnCarrinho() {
  return (
    <Btn>
        <img src={ShoppingCart} alt="Carrinho de compras" />
        <div>3</div>
    </Btn>
  )
}
