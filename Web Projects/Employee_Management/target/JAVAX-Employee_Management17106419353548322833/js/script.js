function login(){
    const usernameField = document.getElementById("username");
    const passwordField = document.getElementById("password");

    if (usernameField.value == "" || passwordField.value == "") {
        alert("Username and password are required");

    }
}