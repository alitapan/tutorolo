<template>
  <div id="Home">
    <nav>
      <ul class="navigation-elements">
        <li>
          <a class="myButton" href="/#/">Home</a>
        </li>
        <li>
          <a class="myButton" href="/#/contactPage">Contact</a>
        </li>
        <li>
          <a class="myButton" href="/#/loginPage">Login</a>
        </li>
      </ul>
    </nav>
    <body>  
      <div id="content" style="padding:70px; text-align:center; border-top: 1px solid #110301;">
       <h2 class= "home_page">One Step Closer To That 4.0!</h2>
        <button class = "myButton"  id = "gotoLogin" @click="gotoLogin()">
          Log in
        </button>
        <button  class ="myButton" id="gotoSignup" @click="gotoSignup()">
          Sign up
        </button>
      </div>
    </body> 

    <footer style="background-color: white">
      <p > For testing: This button will create the required variables for various tests.</p>
       <button class ="myButton" id="test" @click="test()">
          Test
        </button>
        <div style="display: none">
          <p> Once pressed the following will be created and stored in the persistence layer: </p>
     <p> - Create a student: email: ali@gmail.com, id: 123, password: 123, name: Ali </p>
     <p> - Create a tutor: email: einstein@mcgill.ca, id:45, password: 334, name albert, hourly rate: 15 dollars/hr </p>
     <p> - Create 2 availability for the tutor </p>
     <p> - Create a course: Intorduction to Software Engineering, ECSE321, Level: University </p>
     <p> - Create a course: Model-Based Programming, ECSE223, Level: University </p>
     <p> - Creates a scheduled course with the tutor (for review) </p>
     <p> - Creates company manager: marwank@mcgill.ca, id:10, password: 123, name: Marwan </p>

        </div>
      

    </footer>
  </div>
</template>

<script src="./home.js"></script>

<style>
ul {
  list-style-type: none;
  margin: 1;
  padding: 1;
}
li {
  float: left;
  display: inline;
  margin: 10px;
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
  margin: 0;
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
.home_page {
  text-align: center;
  font-family: Comic Sans MS;
  text-decoration: underline;
}
.button {
  margin: auto;
  background-color: black;
  text-align: center;
  font-family: sans-serif;
  background-color: #e75b5b;
  border: 2px solid #110301;
  display: block;
  color: black;
  font_size: 150px;
  width: 250px;
  height: auto;
  border-radius: 6px;
  -webkit-transition-duration: 0.6s;
  transition-duration: 0.6s;
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

.button:hover {
  background-color: #e7d1d1;
  color: #e02706;
  border: 2px solid #110301;
  color: black;
}
</style>
