import React, { useState } from 'react'
import axios from 'axios'
import { Form, CadDiv, Button } from '../cadastro/CadastroStyle'
export default function CadastroContato() {
  const empresa = JSON.parse(sessionStorage.getItem('empresa'));

  const [contato, setContato] = useState({
    empresa: empresa,
    nrTelefone: '',
    emailEmp: '',
  })

  const handleChange = (e) => {
    setContato({...contato, [e.target.name]: e.target.value})
    console.log(contato)
  }

  const handleSubmit = (e) => {
    e.preventDefault()
    axios({
      method: 'POST',
      url: 'http://localhost:8080/DragonflyAPI/rest/contatoempresa/',
      headers: {
        'Content-Type': 'application/json',
      },
      data: contato,
    }).then((response) => {
      window.location.href = '/login';
    }).catch((error) => console.log(error));
  }
  return (
    <CadDiv>
        <Form onSubmit={handleSubmit}>
        <h1>Preencha seus dados de contato</h1>
        <label htmlFor="emailEmp">Email</label>
        <input type="text" name="emailEmp" placeholder="seuemail.@gmail.com" onChange={handleChange} />

        <label htmlFor="nrTelefone">Telefone</label>
        <input type="number" name="nrTelefone" placeholder="999999999" onChange={handleChange} />
        <div className="divButtons">
          <Button type="submit">Cadastrar</Button>
          <Button type="reset">Limpar</Button>
        </div>
        </Form>
    </CadDiv>
  )
}
