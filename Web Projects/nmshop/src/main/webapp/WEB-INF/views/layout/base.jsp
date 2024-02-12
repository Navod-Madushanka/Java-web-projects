<%--
  Created by IntelliJ IDEA.
  User: Navod Madusanka
  Date: 8/17/2023
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://callidora.lk/jsp/template-inheritance" prefix="layout"%>

<!doctype html>
<html class="no-js" lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>${App.getString('app_name')} || Home-01</title>
  <meta name="robots" content="noindex, follow" />
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Favicon -->
  <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png">

  <!-- CSS
  ============================================ -->

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="${BASE_URL}assets/css/vendor/bootstrap.min.css">
  <link rel="stylesheet" href="${BASE_URL}assets/css/vendor/font-awesome.css">
  <link rel="stylesheet" href="${BASE_URL}assets/css/vendor/flaticon/flaticon.css">
  <link rel="stylesheet" href="${BASE_URL}assets/css/vendor/slick.css">
  <link rel="stylesheet" href="${BASE_URL}assets/css/vendor/slick-theme.css">
  <link rel="stylesheet" href="${BASE_URL}assets/css/vendor/jquery-ui.min.css">
  <link rel="stylesheet" href="${BASE_URL}assets/css/vendor/sal.css">
  <link rel="stylesheet" href="${BASE_URL}assets/css/vendor/magnific-popup.css">
  <link rel="stylesheet" href="${BASE_URL}assets/css/vendor/base.css">
  <link rel="stylesheet" href="${BASE_URL}assets/css/style.min.css">

</head>


<body class="sticky-header newsletter-popup-modal">

<!--[if lte IE 9]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
<![endif]-->
<a href="#top" class="back-to-top" id="backto-top"><i class="fal fa-arrow-up"></i></a>
<jsp:include page="../frontend/include/header.jsp"/>

<layout:block name="content"></layout:block>



<!-- Start Footer Area  -->
<jsp:include page="../frontend/include/footer.jsp"/>
<!-- End Footer Area  -->

