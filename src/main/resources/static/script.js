   let aircrafts = [
        { aircraft_code: "777", model: "Boeing 777", capacity: 300 },
        { aircraft_code: "320", model: "Airbus A320", capacity: 180 },
        { aircraft_code: "737", model: "Boeing 737", capacity: 150 }
    ];

        const tableBody = document.querySelector('#aircraftTable tbody');
        const editModal = document.getElementById('editModal');
        const addModal = document.getElementById('addModal');
        const addAircraftBtn = document.getElementById('addAircraftBtn');
        const editForm = document.getElementById('editForm');
        const addForm = document.getElementById('addForm');

        const modalCloses = document.querySelectorAll('.close');

        function renderTable() {
           tableBody.innerHTML = '';
            aircrafts.forEach((aircraft, index) => {
                const row = tableBody.insertRow();
                const aircraftCodeCell = row.insertCell();
                const modelCell = row.insertCell();
                const capacityCell = row.insertCell();
                const actionsCell = row.insertCell();

                aircraftCodeCell.textContent = aircraft.aircraft_code;
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

        function openEditModal(index){
            const editAircraftCodeInput = document.getElementById('editAircraftCode');
            const editModelInput = document.getElementById('editModel');
             const editCapacityInput = document.getElementById('editCapacity');
            const editIndexInput = document.getElementById('editIndex');

            editAircraftCodeInput.value = aircrafts[index].aircraft_code;
            editModelInput.value = aircrafts[index].model;
            editCapacityInput.value = aircrafts[index].capacity;
            editIndexInput.value = index;

            editModal.style.display = 'block';
        }

        editForm.addEventListener('submit', (e) => {
           e.preventDefault();
            const editAircraftCodeInput = document.getElementById('editAircraftCode');
            const editModelInput = document.getElementById('editModel');
             const editCapacityInput = document.getElementById('editCapacity');
           const editIndexInput = document.getElementById('editIndex');

           const index = parseInt(editIndexInput.value);

             aircrafts[index].aircraft_code = editAircraftCodeInput.value;
            aircrafts[index].model = editModelInput.value;
            aircrafts[index].capacity = parseInt(editCapacityInput.value);

            editModal.style.display = 'none';
           renderTable();
        })

        addAircraftBtn.addEventListener('click',() => {
            addModal.style.display = 'block';
        })

        addForm.addEventListener('submit', (e) => {
             e.preventDefault();
           const addAircraftCodeInput = document.getElementById('addAircraftCode');
           const addModelInput = document.getElementById('addModel');
           const addCapacityInput = document.getElementById('addCapacity');

             aircrafts.push({
               aircraft_code: addAircraftCodeInput.value,
               model: addModelInput.value,
               capacity: parseInt(addCapacityInput.value)
           });

            addModal.style.display = 'none';
          renderTable();
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

        function deleteAircraft(index) {
           aircrafts.splice(index, 1);
          renderTable();
        }

         renderTable();