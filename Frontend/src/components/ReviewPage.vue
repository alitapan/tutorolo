<template>
  <div id="Review">
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

      <div class="" id="content" style="padding:70px; margin-left: 30%">
        <p>
          <input id="ip2"  type = "text" v-model = "tutorEmail" placeholder= "Enter Tutor Email..." />
          <span> 
            <div style=""><b>Rating:</b></div>
            <input id="ip2"  type = "text" v-model = "tutorRating"  placeholder="1, 2, 3 or 4..." />
          </span>
        </p>
        <span>
            <p>
              <textarea style="border-radius: 5px" type = "text" v-model = "madeReview"  rows = "3" cols = "80" placeholder= 'Enter your review...'> </textarea>
            </p>
        </span>
         <button type="button" id="button" v-on:click="makeReview(tutorEmail, tutorRating, madeReview)" class="myButton" v-b-tooltip.hover title="Click to submit your review for the selected tutor. Please be aware that the reviews will only be posted if you have previously booked a session with the selected tutor." style="background-color: #4bb38b; border-color: black; color: white;">
            Submit
        </button>
   
      </div>
    </body>


  </div>
</template>

<script src="./review.js"></script>

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
#ip2 {
  border-radius: 25px;
  border: 2px solid #100;
  padding: 20px;
  width: 200px;
  height: 15px;
  margin: 2px;
}
.centered {
  margin: 0 auto;
  text-align: left;
  width: 100%;
}
</style>