<!-- Product Quick View Modal Start -->
<div class="modal fade quick-view-product" id="quick-view-modal" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"><i class="far fa-times"></i></button>
      </div>
      <div class="modal-body">
        <div class="single-product-thumb">
          <div class="row">
            <div class="col-lg-7 mb--40">
              <div class="row">
                <div class="col-lg-10 order-lg-2">
                  <div class="single-product-thumbnail product-large-thumbnail axil-product thumbnail-badge zoom-gallery">
                    <div class="thumbnail">
                      <img src="${BASE_URL}assets/images/product/product-big-01.png" alt="Product Images">
                      <div class="label-block label-right">
                        <div class="product-badget">20% OFF</div>
                      </div>
                      <div class="product-quick-view position-view">
                        <a href="${BASE_URL}assets/images/product/product-big-01.png" class="popup-zoom">
                          <i class="far fa-search-plus"></i>
                        </a>
                      </div>
                    </div>
                    <div class="thumbnail">
                      <img src="${BASE_URL}assets/images/product/product-big-02.png" alt="Product Images">
                      <div class="label-block label-right">
                        <div class="product-badget">20% OFF</div>
                      </div>
                      <div class="product-quick-view position-view">
                        <a href="${BASE_URL}assets/images/product/product-big-02.png" class="popup-zoom">
                          <i class="far fa-search-plus"></i>
                        </a>
                      </div>
                    </div>
                    <div class="thumbnail">
                      <img src="${BASE_URL}assets/images/product/product-big-03.png" alt="Product Images">
                      <div class="label-block label-right">
                        <div class="product-badget">20% OFF</div>
                      </div>
                      <div class="product-quick-view position-view">
                        <a href="${BASE_URL}assets/images/product/product-big-03.png" class="popup-zoom">
                          <i class="far fa-search-plus"></i>
                        </a>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-lg-2 order-lg-1">
                  <div class="product-small-thumb small-thumb-wrapper">
                    <div class="small-thumb-img">
                      <img src="${BASE_URL}assets/images/product/product-thumb/thumb-08.png" alt="thumb image">
                    </div>
                    <div class="small-thumb-img">
                      <img src="${BASE_URL}assets/images/product/product-thumb/thumb-07.png" alt="thumb image">
                    </div>
                    <div class="small-thumb-img">
                      <img src="${BASE_URL}assets/images/product/product-thumb/thumb-09.png" alt="thumb image">
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-5 mb--40">
              <div class="single-product-content">
                <div class="inner">
                  <div class="product-rating">
                    <div class="star-rating">
                      <img src="${BASE_URL}assets/images/icons/rate.png" alt="Rate Images">
                    </div>
                    <div class="review-link">
                      <a href="#">(<span>1</span> customer reviews)</a>
                    </div>
                  </div>
                  <h3 class="product-title">Serif Coffee Table</h3>
                  <span class="price-amount">$155.00 - $255.00</span>
                  <ul class="product-meta">
                    <li><i class="fal fa-check"></i>In stock</li>
                    <li><i class="fal fa-check"></i>Free delivery available</li>
                    <li><i class="fal fa-check"></i>Sales 30% Off Use Code: MOTIVE30</li>
                  </ul>
                  <p class="description">In ornare lorem ut est dapibus, ut tincidunt nisi pretium. Integer ante est, elementum eget magna. Pellentesque sagittis dictum libero, eu dignissim tellus.</p>

                  <div class="product-variations-wrapper">

                    <!-- Start Product Variation  -->
                    <div class="product-variation">
                      <h6 class="title">Colors:</h6>
                      <div class="color-variant-wrapper">
                        <ul class="color-variant mt--0">
                          <li class="color-extra-01 active"><span><span class="color"></span></span>
                          </li>
                          <li class="color-extra-02"><span><span class="color"></span></span>
                          </li>
                          <li class="color-extra-03"><span><span class="color"></span></span>
                          </li>
                        </ul>
                      </div>
                    </div>
                    <!-- End Product Variation  -->

                    <!-- Start Product Variation  -->
                    <div class="product-variation">
                      <h6 class="title">Size:</h6>
                      <ul class="range-variant">
                        <li>xs</li>
                        <li>s</li>
                        <li>m</li>
                        <li>l</li>
                        <li>xl</li>
                      </ul>
                    </div>
                    <!-- End Product Variation  -->

                  </div>

                  <!-- Start Product Action Wrapper  -->
                  <div class="product-action-wrapper d-flex-center">
                    <!-- Start Quentity Action  -->
                    <div class="pro-qty"><input type="text" value="1"></div>
                    <!-- End Quentity Action  -->

                    <!-- Start Product Action  -->
                    <ul class="product-action d-flex-center mb--0">
                      <li class="add-to-cart"><a href="cart.html" class="axil-btn btn-bg-primary">Add to Cart</a></li>
                      <li class="wishlist"><a href="wishlist.html" class="axil-btn wishlist-btn"><i class="far fa-heart"></i></a></li>
                    </ul>
                    <!-- End Product Action  -->

                  </div>
                  <!-- End Product Action Wrapper  -->
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Product Quick View Modal End -->

<!-- Header Search Modal End -->
<div class="header-search-modal" id="header-search-modal">
  <button class="card-close sidebar-close"><i class="fas fa-times"></i></button>
  <div class="header-search-wrap">
    <div class="card-header">
      <form action="#">
        <div class="input-group">
          <input type="search" class="form-control" name="prod-search" id="prod-search" placeholder="Write Something....">
          <button type="submit" class="axil-btn btn-bg-primary"><i class="far fa-search"></i></button>
        </div>
      </form>
    </div>
    <div class="card-body">
      <div class="search-result-header">
        <h6 class="title">24 Result Found</h6>
        <a href="shop.html" class="view-all">View All</a>
      </div>
      <div class="psearch-results">
        <div class="axil-product-list">
          <div class="thumbnail">
            <a href="single-product.html">
              <img src="./assets/images/product/electric/product-09.png" alt="Yantiti Leather Bags">
            </a>
          </div>
          <div class="product-content">
            <div class="product-rating">
                                <span class="rating-icon">
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fal fa-star"></i>
                            </span>
              <span class="rating-number"><span>100+</span> Reviews</span>
            </div>
            <h6 class="product-title"><a href="single-product.html">Media Remote</a></h6>
            <div class="product-price-variant">
              <span class="price current-price">$29.99</span>
              <span class="price old-price">$49.99</span>
            </div>
            <div class="product-cart">
              <a href="cart.html" class="cart-btn"><i class="fal fa-shopping-cart"></i></a>
              <a href="wishlist.html" class="cart-btn"><i class="fal fa-heart"></i></a>
            </div>
          </div>
        </div>
        <div class="axil-product-list">
          <div class="thumbnail">
            <a href="single-product.html">
              <img src="./assets/images/product/electric/product-09.png" alt="Yantiti Leather Bags">
            </a>
          </div>
          <div class="product-content">
            <div class="product-rating">
                                <span class="rating-icon">
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fal fa-star"></i>
                            </span>
              <span class="rating-number"><span>100+</span> Reviews</span>
            </div>
            <h6 class="product-title"><a href="single-product.html">Media Remote</a></h6>
            <div class="product-price-variant">
              <span class="price current-price">$29.99</span>
              <span class="price old-price">$49.99</span>
            </div>
            <div class="product-cart">
              <a href="cart.html" class="cart-btn"><i class="fal fa-shopping-cart"></i></a>
              <a href="wishlist.html" class="cart-btn"><i class="fal fa-heart"></i></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Header Search Modal End -->


