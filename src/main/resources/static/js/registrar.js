// Call the dataTables jQuery plugin
$(document).ready(function () {
    // ON READY
});

async function registrarUsuario() {
    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtMail').value;
    datos.telefono = document.getElementById('txtTelefono').value;
    datos.password = document.getElementById('txtPassword').value;
    datos.repeatPassword = document.getElementById('txtRepeatPassword').value;

    if(datos.password != datos.repeatPassword) {
        console.log("Las contraseñas no coinciden");
        return;
    }

    const request = await fetch('http://localhost:8080/user', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    const content = await request.json();
    console.log(content);

}

