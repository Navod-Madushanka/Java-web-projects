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

        fetch("/login",{
            method:"POST",
            headers:{
                "Content-Type": "application/json"
            },
            body:jsonData
        })
            .then(function (response){
                if(response.ok){
                    return response.json();
                }else{
                    throw new Error("Something went wrong");
                }
            })
            .then(function (data){
                console.log(data);
            })
            .catch(function (error){
                console.error(error);
            });
    }
}