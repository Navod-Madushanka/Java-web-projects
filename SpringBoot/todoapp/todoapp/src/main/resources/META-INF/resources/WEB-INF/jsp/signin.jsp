<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Todo App - Sign In</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title text-center">Sign In</h2>
                        <div class="mb-3">
                            <label for="username" class="form-label">Username</label>
                            <input id="username" type="text" class="form-control" id="username" placeholder="Enter your username">
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email address</label>
                            <input id="email" type="email" class="form-control" id="email" placeholder="Enter your email">
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input id="password" type="password" class="form-control" id="password" placeholder="Enter your password">
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary" onclick="userRegister();">Sign In</button>
                            <button class="btn btn-secondary" onclick="goToLogin();">Go to Login</button>
                        </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    async function userRegister() {
        const username = document.getElementById("username").value;
        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;

        try {
            const response = await fetch("/register", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    username: username,
                    email: email,
                    password: password
                })
            });

            if (response.ok) {
                goToLogin();
            } else {
                console.error("Failed to register: ", response.status, response.statusText);
            }
        } catch (error) {
            console.error("Error", error.message);
        }
    }
    function goToLogin(){
        window.location.href = "/login";
    }
</script>
<!-- Bootstrap JS and Popper.js (optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
