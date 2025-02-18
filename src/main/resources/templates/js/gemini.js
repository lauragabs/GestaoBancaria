const { GoogleGenerativeAI } = require("@google/generative-ai");


const apiUrl = 'http://localhost:8080/clientes/relatorio';
let data_db;
async function getData() {
  try {
    const response = await fetch(apiUrl, {
      method: 'GET', 
      headers: {
        'Content-Type': 'application/json',
      
      },
    });

    if (!response.ok) {
      throw new Error(`Erro na requisição: ${response.status}`);
    }

    const data = await response.json();

    const genAI = new GoogleGenerativeAI("AIzaSyCdyVVm6KA_y-DqTpbU0midfsw9t45iOmg");
    const model = genAI.getGenerativeModel({ model: "gemini-1.5-flash" });

    const prompt = `Você é especialista em Analise de dados financeiros. Sua tarefa é me trazer insights sobre os dados abaixo de forma clara e eficiente.${ JSON.stringify(data)}`;

    const result = await model.generateContent(prompt);
    console.log(result)
    return result.response.text()
  } catch (error) {
    console.error('Erro:', error);
  }
}

getData()
