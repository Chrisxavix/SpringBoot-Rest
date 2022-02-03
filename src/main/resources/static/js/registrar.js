// Call the dataTables jQuery plugin
$(document).ready(function () {

    console.log("Usuarios.....");
    $('#registrar');
  });

function getId() {
    let nombre = document.getElementById('txtNombre').value;
    console.log(nombre, '??????');
}

async function registrarUsuario() {
    let datos = {};
    datos.nombre = "";
    const request = await fetch('http://localhost:8080/user', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });


    const usuarios = await request.json();

    console.log(usuarios, "usuariosResponse");

    let listadoHtml = '';

    usuarios.forEach(element => {
        let usuarioHtml = `<tr>
        <td>${element.id}</td>
        <td>${element.nombre}</td>
        <td>${element.email}</td>
        <td>${element.telefono}</td>
        <td>
            <a href="#" onclick="eliminarUsuario(${element.id})" class="btn btn-danger btn-circle">
                <i class="fas fa-trash"></i>
            </a>
        </td>
    </tr>`;
        //listadoHtml+= usuarioHtml;
        listadoHtml = listadoHtml + usuarioHtml;
    });
    console.log(listadoHtml, 'listadoHtml');
    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
}

