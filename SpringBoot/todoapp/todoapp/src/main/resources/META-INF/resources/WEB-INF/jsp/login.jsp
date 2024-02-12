<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Todo App - Login</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title text-center">Log In</h2>
                        <div class="mb-3">
                            <label for="username" class="form-label">Username</label>
                            <input id="username" name="username" type="text" class="form-control" id="username" placeholder="Enter your username">
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input id="password" name="password" type="password" class="form-control" id="password" placeholder="Enter your password">
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary" onclick="logIn();">Log In</button>
                            <button class="btn btn-secondary" onclick="goToSignIn();">Go to Sign in</button>
                        </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS and Popper.js (optional) -->
<script>
    async function logIn(){
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        try{
            const response = await fetch("login",{
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    username:username,
                    password:password
                })
            });
            if (response.status === 200) {
                goToHome();
            } else if (response.status === 401) {
                console.error("Invalid credentials");
            } else {
                console.error("Failed to Login: ", response.status, response.statusText);
            }
        }catch (error){
            console.error("Error", error.message);
        }
    }
    function goToHome(){
        window.location.href = "/home";
    }
    function goToSignIn(){
        window.location.href = "/register";
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
