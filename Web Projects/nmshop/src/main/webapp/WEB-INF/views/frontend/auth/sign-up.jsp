<%--
  Created by IntelliJ IDEA.
  User: Navod Madusanka
  Date: 8/20/2023
  Time: 8:28 AM
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
          <div class="col-md-6">
            <a href="index.html" class="site-logo"><img src="./assets/images/logo/logo.png" alt="logo"></a>
          </div>
          <div class="col-md-6">
            <div class="singin-header-btn">
              <p>Already a member?</p>
              <a href="${BASE_url}login" class="axil-btn btn-bg-secondary sign-up-btn">Sign In</a>
            </div>
          </div>
        </div>
      </div>
      <!-- End Header -->

      <div class="row">
        <div class="col-xl-4 col-lg-6">
          <div class="axil-signin-banner bg_image bg_image--10">
            <h3 class="title">We Offer the Best Products</h3>
          </div>
        </div>
        <div class="col-lg-6 offset-xl-2">
          <div class="axil-signin-form-wrap">
            <div class="axil-signin-form">
              <h3 class="title">I'm New Here</h3>
              <p class="b2 mb--55">Enter your detail below</p>
              <form class="singin-form">
                <div class="form-group">
                  <label>User Name</label>
                  <input type="text" class="form-control" id="username" name="username" value="anniemario">
                </div>
                <div class="form-group">
                  <label>Email</label>
                  <input type="email" class="form-control" id="email" name="email" value="annie@example.com">
                </div>
                <div class="form-group">
                  <label>Password</label>
                  <input type="password" class="form-control" id="password" name="password" value="123456789">
                </div>
                <div class="form-group">
                  <button type="submit" class="axil-btn btn-bg-primary submit-btn signup">Create Account</button>
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
      const signupBtn = document.getElementsByClassName('signup').item(0);
      signupBtn.addEventListener('click', function (){
        const username = document.getElementById('username').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;

        fetch('${BASE_URL}signup',{
          method: 'post',
          headers:{
            'content-type':'application/json'
          },
          body: JSON.stringify({
            username:username,
            email:email,
            password:password
          })
        }).then(async response =>{
          if(response.ok){
            window.location.href='${BASE_URL}login';
          }else{
            return await response.text();
          }
          return await response.text();
        }).then(text => alert(text));
      });
    </script>
  </layout:put>
</layout:extends>

