let month = 8; // setembro
let year = 2025;
let selectedDay = null;
let selectedTime = "20:00 PM";

const daysEl = document.getElementById("days");

function generateCalendar(){
    document.getElementById("monthYear").innerText =
      new Date(year, month).toLocaleDateString("pt-BR",{month:"long",year:"numeric"});

    daysEl.innerHTML = "";

    const lastDay = new Date(year, month + 1, 0).getDate();

    for(let i=1;i<=lastDay;i++){
        let d = document.createElement("div");
        d.innerText = i;
        d.className = "day";

        d.onclick = () => {
            document.querySelectorAll(".day")
            .forEach(x=>x.classList.remove("selected"));

            d.classList.add("selected");
            selectedDay = i;
        };

        daysEl.appendChild(d);
    }
}

generateCalendar();

function changeMonth(val){
    month += val;

    if(month > 11){ month=0; year++; }
    if(month < 0){ month=11; year--; }

    generateCalendar();
}

function setAMPM(type){
    document.getElementById("am").classList.remove("active");
    document.getElementById("pm").classList.remove("active");
    document.getElementById(type.toLowerCase()).classList.add("active");
}

function confirmTime(){
    const h = document.getElementById("hour").value;
    const m = document.getElementById("minute").value.padStart(2, "0");

    const tipo = document.querySelector(".active").innerText;
    selectedTime = `${h}:${m} ${tipo}`;
}

function schedule(medico){

    if(!selectedDay){
        alert("Selecione um dia primeiro!");
        return;
    }

    alert(
        `Consulta marcada!
Dia: ${selectedDay}
Hora: ${selectedTime}
Médico: ${medico}`
    );
}
