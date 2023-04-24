# Remedy

API da aplicação de dosagem de remédios.

## Endpoints

- Medicamentos
    - [Cadastrar remédio](#cadastrar-remédio)
    - Apagar remédio
    - Alterar remédio
    - Listar todas os remédios
    - [Detalhar um remédio](#detalhar-remédio)
- Contas
- Categorias 
- Farmácia
- Dados de Balanço

---

### Cadastrar Remédio

`POST` /Remedy/api/cadastro

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----
| Nome | texto | sim | o nome do medicamento, que não deve estar em branco
| Dosagem  | double | sim | a dosagem do medicamento que o paciente está tomando atualmente 
| id_medicamento  | inteiro | sim | o id do remédio cadastrado
| id_categoria  | inteiro | sim | o id da categoria cadastrada
| Inicio | data | sim | a data de início do tratamento do paciente com o medicamento
| Fim | data | sim | a data final do tratamento do paciente com o medicamento 
| Horarios | hora | não | os horários que o paciente deve tomar o medicamento
| Preco | double | não | o preço do medicamento
  
  *Exemplo de corpo de requisição*

js 
{
    nome: 'Resfenol',
    dosagem Mg: 5.00,
    id_medicamento: 1;
    id_categoria: 1;
    inicio: '15/01/2023',
    fim: '19/01/2023',
    horarios: null,
    preco: 15.00
}


*Respostas*

| código | descrição
|-|-
|201| remédio cadastrado com sucesso
|400| a validação dos campos falhou

---

### Detalhar Remédio

`GET` /Remedy/api/remedio/{1}

*Respostas*

| código | descrição
|-|-
|200| os dados do remédio foram retornados no corpo da resposta
|404| não existe remédio com o id informado

*Exemplo de corpo da resposta*
js 
{
    nome: "Resfenol",
    dosagem: 5.00,
    categoria: {
        categoria_id: 1,
        nome: 'Remédio para gripe',
    }
    conta: {
        conta_id: 1,
        nome: 'Lucas Ribeiro',
    },
    descricao: 'Remédio para amenizar os sintomas de uma gripe'
}
