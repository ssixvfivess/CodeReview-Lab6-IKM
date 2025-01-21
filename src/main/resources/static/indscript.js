 let flights = [
        { flight_number: "SU100", departure_airoport_id: 1, arrival_airoport_id: 2, departure_time: "10:00", arrival_time: "12:00" },
        { flight_number: "LH200", departure_airoport_id: 3, arrival_airoport_id: 4, departure_time: "14:00", arrival_time: "16:00" },
        { flight_number: "AF300", departure_airoport_id: 1, arrival_airoport_id: 3, departure_time: "16:00", arrival_time: "18:00" }
    ];

        const tableBody = document.querySelector('#flightTable tbody');
        const editModal = document.getElementById('editModal');
        const addModal = document.getElementById('addModal');
        const addFlightBtn = document.getElementById('addFlightBtn');
        const editForm = document.getElementById('editForm');
        const addForm = document.getElementById('addForm');
        const modalCloses = document.querySelectorAll('.close');

        function renderTable() {
          tableBody.innerHTML = ''; // Clear the table body
            flights.forEach((flight, index) => {
                const row = tableBody.insertRow();
                const flightNumberCell = row.insertCell();
                const departureAirportIdCell = row.insertCell();
                const arrivalAirportIdCell = row.insertCell();
                const departureTimeCell = row.insertCell();
                 const arrivalTimeCell = row.insertCell();
                const actionsCell = row.insertCell();

                 flightNumberCell.textContent = flight.flight_number;
                departureAirportIdCell.textContent = flight.departure_airoport_id;
                 arrivalAirportIdCell.textContent = flight.arrival_airoport_id;
                departureTimeCell.textContent = flight.departure_time;
               arrivalTimeCell.textContent = flight.arrival_time;

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

            editFlightNumberInput.value = flights[index].flight_number;
            editDepartureAirportIdInput.value = flights[index].departure_airoport_id;
             editArrivalAirportIdInput.value = flights[index].arrival_airoport_id;
             editDepartureTimeInput.value = flights[index].departure_time;
             editArrivalTimeInput.value = flights[index].arrival_time;
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

             flights[index].flight_number = editFlightNumberInput.value;
            flights[index].departure_airoport_id = parseInt(editDepartureAirportIdInput.value);
            flights[index].arrival_airoport_id = parseInt(editArrivalAirportIdInput.value);
            flights[index].departure_time = editDepartureTimeInput.value;
           flights[index].arrival_time = editArrivalTimeInput.value;


             editModal.style.display = 'none';
          renderTable();
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

            flights.push({
                flight_number: addFlightNumberInput.value,
               departure_airoport_id: parseInt(addDepartureAirportIdInput.value),
                arrival_airoport_id: parseInt(addArrivalAirportIdInput.value),
                 departure_time: addDepartureTimeInput.value,
               arrival_time: addArrivalTimeInput.value,
             });

             addModal.style.display = 'none';
            renderTable();
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

      function deleteFlight(index) {
          flights.splice(index, 1);
          renderTable();
      }
     renderTable();