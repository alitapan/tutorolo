<template>
  <div id="ConfirmationPage">
    
      <meta http-equiv="Content-Type" content="charset=utf-8">  
      <meta http-equiv="Content-Style-Type" content="text/css">  
      <meta name="Author" content="Arneet Kalra">  
      <meta name="Description" content="Confirmation page for a successful tutoring session booking.">
      
       <title>Confirmation</title> 
    </head>
    <nav>
      <ul class="navigation-elements">
        <li>
	        	<a class="myButton" href="/#/studentPage">Student Hub</a>
	      	</li>
          <li>
          <a class="myButton" href="/#/">Sign Out</a>
          </li>
      </ul>
    </nav>
    <body class="body-style-conf">  
      <h2>Your tutoring session has been booked!</h2>
  <p>Here are the details for your session:</p>

  <div id="content" style="padding:70px; border: 2px solid black;margin-left: 50px;margin-right: 50px; border-radius: 10px">
        
        <p> <b>Date:</b>  <span id="date"> </span></p>
        <p> <b>Start Time:</b>  <span id="startTime"> </span></p>
        <p> <b>End Time:</b>  <span id="endTime"> </span></p>
        <p> <b>Tutor Email:</b>  <span id="tutor"> </span> </p>
        <p> <b>To edit the information please contact the company manager.</b>  </p>
      </div>


  <p>Please bring a valid ID and a method of payment (we accept cash and card!).</p>

  <h3>See you soon!</h3>
    </body> 

  </div>
</template>

<script src="./confirmation.js">
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
.body-style-conf {
  text-align: center;
  background-color: white;
  border-top: 2px solid black;
}
</style>