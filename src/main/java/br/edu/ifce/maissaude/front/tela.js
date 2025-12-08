// LISTA DE CONSULTAS COMO DATAS REAIS
// Formato obrigatório: "YYYY-MM-DD"
const consultas = [
    "2025-12-03",
    "2025-12-07",
    "2025-12-12",
    "2025-12-29"
];

let dataAtual = new Date();

function carregarCalendario() {
    const ano = dataAtual.getFullYear();
    const mes = dataAtual.getMonth();

    const nomeMeses = [
        "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
        "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
    ];

    document.getElementById("mes-ano").textContent = `${nomeMeses[mes]} ${ano}`;

    const diasDiv = document.getElementById("dias");
    diasDiv.innerHTML = "";

    const primeiroDiaSemana = new Date(ano, mes, 1).getDay();
    const ultimoDiaMes = new Date(ano, mes + 1, 0).getDate();

    // Espaços antes do dia 1
    for (let i = 0; i < primeiroDiaSemana; i++) {
        diasDiv.appendChild(document.createElement("div"));
    }

    // Criar os dias
    for (let dia = 1; dia <= ultimoDiaMes; dia++) {
        const elementoDia = document.createElement("div");
        elementoDia.classList.add("dia");
        elementoDia.textContent = dia;

        // Formata data para comparar
        const dataFormatada = `${ano}-${String(mes + 1).padStart(2, '0')}-${String(dia).padStart(2, '0')}`;

        // Marca dia se estiver na lista de consultas
        if (consultas.includes(dataFormatada)) {
            elementoDia.classList.add("dia-consulta");
        }

        diasDiv.appendChild(elementoDia);
    }
}

// Botões
document.getElementById("prev").onclick = () => {
    dataAtual.setMonth(dataAtual.getMonth() - 1);
    carregarCalendario();
};

document.getElementById("next").onclick = () => {
    dataAtual.setMonth(dataAtual.getMonth() + 1);
    carregarCalendario();
};

carregarCalendario();
