<%@taglib prefix="layout" uri="http://callidora.lk/jsp/template-inheritance" %>
<layout:extends name="admin_base">
    <layout:put block="style">
        <link rel="stylesheet" type="text/css" href="${admin_assets}/libs/css/summernote.min.css">
    </layout:put>
    <layout:put block="contents">
        <!-- ============================================================== -->
        <!-- pageheader -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- pageheader -->
        <!-- ============================================================== -->
        <div class="row">
            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                <div class="page-header">
                    <h2 class="pageheader-title">Product </h2>
                    <p class="pageheader-text"></p>
                    <div class="page-breadcrumb">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">Dashboard</a></li>
                                <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">Product</a></li>
                                <li class="breadcrumb-item active" aria-current="page">Add</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- end pageheader -->
        <!-- ============================================================== -->

        <form id="form-add-product" autocomplete="off" novalidate="novalidate">
            <div class="row">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="section-block" id="basicform">
                        <h3 class="section-title">Add New Product</h3>
                        <p></p>
                    </div>
                    <div class="card">
                        <h5 class="card-header">Product</h5>
                        <div class="card-body">
                            <div class="form-group">
                                <label for="product-name" class="col-form-label">Product Name</label>
                                <input id="product-name" type="text" class="form-control col-sm-6">
                            </div>
                            <div class="form-group">
                                <label for="product-price" class="col-form-label">Product Price</label>
                                <input id="product-price" type="text" class="form-control col-sm-4">
                            </div>
                            <div class="form-group">
                                <label for="product-discount" class="col-form-label">Product Discount Price</label>
                                <input id="product-discount" type="text" class="form-control col-sm-4">
                            </div>
                            <div class="form-group">
                                <label for="product-description">Description</label>
                                <textarea class="form-control" id="product-description"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="card">
                        <h5 class="card-header">Product Images</h5>
                        <div class="card-body">
                            <div class="row">
                                <div id="image-dev"></div>
                            </div>

                            <div class="row pt-2 pt-sm-5 mt-1">
                                <div class="col-sm-12 pl-0">
                                    <p class="text-right">
                                        <button id="add-product" class="btn btn-space btn-primary">Save</button>
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
            $('#product-description').summernote({
                height: 300
            });

            $('#image-dev').spartanMultiImagePicker({
                fieldName: 'file[]',
                maxCount: 5
            });

            document.querySelector('#add-product').addEventListener('click', (evt) => {
                evt.preventDefault();
                let productName = document.querySelector('#product-name').value;
                let productPrice = document.querySelector('#product-price').value;
                let productDiscount = document.querySelector('#product-discount').value;
                let productDescription = $('#product-description').summernote('code');
                console.log(productDescription)

                fetch('${BASE_URL}admin/api/v1/product', {
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    method: 'post',
                    body: JSON.stringify({
                        name: productName,
                        price: productPrice,
                        discountPrice: productDiscount,
                        description: productDescription
                    })
                }).then(response => response.json())
                    .then(data => {
                        uploadImages(data.pid);
                    })
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

                fetch('${BASE_URL}admin/api/v1/product/' + id + '/upload-image', {
                    method: 'post',
                    body: formData
                }).then(response => response.json())
                    .then(data => {
                        console.log(data);
                        window.location.href = '${BASE_URL}admin/product';
                    });
            }

        </script>
    </layout:put>
</layout:extends>