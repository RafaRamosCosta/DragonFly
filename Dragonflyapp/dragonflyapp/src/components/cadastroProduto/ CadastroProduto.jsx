import React from 'react';
import { DivForm, FormProd } from './CadastroProdutoStyle';

export default function CadastroProduto() {
  return (
    <DivForm>
      <h1>Cadastre um Produto!</h1>
      <FormProd>
        <label htmlFor="nmProduto">Nome do Produto</label>
        <input type="text" name="nmProduto" placeholder="Ex.: Drone X" />

        <label htmlFor="dsProduto">Descrição do Produto</label>
        <textarea
          name="dsProduto"
          cols="30"
          rows="10"
          placeholder="Ex.: Espeficações técnicas"></textarea>

        <label htmlFor="vlUnitario">Valor Unitário</label>
        <input type="number" name="vlUnitario" placeholder="R$" />

        <button type="submit">Cadastrar</button>
        <button type="reset">Limpar</button>
      </FormProd>
    </DivForm>
  );
}
