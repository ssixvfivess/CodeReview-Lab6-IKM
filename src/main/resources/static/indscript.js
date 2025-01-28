let flights = [];

const tableBody = document.querySelector('#flightTable tbody');
const editModal = document.getElementById('editModal');
const addModal = document.getElementById('addModal');
const addFlightBtn = document.getElementById('addFlightBtn');
const editForm = document.getElementById('editForm');
const addForm = document.getElementById('addForm');
const modalCloses = document.querySelectorAll('.close');

function fetchData() {
    fetch('/api/flights')
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            // Обработайте данные и отобразите в таблице
            flights = data;
            renderTable();

        })
        .catch(error => {
            console.error('Fetch error:', error);
        });
}
function addFlight(newFlight) {
    fetch('/api/flights', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newFlight),
    })
        .then(response => {
            if(!response.ok){
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            flights.push(data);
            renderTable();
        })
        .catch(error => console.error('Fetch error:', error));
}
function updateFlight(updatedFlight, index){
    fetch(`/api/flights/${updatedFlight.flightNumber}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedFlight),
    })
        .then(response => {
            if(!response.ok){
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json()
        })
        .then(data => {
            flights[index] = data;
            renderTable();
        })
        .catch(error => console.error('Fetch error:', error));
}
function deleteFlight(index){
    fetch(`/api/flights/${flights[index].flightNumber}`, {
        method: 'DELETE',
    })
        .then(response => {
            if(!response.ok){
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            flights.splice(index, 1);
            renderTable();
        })
        .catch(error => console.error('Fetch error:', error));
}

function renderTable() {
    tableBody.innerHTML = '';
    flights.forEach((flight, index) => {
        const row = tableBody.insertRow();
        const flightNumberCell = row.insertCell();
        const departureAirportIdCell = row.insertCell();
        const arrivalAirportIdCell = row.insertCell();
        const departureTimeCell = row.insertCell();
        const arrivalTimeCell = row.insertCell();
        const actionsCell = row.insertCell();

        flightNumberCell.textContent = flight.flightNumber;
        departureAirportIdCell.textContent = flight.departureAirport.airportCode;
        arrivalAirportIdCell.textContent = flight.arrivalAirport.airportCode;
        departureTimeCell.textContent = flight.departureTime;
        arrivalTimeCell.textContent = flight.arrivalTime;

        const editButton = document.createElement('button');
        editButton.textContent = 'Edit';
        editButton.classList.add('edit-btn');
        editButton.onclick = () => openEditModal(index);
        actionsCell.appendChild(editButton);

        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Delete';
        deleteButton.classList.add('delete-btn');
        deleteButton.onclick = () => deleteFlight(index);
        actionsCell.appendChild(deleteButton);
    });
}
function openEditModal(index) {
    const editFlightNumberInput = document.getElementById('editFlightNumber');
    const editDepartureAirportIdInput = document.getElementById('editDepartureAirportId');
    const editArrivalAirportIdInput = document.getElementById('editArrivalAirportId');
    const editDepartureTimeInput = document.getElementById('editDepartureTime');
    const editArrivalTimeInput = document.getElementById('editArrivalTime');
    const editIndexInput = document.getElementById('editIndex');

    editFlightNumberInput.value = flights[index].flightNumber;
    editDepartureAirportIdInput.value = flights[index].departureAirport.airportCode;
    editArrivalAirportIdInput.value = flights[index].arrivalAirport.airportCode;
    editDepartureTimeInput.value = flights[index].departureTime;
    editArrivalTimeInput.value = flights[index].arrivalTime;
    editIndexInput.value = index;

    editModal.style.display = 'block';
}

editForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const editFlightNumberInput = document.getElementById('editFlightNumber');
    const editDepartureAirportIdInput = document.getElementById('editDepartureAirportId');
    const editArrivalAirportIdInput = document.getElementById('editArrivalAirportId');
    const editDepartureTimeInput = document.getElementById('editDepartureTime');
    const editArrivalTimeInput = document.getElementById('editArrivalTime');
    const editIndexInput = document.getElementById('editIndex');

    const index = parseInt(editIndexInput.value);

    const updatedFlight = {
        flightNumber: editFlightNumberInput.value,
        departureAirport: {airportCode: editDepartureAirportIdInput.value},
        arrivalAirport: {airportCode: editArrivalAirportIdInput.value},
        departureTime: editDepartureTimeInput.value,
        arrivalTime: editArrivalTimeInput.value,
    }

    updateFlight(updatedFlight, index);
    editModal.style.display = 'none';
})

addFlightBtn.addEventListener('click', () => {
    addModal.style.display = 'block';
});

addForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const addFlightNumberInput = document.getElementById('addFlightNumber');
    const addDepartureAirportIdInput = document.getElementById('addDepartureAirportId');
    const addArrivalAirportIdInput = document.getElementById('addArrivalAirportId');
    const addDepartureTimeInput = document.getElementById('addDepartureTime');
    const addArrivalTimeInput = document.getElementById('addArrivalTime');
    const newFlight = {
        flightNumber: addFlightNumberInput.value,
        departureAirport: {airportCode: addDepartureAirportIdInput.value},
        arrivalAirport: {airportCode: addArrivalAirportIdInput.value},
        departureTime: addDepartureTimeInput.value,
        arrivalTime: addArrivalTimeInput.value
    }
    addFlight(newFlight);
    addModal.style.display = 'none';
});

modalCloses.forEach(closeButton => {
    closeButton.addEventListener('click', () => {
        editModal.style.display = 'none';
        addModal.style.display = 'none';
    });
});

window.addEventListener('click', (event) => {
    if(event.target === editModal || event.target === addModal){
        editModal.style.display = 'none';
        addModal.style.display = 'none';
    }
});
fetchData();