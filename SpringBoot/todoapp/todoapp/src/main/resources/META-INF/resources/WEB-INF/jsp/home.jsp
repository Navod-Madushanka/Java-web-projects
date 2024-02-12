<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Todo App - Home</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<!-- Navigation Bar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="#">Todo App</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Tasks</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Content Section -->
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">

            <!-- Task Creation Card -->
            <div class="card mb-3">
                <div class="card-body">
                    <h2 class="card-title text-center">New Task</h2>
                    <div class="mb-3">
                        <label for="taskTitle" class="form-label">Task Title</label>
                        <input type="text" class="form-control" id="taskTitle" placeholder="Enter task title">
                    </div>
                    <div class="mb-3">
                        <label for="taskDescription" class="form-label">Task Description</label>
                        <textarea class="form-control" id="taskDescription" rows="3"
                                  placeholder="Enter task description"></textarea>
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">Create Task</button>
                    </div>
                </div>
            </div>

            <!-- Task Display Section -->
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title text-center">Tasks</h2>
                    <!-- TODO: Display tasks here -->
                </div>
            </div>

        </div>
    </div>
</div>

<!-- Bootstrap JS (Optional for some components) -->
<script>
    async function addTodo(){
        const title = document.getElementById("taskTitle").value;
        const todo = document.getElementById("taskDescription").value;

        try{
            const response = await fetch("home", {
                method:"POST",
                headers:{
                    "Content-Type":"application/json"
                },
                body:JSON.stringify({
                    title:title,
                    todo:todo
                })
            });
            if(response.ok){
                console.error("Success");
            }else{
                console.error("Failed to register: ", response.status, response.statusText);
            }
        }catch (error){
            console.error("Error: ", error);
        }
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
