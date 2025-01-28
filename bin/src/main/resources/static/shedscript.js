   let scheduledFlights = [
        { flight_id: 101, aircraft_id: 777, scheduled_date: "2024-05-15" },
        { flight_id: 202, aircraft_id: 320, scheduled_date: "2024-05-16" },
        { flight_id: 303, aircraft_id: 737, scheduled_date: "2024-05-17" }
    ];

        const tableBody = document.querySelector('#scheduledFlightTable tbody');
        const editModal = document.getElementById('editModal');
        const addModal = document.getElementById('addModal');
        const addScheduledFlightBtn = document.getElementById('addScheduledFlightBtn');
       const editForm = document.getElementById('editForm');
      const addForm = document.getElementById('addForm');
       const modalCloses = document.querySelectorAll('.close');


       function renderTable() {
            tableBody.innerHTML = '';
           scheduledFlights.forEach((flight, index) => {
                const row = tableBody.insertRow();
                const flightIdCell = row.insertCell();
                 const aircraftIdCell = row.insertCell();
                const scheduledDateCell = row.insertCell();
                const actionsCell = row.insertCell();

                flightIdCell.textContent = flight.flight_id;
               aircraftIdCell.textContent = flight.aircraft_id;
                scheduledDateCell.textContent = flight.scheduled_date;

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

           editFlightIdInput.value = scheduledFlights[index].flight_id;
          editAircraftIdInput.value = scheduledFlights[index].aircraft_id;
           editScheduledDateInput.value = scheduledFlights[index].scheduled_date;
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
             scheduledFlights[index].flight_id = parseInt(editFlightIdInput.value);
           scheduledFlights[index].aircraft_id = parseInt(editAircraftIdInput.value);
             scheduledFlights[index].scheduled_date = editScheduledDateInput.value;


             editModal.style.display = 'none';
            renderTable();
         })

         addScheduledFlightBtn.addEventListener('click',() => {
            addModal.style.display = 'block';
         })

         addForm.addEventListener('submit', (e) => {
             e.preventDefault();
            const addFlightIdInput = document.getElementById('addFlightId');
            const addAircraftIdInput = document.getElementById('addAircraftId');
            const addScheduledDateInput = document.getElementById('addScheduledDate');


             scheduledFlights.push({
                flight_id: parseInt(addFlightIdInput.value),
                aircraft_id: parseInt(addAircraftIdInput.value),
                scheduled_date: addScheduledDateInput.value
            });


              addModal.style.display = 'none';
              renderTable();
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

        function deleteScheduledFlight(index) {
           scheduledFlights.splice(index, 1);
          renderTable();
        }
        renderTable();