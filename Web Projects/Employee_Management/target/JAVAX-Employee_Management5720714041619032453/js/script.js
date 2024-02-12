function login(){
    const usernameField = document.getElementById("username");
    const passwordField = document.getElementById("password");

    if (usernameField.value == "") {
        alert("Username is required");
        usernameField.classList.add("error_input");
    }else if(passwordField.value == ""){
        alert("Password is required");
        passwordField.classList.add("error_input");
    }else{

        const data = {
            username: usernameField.value,
            password: passwordField.value
        };

        const jsonData = JSON.stringify(data);

        let request = new XMLHttpRequest();
        request.open('POST', "login", true);
        request.onreadystatechange = function (){
            if(request.readyState == 4){
                alert("ela");
            }
        }
        request.setRequestHeader('Content-type', 'application/json');
        request.send(`user=${jsonData}`);
    }
}