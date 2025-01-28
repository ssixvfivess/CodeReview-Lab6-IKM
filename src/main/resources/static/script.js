let aircrafts = []; //  Массив для хранения данных

const tableBody = document.querySelector('#aircraftTable tbody');
const editModal = document.getElementById('editModal');
const addModal = document.getElementById('addModal');
const addAircraftBtn = document.getElementById('addAircraftBtn');
const editForm = document.getElementById('editForm');
const addForm = document.getElementById('addForm');
const modalCloses = document.querySelectorAll('.close');
function fetchData() {
    fetch('/api/aircrafts')
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            // Обработайте данные и отобразите в таблице
            aircrafts = data;
            renderTable();

        })
        .catch(error => {
            console.error('Fetch error:', error);
        });
}
function addAircraft(newAircraft) {
    fetch('/api/aircrafts', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newAircraft),
    })
        .then(response => {
            if(!response.ok){
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            aircrafts.push(data);
            renderTable();
        })
        .catch(error => console.error('Fetch error:', error));
}
function updateAircraft(updatedAircraft, index){
    fetch(`/api/aircrafts/${updatedAircraft.aircraftCode}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedAircraft),
    })
        .then(response => {
            if(!response.ok){
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json()
        })
        .then(data => {
            aircrafts[index] = data;
            renderTable();
        })
        .catch(error => console.error('Fetch error:', error));
}
function deleteAircraft(index){
    fetch(`/api/aircrafts/${aircrafts[index].aircraftCode}`, {
        method: 'DELETE',
    })
        .then(response => {
            if(!response.ok){
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            aircrafts.splice(index, 1);
            renderTable();
        })
        .catch(error => console.error('Fetch error:', error));
}

function renderTable() {
    tableBody.innerHTML = '';
    aircrafts.forEach((aircraft, index) => {
        const row = tableBody.insertRow();
        const aircraftCodeCell = row.insertCell();
        const modelCell = row.insertCell();
        const capacityCell = row.insertCell();
        const actionsCell = row.insertCell();

        aircraftCodeCell.textContent = aircraft.aircraftCode;
        modelCell.textContent = aircraft.model;
        capacityCell.textContent = aircraft.capacity;

        const editButton = document.createElement('button');
        editButton.textContent = 'Edit';
        editButton.classList.add('edit-btn');
        editButton.onclick = () => openEditModal(index);
        actionsCell.appendChild(editButton);

        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Delete';
        deleteButton.classList.add('delete-btn');
        deleteButton.onclick = () => deleteAircraft(index);
        actionsCell.appendChild(deleteButton);
    });
}

// Function to open the edit modal
function openEditModal(index){
    const editAircraftCodeInput = document.getElementById('editAircraftCode');
    const editModelInput = document.getElementById('editModel');
    const editCapacityInput = document.getElementById('editCapacity');
    const editIndexInput = document.getElementById('editIndex');

    editAircraftCodeInput.value = aircrafts[index].aircraftCode;
    editModelInput.value = aircrafts[index].model;
    editCapacityInput.value = aircrafts[index].capacity;
    editIndexInput.value = index;

    editModal.style.display = 'block';
}

// Function to handle edit form submit
editForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const editAircraftCodeInput = document.getElementById('editAircraftCode');
    const editModelInput = document.getElementById('editModel');
    const editCapacityInput = document.getElementById('editCapacity');
    const editIndexInput = document.getElementById('editIndex');

    const index = parseInt(editIndexInput.value);

    const updatedAircraft = {
        aircraftCode: editAircraftCodeInput.value,
        model: editModelInput.value,
        capacity: parseInt(editCapacityInput.value),
    }
    updateAircraft(updatedAircraft, index);
    editModal.style.display = 'none';
})

// Function to handle add button click
addAircraftBtn.addEventListener('click',() => {
    addModal.style.display = 'block';
})
// Function to handle add form submit
addForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const addAircraftCodeInput = document.getElementById('addAircraftCode');
    const addModelInput = document.getElementById('addModel');
    const addCapacityInput = document.getElementById('addCapacity');

    const newAircraft = {
        aircraftCode: addAircraftCodeInput.value,
        model: addModelInput.value,
        capacity: parseInt(addCapacityInput.value)
    }
    addAircraft(newAircraft);
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