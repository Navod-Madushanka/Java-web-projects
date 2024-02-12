<%--
  Created by IntelliJ IDEA.
  User: Navod Madusanka
  Date: 10/15/2023
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="layout" uri="http://callidora.lk/jsp/template-inheritance" %>
<layout:extends name="admin_base">
    <layout:put block="style">
        <link rel="stylesheet" type="text/css" href="${admin_assets}/libs/css/summernote.min.css">
    </layout:put>
    <layout:put block="contents">
        <form id="form-add-product" autocomplete="off" novalidate="novalidate">
            <div class="row">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="section-block" id="basicform">
                        <h3 class="section-title">Customize Login and Registration</h3>
                        <p></p>
                    </div>
                    <div class="card">
                        <h5 class="card-header">Title Settings</h5>
                        <div class="card-body">
                            <div class="form-group">
                                <label for="title" class="col-form-label">Set a New Title</label>
                                <input id="title" type="text" class="form-control col-sm-6">
                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="card">
                        <h5 class="card-header">Set New Image</h5>
                        <div class="card-body">
                            <div class="row">
                                <div id="image-dev"></div>
                            </div>

                            <div class="row pt-2 pt-sm-5 mt-1">
                                <div class="col-sm-12 pl-0">
                                    <p class="text-right">
                                        <button id="save-image" class="btn btn-space btn-primary">Save</button>
                                        <button class="btn btn-space btn-secondary">Cancel</button>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </layout:put>
    <layout:put block="scripts">
        <script src="${admin_assets}/libs/js/summernote.min.js"></script>
        <script src="${admin_assets}/libs/js/spartan-multi-image-picker.js"></script>
        <script>

            $('#image-dev').spartanMultiImagePicker({
                fieldName: 'file[]',
                maxCount: 5
            });
            document.getElementById('save-image').addEventListener('click', (evt) => {
                evt.preventDefault();
                let title = document.getElementById('title').value;

                fetch('${BASE_URL}admin/customize/signupandLogin', {
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    method: 'post',
                    body: JSON.stringify({
                        title: title
                    })
                }).then(response => response.json())
                    .then(data => {
                        uploadImages();
                    });
            });

            function uploadImages(id) {
                let formData = new FormData();
                let inputs = document.querySelectorAll('input[type=file]');
                inputs.forEach((input, index) => {
                    if (index !== 0 && index !== inputs.length - 1) {
                        let file = input.files[0];
                        formData.append("file[]", file);
                    }
                });

                const title = document.getElementById('title').value;
                formData.append('title', title);

                fetch('${BASE_URL}admin/customize/signupandLogin/upload-image', {
                    method: 'POST',
                    body: formData,
                })
                    .then((response) => {
                        if (response.ok) {
                            return response.json(); // If the response is JSON
                        } else {
                            throw new Error('Request failed');
                        }
                    })
                    .then((data) => {
                        // Handle the response from the server
                        console.log(data);
                    })
                    .catch((error) => {
                        console.error(error);
                    });
            }
        </script>
    </layout:put>
</layout:extends>

