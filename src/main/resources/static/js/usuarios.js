// Call the dataTables jQuery plugin
$(document).ready(function () {

  console.log("Usuarios.....");
  cargarUsuarios();
  actualizarMailUser();
  $('#usuarios').DataTable();
});

function actualizarMailUser() {
  document.getElementById('userLogin').textContent = localStorage.email;
}

async function cargarUsuarios() {
  const request = await fetch('http://localhost:8080/users', {
    method: 'GET',
    headers: getHedears()
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

async function eliminarUsuario(id) {
  const request = await fetch('http://localhost:8080/user/' + id, {
    method: 'DELETE',
    headers: getHedears()
  });
  cargarUsuarios();
}

function getHedears() {
  return {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': localStorage.token
  };
}