let scheduledFlights = [];

const tableBody = document.querySelector('#scheduledFlightTable tbody');
const editModal = document.getElementById('editModal');
const addModal = document.getElementById('addModal');
const addScheduledFlightBtn = document.getElementById('addScheduledFlightBtn');
const editForm = document.getElementById('editForm');
const addForm = document.getElementById('addForm');
const modalCloses = document.querySelectorAll('.close');


function fetchData() {
    fetch('/api/schedules')
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            // Обработайте данные и отобразите в таблице
            scheduledFlights = data;
            renderTable();

        })
        .catch(error => {
            console.error('Fetch error:', error);
        });
}
function addScheduledFlight(newScheduledFlight) {
    fetch('/api/schedules', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newScheduledFlight),
    })
        .then(response => {
            if(!response.ok){
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            scheduledFlights.push(data);
            renderTable();
        })
        .catch(error => console.error('Fetch error:', error));
}
function updateScheduledFlight(updatedScheduledFlight, index){
    fetch(`/api/schedules/${updatedScheduledFlight.flightId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedScheduledFlight),
    })
        .then(response => {
            if(!response.ok){
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json()
        })
        .then(data => {
            scheduledFlights[index] = data;
            renderTable();
        })
        .catch(error => console.error('Fetch error:', error));
}
function deleteScheduledFlight(index) {
    fetch(`/api/schedules/${scheduledFlights[index].flightId}`, {
        method: 'DELETE',
    })
        .then(response => {
            if(!response.ok){
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            scheduledFlights.splice(index, 1);
            renderTable();
        })
        .catch(error => console.error('Fetch error:', error));
}
function renderTable() {
    tableBody.innerHTML = '';
    scheduledFlights.forEach((flight, index) => {
        const row = tableBody.insertRow();
        const flightIdCell = row.insertCell();
        const aircraftIdCell = row.insertCell();
        const scheduledDateCell = row.insertCell();
        const actionsCell = row.insertCell();

        flightIdCell.textContent = flight.flightId;
        aircraftIdCell.textContent = flight.aircraft.aircraftCode;
        scheduledDateCell.textContent = flight.scheduledDate;

        const editButton = document.createElement('button');
        editButton.textContent = 'Edit';
        editButton.classList.add('edit-btn');
        editButton.onclick = () => openEditModal(index);
        actionsCell.appendChild(editButton);

        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Delete';
        deleteButton.classList.add('delete-btn');
        deleteButton.onclick = () => deleteScheduledFlight(index);
        actionsCell.appendChild(deleteButton);
    });
}

function openEditModal(index){
    const editFlightIdInput = document.getElementById('editFlightId');
    const editAircraftIdInput = document.getElementById('editAircraftId');
    const editScheduledDateInput = document.getElementById('editScheduledDate');
    const editIndexInput = document.getElementById('editIndex');

    editFlightIdInput.value = scheduledFlights[index].flightId;
    editAircraftIdInput.value = scheduledFlights[index].aircraft.aircraftCode;
    editScheduledDateInput.value = scheduledFlights[index].scheduledDate;
    editIndexInput.value = index;

    editModal.style.display = 'block';
}
editForm.addEventListener('submit', (e) => {
    e.preventDefault();

    const editFlightIdInput = document.getElementById('editFlightId');
    const editAircraftIdInput = document.getElementById('editAircraftId');
    const editScheduledDateInput = document.getElementById('editScheduledDate');
    const editIndexInput = document.getElementById('editIndex');

    const index = parseInt(editIndexInput.value);
    const updatedScheduledFlight = {
        flightId: parseInt(editFlightIdInput.value),
        aircraft: {aircraftCode: editAircraftIdInput.value},
        scheduledDate: editScheduledDateInput.value
    }
    updateScheduledFlight(updatedScheduledFlight, index);
    editModal.style.display = 'none';
})

addScheduledFlightBtn.addEventListener('click',() => {
    addModal.style.display = 'block';
})

addForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const addFlightIdInput = document.getElementById('addFlightId');
    const addAircraftIdInput = document.getElementById('addAircraftId');
    const addScheduledDateInput = document.getElementById('addScheduledDate');

    const newScheduledFlight = {
        flightId: parseInt(addFlightIdInput.value),
        aircraft: {aircraftCode: addAircraftIdInput.value},
        scheduledDate: addScheduledDateInput.value
    }
    addScheduledFlight(newScheduledFlight);
    addModal.style.display = 'none';
})
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
})
fetchData();