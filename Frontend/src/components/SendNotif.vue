<template>
  <div id="SendNotif">
    <nav>
      <ul class="navigation-elements">
        <li>
	        	<a class="myButton" href="/#/studentpage">Student Hub</a>
	      	</li>
          <li>
          <a class="myButton" href="/#/">Sign Out</a>
          </li>
      </ul>
    </nav>

    <body>
      <div id="content" style="padding:70px;margin-left: 30%">
 <p> <b>Company Manager:</b>  Marwan Kanaan </p>
          <p> <b>Address:</b>  3480 Rue University, Montréal, QC H3A 2K6 </p>
          <p> <b>Development Team:</b>  Group 22 - https://github.com/McGill-ECSE321-Fall2019/project-group-22 </p>
        <p>       
 <p>
          <input style="border-radius: 4px" type = "text" id = "myText" placeholder = "Enter a Subject..." />
        </p>
        <p>
          <textarea style="border-radius: 4px"  id = "message" rows = "3" cols = "80" placeholder="Enter your message"> </textarea>
        </p>

        <button type="button" id="button" v-on:click="sendNotification()" class="myButton" v-b-tooltip.hover title="Click to send a message to the administrator" style="background-color: #4bb38b; border-color: black; color: white;">
            Send
          </button>

      </div>
    </body>
  </div>
</template>


<script src="./notification.js"></script>


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
  border-bottom: 4px solid #a9c4ff;
  border-top: 4px solid #a9c4ff;
  width: 100%;
  top: 0px;
  z-index: 40;
  left: 0;
}
.content {
  position: relative;
  font-family: helvetica;
}
input:active,
input:focus {
  outline: 0;

  -moz-outline-style: none;
}
textarea:active,
textarea:focus {
  outline: 0;

  -moz-outline-style: none;
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
</style>