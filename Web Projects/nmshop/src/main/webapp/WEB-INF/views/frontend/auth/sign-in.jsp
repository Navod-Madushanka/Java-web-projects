<%--
  Created by IntelliJ IDEA.
  User: Navod Madusanka
  Date: 10/10/2023
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://callidora.lk/jsp/template-inheritance" prefix="layout"%>
<layout:extends name="base_1">
  <layout:put block="signup" type="REPLACE">
    <div class="axil-signin-area">

      <!-- Start Header -->
      <div class="signin-header">
        <div class="row align-items-center">
          <div class="col-sm-4">
            <a href="index.html" class="site-logo"><img src="./assets/images/logo/logo.png" alt="logo"></a>
          </div>
          <div class="col-sm-8">
            <div class="singin-header-btn">
              <p>Not a member?</p>
              <a href="${BASE_URL}signup" class="axil-btn btn-bg-secondary sign-up-btn">Sign Up Now</a>
            </div>
          </div>
        </div>
      </div>
      <!-- End Header -->

      <div class="row">
        <div class="col-xl-4 col-lg-6">
          <div class="axil-signin-banner bg_image bg_image--9">
            <h3 class="title" id="title">We Offer the Best Products</h3>
          </div>
        </div>
        <div class="col-lg-6 offset-xl-2">
          <div class="axil-signin-form-wrap">
            <div class="axil-signin-form">
              <h3 class="title">Sign in to eTrade.</h3>
              <p class="b2 mb--55">Enter your detail below</p>
              <form class="singin-form">
                <div class="form-group">
                  <label>Email</label>
                  <input type="email" class="form-control" name="email" value="navod@gmail.com" id="email" >
                </div>
                <div class="form-group">
                  <label>Password</label>
                  <input type="password" class="form-control" name="password" value="1234" id="password">
                </div>
                <div class="form-group d-flex align-items-center justify-content-between">
                  <button id="signInBtn" type="submit" class="axil-btn btn-bg-primary submit-btn">Sign In</button>
                  <a href="forgot-password.html" class="forgot-btn">Forget password?</a>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </layout:put>
  <layout:put block="script">
    <script type="text/javascript">
      document.getElementById('signInBtn').addEventListener('click',()=>{
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;

        fetch('${BASE_URL}login',{
          method:'post',
          headers:{
            'content-type':'application/json'
          },
          body:JSON.stringify({
            email:email,
            password:password
          })
        }).then(async response =>{
          if(response.status != 200){
            alert(response.text());
          }
          return response.json();
        }).then(data=>{
          localStorage.setItem('userType', data.userType);
          localStorage.setItem('accessToken', data.accessToken);
          localStorage.setItem('refreshToken', data.refreshToken);
          localStorage.setItem('expireIn', data.expireIn);
          if(data.userType == "admin"){
            sendRequestTODashBoard(data.accessToken);
          }else{
            window.location.href = '${BASE_URL}';
          }
        });
      });


      function sendRequestTODashBoard(accessToken){
        fetch('${BASE_URL}admin/dashboard',{
          method: 'GET',
          headers:{
            'Authorization': 'Bearer ' + accessToken,
            'Content-Type':'application/json'
          }
        }).then(response=> response.text())
                .then(data=>{
                  console.log(data)
                }).catch(error => {
          alert(error);
        });

      }

      function changeTitle(){
        alert("ok");
      }

    </script>
  </layout:put>
</layout:extends>

