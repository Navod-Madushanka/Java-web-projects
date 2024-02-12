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

        fetch("login", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: jsonData
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Request failed');
                }
            })
            .then(data => {
                // Handle the response data
                alert("ela");
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }
}

function goToRegister() {
    window.location = "register";
}

function validateForm() {
    const nameField = document.getElementById("name");
    const positionField = document.getElementById("position");
    const departmentField = document.getElementById("department");
    const hireDateField = document.getElementById("hireDate");
    const salaryField = document.getElementById("salary");

    if (nameField.value === "" || positionField.value === "" || departmentField.value === "" ||
        hireDateField.value === "" || salaryField.value === "") {
        alert("All fields are required.");
        return false;
    }

    return true;
}

function submitForm() {
    if (validateForm()) {
        const name = document.getElementById("name").value;
        const position = document.getElementById("position").value;
        const department = document.getElementById("department").value;
        const hireDate = document.getElementById("hireDate").value;
        const salary = parseFloat(document.getElementById("salary").value);

        const employeeData = {
            name: name,
            position: position,
            department: department,
            hireDate: hireDate,
            salary: salary
        };

        fetch("register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(employeeData)
        })
            .then(response => response.text())
            .then(data => {
                alert(data); // Display the response from the server
            })
            .catch(error => {
                console.error("Error:", error);
            });
    }
}