<div class="cart-dropdown" id="cart-dropdown">
  <div class="cart-content-wrap">
    <div class="cart-header">
      <h2 class="header-title">Cart review</h2>
      <button class="cart-close sidebar-close"><i class="fas fa-times"></i></button>
    </div>
    <div class="cart-body">
      <ul class="cart-item-list">
        <li class="cart-item">
          <div class="item-img">
            <a href="single-product.html"><img src="assets/images/product/electric/product-01.png" alt="Commodo Blown Lamp"></a>
            <button class="close-btn"><i class="fas fa-times"></i></button>
          </div>
          <div class="item-content">
            <div class="product-rating">
                                <span class="icon">
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
							</span>
              <span class="rating-number">(64)</span>
            </div>
            <h3 class="item-title"><a href="single-product-3.html">Wireless PS Handler</a></h3>
            <div class="item-price"><span class="currency-symbol">$</span>155.00</div>
            <div class="pro-qty item-quantity">
              <input type="number" class="quantity-input" value="15">
            </div>
          </div>
        </li>
        <li class="cart-item">
          <div class="item-img">
            <a href="single-product-2.html"><img src="assets/images/product/electric/product-02.png" alt="Commodo Blown Lamp"></a>
            <button class="close-btn"><i class="fas fa-times"></i></button>
          </div>
          <div class="item-content">
            <div class="product-rating">
                                <span class="icon">
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
							</span>
              <span class="rating-number">(4)</span>
            </div>
            <h3 class="item-title"><a href="single-product-2.html">Gradient Light Keyboard</a></h3>
            <div class="item-price"><span class="currency-symbol">$</span>255.00</div>
            <div class="pro-qty item-quantity">
              <input type="number" class="quantity-input" value="5">
            </div>
          </div>
        </li>
        <li class="cart-item">
          <div class="item-img">
            <a href="single-product-3.html"><img src="assets/images/product/electric/product-03.png" alt="Commodo Blown Lamp"></a>
            <button class="close-btn"><i class="fas fa-times"></i></button>
          </div>
          <div class="item-content">
            <div class="product-rating">
                                <span class="icon">
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
							</span>
              <span class="rating-number">(6)</span>
            </div>
            <h3 class="item-title"><a href="single-product.html">HD CC Camera</a></h3>
            <div class="item-price"><span class="currency-symbol">$</span>200.00</div>
            <div class="pro-qty item-quantity">
              <input type="number" class="quantity-input" value="100">
            </div>
          </div>
        </li>
      </ul>
    </div>
    <div class="cart-footer">
      <h3 class="cart-subtotal">
        <span class="subtotal-title">Subtotal:</span>
        <span class="subtotal-amount">$610.00</span>
      </h3>
      <div class="group-btn">
        <a href="cart.html" class="axil-btn btn-bg-primary viewcart-btn">View Cart</a>
        <a href="checkout.html" class="axil-btn btn-bg-secondary checkout-btn">Checkout</a>
      </div>
    </div>
  </div>
</div>

