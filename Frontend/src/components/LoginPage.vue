<template>
  <div id="login">
  	<nav>
	    <ul class="navigation-elements">
	    	<li>
	    	 	<a class="myButton" href="/#/">Home</a>
	      	</li>
	      <li>
	        <a class="myButton" href="/#/contactPage">Contact</a>
	      </li>
          <li>
          <a  class="myButton" href="/#/signUpPage">Sign Up!</a>
        </li>
	    </ul>
    </nav>
    <body>

      <div class="centered" id="content" style="padding:70px; border: 1px solid #4CAF50;border-top: 2px solid #000000;">
        <p><b style="font-size: 25px; margin-top:-18rem;"> LOGIN </b></p>
      	</tr>
          	<input id="ip2" type="email" v-model="email" placeholder="Enter Email">
      	</td>
      	</tr>
          	<input id="ip2" type="password" v-model="password" placeholder="Enter Password">
      	</td>
          	<button style="border-radius: 50px; padding-left: 30px; padding-right: 30px; font-size: 20px;" type="button" class="myButton" @click="login(email, password)"><b>LOGIN</b></button>
      	</td>
      </div>
       <div>
        <span id="title1" style="color: red"></span>
      </div>
    </body>
  </div>
</template>

<script src="./login.js">
</script>


<style>
ul {
  list-style-type: none;
  margin: 1;
  padding: 1;
}
li {
  float: left;
  display: inline;
  margin: 13px;
}
li a {
  display: block;
  color: black;
  text-align: center;
  padding: 16px 16px;
  text-decoration: none;
}
li a:hover {
  background-color: rgba(0, 0, 0, 1);
  border-left: 1px solid black;
  border-right: 1px solid black;
  color: white;
}
.navigation-elements a,
.navigation-elements input[type="text"] {
  float: none;
  display: block;
  text-align: left;
  width: 100%;
  margin: 2px;
  padding: 14px;
}
.navigation-elements {
  font-family: helvetica;
  position: absolute;
  background-color: #55608f;
  border-bottom: 4px solid black;
  border-top: 4px solid #55608f;
  width: 100%;
  top: 0px;
  z-index: 40;
  left: 0;
}
.content {
  position: relative;
  font-family: helvetica;
}
.myButton {
  box-shadow: 0px 0px 0px 2px #9fb4f2;
  background: linear-gradient(to bottom, #7892c2 5%, #476e9e 100%);
  background-color: #7892c2;
  border-radius: 6px;
  border: 1px solid #4e6096;
  display: inline-block;
  cursor: pointer;
  color: #ffffff;
  font-family: Arial;
  font-size: 19px;
  padding: 12px 37px;
  text-decoration: none;
  text-shadow: 0px 1px 0px #283966;
  margin: 10px;
}
.myButton:hover {
  background: linear-gradient(to bottom, #476e9e 5%, #7892c2 100%);
  background-color: #476e9e;
}
.myButton:active {
  position: relative;
  top: 1px;
}
.navbar-custom {
  background-color: red !important;
}
#ip2 {
  border-radius: 25px;
  border: 2px solid #100;
  padding: 20px;
  width: 200px;
  height: 15px;
}
.centered {
  margin: 0 auto;
  text-align: left;
  width: 100%;
}
</style>