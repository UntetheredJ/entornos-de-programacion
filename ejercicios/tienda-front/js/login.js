function validarLogin(){
    var nombreUsuario = document.getElementById("icon_user").value;
    var password = document.getElementById("icon_pass").value;

    console.log(nombreUsuario);
    console.log(password);
    
    let data = {'nombreUsuario': nombreUsuario, 'password': password};
    console.log(data);

    let request = sendRequest('loginclient', 'POST', data);

    request.onload = function(){
        let data1 = request.response;
        console.log(data1);

        if(data1 == 1){
            alert("Login correcto");
            window.location = 'menu.html';
        } else {
            alert("Alerta: usuario o password incorrectos.");
        }
    }

    request.onerror = function(){
        console.log("Error al recuperar los datos");
    }
}