<!-- Offer Modal Start -->
<div class="offer-popup-modal" id="offer-popup-modal">
  <div class="offer-popup-wrap">
    <div class="card-body">
      <button class="popup-close"><i class="fas fa-times"></i></button>
      <div class="content">
        <div class="section-title-wrapper">
          <span class="title-highlighter highlighter-primary"> <i class="far fa-shopping-basket"></i> Don’t Miss!!</span>
          <h3 class="title">Best Sales Offer<br> Grab Yours</h3>
        </div>
        <div class="poster-countdown countdown"></div>
        <a href="shop.html" class="axil-btn btn-bg-primary">Shop Now <i class="fal fa-long-arrow-right"></i></a>
      </div>
    </div>
  </div>
</div>
<div class="closeMask"></div>
<!-- Offer Modal End -->
<!-- JS
============================================ -->
<!-- Modernizer JS -->
<script src="${BASE_URL}assets/js/vendor/modernizr.min.js"></script>
<!-- jQuery JS -->
<script src="${BASE_URL}assets/js/vendor/jquery.js"></script>
<!-- Bootstrap JS -->
<script src="${BASE_URL}assets/js/vendor/popper.min.js"></script>
<script src="${BASE_URL}assets/js/vendor/bootstrap.min.js"></script>
<script src="${BASE_URL}assets/js/vendor/slick.min.js"></script>
<script src="${BASE_URL}assets/js/vendor/js.cookie.js"></script>
<!-- <script src="assets/js/vendor/jquery.style.switcher.js"></script> -->
<script src="${BASE_URL}assets/js/vendor/jquery-ui.min.js"></script>
<script src="${BASE_URL}assets/js/vendor/jquery.ui.touch-punch.min.js"></script>
<script src="${BASE_URL}assets/js/vendor/jquery.countdown.min.js"></script>
<script src="${BASE_URL}assets/js/vendor/sal.js"></script>
<script src="${BASE_URL}assets/js/vendor/jquery.magnific-popup.min.js"></script>
<script src="${BASE_URL}assets/js/vendor/imagesloaded.pkgd.min.js"></script>
<script src="${BASE_URL}assets/js/vendor/isotope.pkgd.min.js"></script>
<script src="${BASE_URL}assets/js/vendor/counterup.js"></script>
<script src="${BASE_URL}assets/js/vendor/waypoints.min.js"></script>

<!-- Main JS -->
<script src="assets/js/main.js"></script>
<script src="assets/js/secureFetch.js"></script>
<script>
  function secureFetch(url, options = {}) {
    const token = localStorage.getItem("accessToken");
    const expireIn = localStorage.getItem("expireIn");

    const expireAt = new Date(Number(expireIn)).getTime();
    const expireGate = new Date().getTime() + 2 * 60 * 1000;

    if (token && expireAt && expireAt < expireGate) {
      return refreshToken().then(newToken => {
        options.headers = {
          ...options.headers,
          Authorization: 'Bearer ' + newToken
        }

        return fetch(url, options);
      })
    }

    if (token) {
      options.headers = {
        ...options.headers,
        Authorization: 'Bearer ' + token
      }
    } else {
      console.log("Token Unavailable");
      window.location.href = "${BASE_URL}login"
    }
    return fetch(url, options);
  }

  function refreshToken() {
    const oldRefreshToken = localStorage.getItem("refreshToken");

    const fromData = new URLSearchParams();
    fromData.append('token', oldRefreshToken);

    if (oldRefreshToken) {
      return fetch("${BASE_URL}login/refresh-token", {
        method: 'post',
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: fromData
      }).then(response => {
        if (!response.ok) {
          window.location.href = "${BASE_URL}login"
        }
        return response.json();
      }).then(data => {
        localStorage.setItem("accessToken", data.accessToken);
        localStorage.setItem("refreshToken", data.refreshToken);
        localStorage.setItem("expireIn", data.expireIn);
        return data.accessToken;
      });
    } else {
      localStorage.removeItem("accessToken");
      localStorage.removeItem("expireIn");
      window.location.href = "${BASE_URL}login"
    }

  }
<%--  document.getElementById('whishlist').addEventListener('click', (evt)=>{--%>
<%--    secureFetch('${BASE_URL}api/v1/category',{--%>
<%--      headers:{--%>
<%--        'Content-Type':'application/json'--%>
<%--      }--%>
<%--    }).then(response=> response.text())--%>
<%--            .then(data=>{--%>
<%--              console.log(data)--%>
<%--            })--%>
<%--  });--%>
</script>

</body>

</html>