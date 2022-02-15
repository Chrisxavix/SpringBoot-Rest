// Call the dataTables jQuery plugin
$(document).ready(function () {
  // ON READY
});

async function iniciarSesion() {
  let datos = {};
  datos.email = document.getElementById('txtEmail').value;
  datos.password = document.getElementById('txtPassword').value;

  console.log(datos, '?????');
  const request = await fetch('http://localhost:8080/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  const respuesta = await request.text();
  if (respuesta != "error") {
    localStorage.token = respuesta;
    localStorage.email = datos.email;

    console.log(localStorage, 'localStorage');
    window.location.href = 'usuarios.html'
  } else {
    alert("Las credenciales son incorrectas. Por favor intente nuevamente.");
  }

}