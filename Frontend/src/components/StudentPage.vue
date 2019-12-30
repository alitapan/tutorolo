<template>
  <div id="studentpage">
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
		
    	<div id="content" style="padding:70px; border: 1px solid #000000;">
    		<p><b> PROFILE INFORMATION </b></p>
    		<p> <b>Student Name:</b> <span id="name"> </span></p>
    		<p> <b>Contact Email:</b>  <span id="email"> </span></p>
    		<p> <b>Student ID:</b>  <span id="id"> </span> </p>
    		<p> To edit the information, please contact the company manager. </p>
				<div>
					<p style="color: green">Your Personal Schedule:</p>
					<div v-if="studentSchedule.length==0">You have not scheduled any tutoring session yet. Once you do It will be desplayed below.</div>
					<div v-else>
					   
						 <table>
		<thead>
			<tr>
				<th>Date</th>
				<th>Start time</th>
				<th>End Time</th>
				<th>Course Name</th>
				<th>Tutor Name</th>
				<th>Email of the Tutor</th>
			</tr>
		</thead>

		<tbody class="tbodyStyle">
		<tr v-for=" sch of studentSchedule" :key="sch.index" >
				<td>{{sch.date}}</td>
				<td>{{sch.startTime}}</td>
				<td>{{sch.endTime}}</td>
				<td>{{sch.course.name}}</td>
				<td>{{sch.tutor.name}}</td>
				<td>{{sch.tutor.email}}</td>
			</tr>
		</tbody>
    

	</table>
					</div>
					<div class="container">
	
</div>
				</div>
    	</div>

    	<span>
      		<button type="button" id="button" v-on:click="sendNotifPage()" class="myButton" v-b-tooltip.hover title="Click to send notification to the administrator if you would like to change your personal information or add a new course" style="background-color: #4bb38b; border-color: black; color: white;">
      			Contact Admin
      		</button>

      		<button type="button" id="button" v-on:click="courseSelectionPage()" class="myButton" v-b-tooltip.hover title="Click to scheduled a course with a tutor" style="background-color: #4bb38b; border-color: black; color: white;">
      			Schedule Course
      		</button>

      		<button type="button" id="button" v-on:click="makeReview()" class="myButton" v-b-tooltip.hover title="Click to review a tutor from a previous tutoring session" style="background-color: #4bb38b; border-color: black; color: white;">
      			Review Tutor
      		</button>
    	</span>

    </body>

  </div>
</template>

<script src="./student.js"></script>

<style>
ul {
  list-style-type: none;
  margin: 1;
  padding: 0;
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
.scheduleStyle {
  border: 2px solid green;
}
.container {
  margin: 0;
  background: linear-gradient(45deg, #49a09d, #5f2c82);
  font-family: sans-serif;
  font-weight: 100;
}

table {
  border-collapse: collapse;
  overflow: hidden;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

th,
td {
  padding: 15px;
  background-color: rgba(255, 255, 255, 0.2);
  color: #fff;
}
th {
  text-align: left;
}
th {
  background-color: #55608f;
}

tbody {
  background-color: rgba(255, 255, 255, 0.3);
}
td {
  content: "";
  left: 0;
  right: 0;
  background-color: rgba(255, 255, 255, 0.2);
  z-index: -1;
  color: black;
}
.tbodyStyle {
  color: green;
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