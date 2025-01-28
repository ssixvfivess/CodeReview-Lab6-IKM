let airports = [];

const tableBody = document.querySelector('#airportTable tbody');
const editModal = document.getElementById('editModal');
const addModal = document.getElementById('addModal');
const addAirportBtn = document.getElementById('addAirportBtn');
const editForm = document.getElementById('editForm');
const addForm = document.getElementById('addForm');
const modalCloses = document.querySelectorAll('.close');

function fetchData() {
    fetch('/api/airports')
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            // Обработайте данные и отобразите в таблице
            airports = data;
            renderTable();

        })
        .catch(error => {
            console.error('Fetch error:', error);
        });
}
function addAirport(newAirport) {
    fetch('/api/airports', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newAirport),
    })
        .then(response => {
            if(!response.ok){
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            airports.push(data);
            renderTable();
        })
        .catch(error => console.error('Fetch error:', error));
}
function updateAirport(updatedAirport, index){
    fetch(`/api/airports/${updatedAirport.airportCode}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedAirport),
    })
        .then(response => {
            if(!response.ok){
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json()
        })
        .then(data => {
            airports[index] = data;
            renderTable();
        })
        .catch(error => console.error('Fetch error:', error));
}
function deleteAirport(index){
    fetch(`/api/airports/${airports[index].airportCode}`, {
        method: 'DELETE',
    })
        .then(response => {
            if(!response.ok){
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            airports.splice(index, 1);
            renderTable();
        })
        .catch(error => console.error('Fetch error:', error));
}

function renderTable() {
    tableBody.innerHTML = '';
    airports.forEach((airport, index) => {
        const row = tableBody.insertRow();
        const airportCodeCell = row.insertCell();
        const airportNameCell = row.insertCell();
        const cityCell = row.insertCell();
        const countryCell = row.insertCell();
        const actionsCell = row.insertCell();

        airportCodeCell.textContent = airport.airportCode;
        airportNameCell.textContent = airport.airportName;
        cityCell.textContent = airport.city;
        countryCell.textContent = airport.country;

        const editButton = document.createElement('button');
        editButton.textContent = 'Edit';
        editButton.classList.add('edit-btn');
        editButton.onclick = () => openEditModal(index);
        actionsCell.appendChild(editButton);

        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Delete';
        deleteButton.classList.add('delete-btn');
        deleteButton.onclick = () => deleteAirport(index);
        actionsCell.appendChild(deleteButton);

    });
}

function openEditModal(index){
    const editAirportCodeInput = document.getElementById('editAirportCode');
    const editAirportNameInput = document.getElementById('editAirportName');
    const editCityInput = document.getElementById('editCity');
    const editCountryInput = document.getElementById('editCountry');
    const editIndexInput = document.getElementById('editIndex');

    editAirportCodeInput.value = airports[index].airportCode;
    editAirportNameInput.value = airports[index].airportName;
    editCityInput.value = airports[index].city;
    editCountryInput.value = airports[index].country;
    editIndexInput.value = index;

    editModal.style.display = 'block';
}

editForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const editAirportCodeInput = document.getElementById('editAirportCode');
    const editAirportNameInput = document.getElementById('editAirportName');
    const editCityInput = document.getElementById('editCity');
    const editCountryInput = document.getElementById('editCountry');
    const editIndexInput = document.getElementById('editIndex');

    const index = parseInt(editIndexInput.value);

    const updatedAirport = {
        airportCode: editAirportCodeInput.value,
        airportName: editAirportNameInput.value,
        city: editCityInput.value,
        country: editCountryInput.value
    }

    updateAirport(updatedAirport, index);
    editModal.style.display = 'none';
})

addAirportBtn.addEventListener('click', () =>{
    addModal.style.display = 'block';
})

addForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const addAirportCodeInput = document.getElementById('addAirportCode');
    const addAirportNameInput = document.getElementById('addAirportName');
    const addCityInput = document.getElementById('addCity');
    const addCountryInput = document.getElementById('addCountry');

    const newAirport = {
        airportCode: addAirportCodeInput.value,
        airportName: addAirportNameInput.value,
        city: addCityInput.value,
        country: addCountryInput.value
    }
    addAirport(newAirport);
    addModal.style.display = 'none';
})

modalCloses.forEach(closeButton => {
    closeButton.addEventListener('click', () => {
        editModal.style.display = 'none';
        addModal.style.display = 'none';
    });
})

window.addEventListener('click', (event) => {
    if(event.target === editModal || event.target === addModal){
        editModal.style.display = 'none';
        addModal.style.display = 'none';
    }
})

fetchData();