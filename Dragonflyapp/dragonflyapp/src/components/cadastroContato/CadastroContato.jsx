import React from 'react'
import { Form, CadDiv } from '../cadastro/CadastroStyle'
export default function CadastroContato() {
  return (
    <CadDiv>
        <Form>
        <h1>Preencha seus dados de contato</h1>
        <label htmlFor="email">Email</label>
        <input type="text" name="email" placeholder="seuemail.@gmail.com" />

        <label htmlFor="telefone">Telefone</label>
        <input type="number" name="telefone" placeholder="999999999" />
        </Form>
    </CadDiv>
  )
}
