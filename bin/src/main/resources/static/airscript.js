  let airports = [
        { airoport_code: "JFK", airoport_name: "John F. Kennedy International Airport", city: "New York", country: "USA" },
        { airoport_code: "LHR", airoport_name: "Heathrow Airport", city: "London", country: "UK" },
         { airoport_code: "CDG", airoport_name: "Charles de Gaulle Airport", city: "Paris", country: "France" }
    ];


       const tableBody = document.querySelector('#airportTable tbody');
        const editModal = document.getElementById('editModal');
        const addModal = document.getElementById('addModal');
        const addAirportBtn = document.getElementById('addAirportBtn');
        const editForm = document.getElementById('editForm');
       const addForm = document.getElementById('addForm');
       const modalCloses = document.querySelectorAll('.close');

       function renderTable() {
           tableBody.innerHTML = '';
            airports.forEach((airport, index) => {
                const row = tableBody.insertRow();
                const airportCodeCell = row.insertCell();
                const airportNameCell = row.insertCell();
                const cityCell = row.insertCell();
               const countryCell = row.insertCell();
               const actionsCell = row.insertCell();

               airportCodeCell.textContent = airport.airoport_code;
               airportNameCell.textContent = airport.airoport_name;
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

            editAirportCodeInput.value = airports[index].airoport_code;
            editAirportNameInput.value = airports[index].airoport_name;
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

            airports[index].airoport_code =  editAirportCodeInput.value;
            airports[index].airoport_name =  editAirportNameInput.value;
            airports[index].city = editCityInput.value;
            airports[index].country = editCountryInput.value;


             editModal.style.display = 'none';
             renderTable();
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

           airports.push({
                airoport_code: addAirportCodeInput.value,
                airoport_name: addAirportNameInput.value,
                 city: addCityInput.value,
                country: addCountryInput.value
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

        function deleteAirport(index) {
            airports.splice(index, 1);
          renderTable();
        }

        renderTable();