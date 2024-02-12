function login(){
    const usernameField = document.getElementById("username");
    const passwordField = document.getElementById("password");

    if (usernameField.value == "") {
        alert("Username is required");
        usernameField.classList.add("error_input");
    }
}