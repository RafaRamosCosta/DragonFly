import React, { useState } from 'react'
import axios from 'axios'
import { Form, CadDiv, Button } from '../cadastro/CadastroStyle'
export default function CadastroContatoFunc() {
  const funcionario = JSON.parse(sessionStorage.getItem('funcionario'));

  const [contato, setContato] = useState({
    func: funcionario,
    nrTelefone: '',
    emailFunc: '',
  })

  const handleChange = (e) => {
    setContato({...contato, [e.target.name]: e.target.value})
    console.log(contato)
  }

  const handleSubmit = (e) => {
    e.preventDefault()
    axios({
      method: 'POST',
      url: 'http://localhost:8080/DragonflyAPI/rest/contatofuncionario/',
      headers: {
        'Content-Type': 'application/json',
      },
      data: contato,
    }).then((res) => {
      if (res.status === 201) {
        sessionStorage.setItem('contato', JSON.stringify(res.data))
        window.location.href = '/login'
      } else {
        alert('Erro ao cadastrar contato, informe dados válidos!')
      }
    }).catch((error) => console.log(error));
  }
  return (
    <CadDiv>
        <Form onSubmit={handleSubmit}>
        <h1>{funcionario?.nmFunc} preencha seus dados de contato</h1>
        <label htmlFor="emailFunc">Email</label>
        <input type="text" name="emailFunc" placeholder="seuemail.@gmail.com" onChange={handleChange} />

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
