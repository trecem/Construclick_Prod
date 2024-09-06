//Recepción de los datos del usuario en el formulario
const formServices = document.getElementById('RegistroPrestador');

//detonación del evento
formServices.addEventListener('submit', (event) => {
  
    event.preventDefault();
 

const nombre = document.getElementById("userName").value;
const contrasena = document.getElementById("contrasena").value;
const correo = document.getElementById("userEmail").value;
const telefono = document.getElementById("userPhone").value;

// Conexión con el backend
const user = {
    'username': nombre,
    'password': contrasena,
    'email': correo,
    'telephone': telefono
};

const URL = ⁠ http://3.144.151.137:8080/registro/r1 ⁠;

fetch(URL, {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(user)
})
.then(response => response.json())
.then(data => console.log('Guardado', data))
.catch(error => console.error('Error:', error));
}) 
formServices.reset