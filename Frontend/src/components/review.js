import axios from 'axios'
import Router from "../router";

var config = require('../../config')
var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})


export default {

	//When the page loads logged() are called.
	mounted(){
		this.logged()

	},

	data() 
	{
    return {
      tutor: {
        type: Object
      },
      email: "",
      password: "",
      name: "",
      id: "",
      hourlyRate: "",
      error: "",
    };


  },

	methods: {
		
		//Make a review for a tutor
		makeReview: function(tutorEmail, tutorRating, madeReview) {

			var numberOfReviews = 0;
			var scheduledCourses = 0;
			localStorage.setItem('numberOfReviews', 0);
			if(!(tutorRating == 1|| tutorRating == 2|| tutorRating == 3|| tutorRating==4))
			{
				alert("Please enter valid rating, either 1, 2, 3 or 4!");
			}
			else {
				//Get the tutor from database
				AXIOS.get('/tutors/find/' + tutorEmail)
				.then(response => {
					this.tutor = response.data
					localStorage.setItem("tutEmail", this.tutor.email);
				})
				//Check if the tutor exists
				if(localStorage.getItem('tutEmail') == "")
				{
					alert("This tutor does not exist in our system!");
				}
				else
				{
					AXIOS.get('/scheduledCourses/tutor/'+ localStorage.getItem('tutEmail') +'?stuEmail=' + localStorage.getItem('studentEmail'))
					.then(response => {
						scheduledCourses = response.data;
						localStorage.setItem('scheduledCourses', scheduledCourses);
					})
				
					if(localStorage.getItem('scheduledCourses') == 0)
					{
						alert("You have not been tutored by this tutor, therefore you cannot review!")
					}
					else
					{
						AXIOS.get('/tutors/reviews/' + localStorage.getItem('tutEmail'))
						.then(response => {
							numberOfReviews = response.data;
							localStorage.setItem('numberOfReviews', (numberOfReviews+1));
						})
						
						AXIOS.post('/review/create/' + localStorage.getItem('numberOfReviews') + '?rating=' + 
							tutorRating + '&comment=' + madeReview + '&tutEmail=' + localStorage.getItem('tutEmail'))
						.then(response => {
			              	alert("Success!");
						}) 
					}
				}
			}
		},

		//Checks if the user is logged in, otherwise sends them back to the login page if the browser times out.
		logged: function() {
	    	var isLoggedIn = localStorage.getItem("isLoggedIn");
	    	// Send the user back to the login page if they are not logged in.
	    	if (isLoggedIn === "false") {
	     		Router.push({
	        		path: "/loginPage/",
	        		name: "LoginPage"
	      		});
	  		}
		},

		//For testing
		createReview: function() {
			AXIOS.post('/course/create/Introduction to Software Engineering?courseLevel=University&courseCode=ECSE321')
			.then(response =>{
				alert("Success creating course!")
			})
			AXIOS.post('/tutor/create/einstein@mcgill.ca?password=334&name=albert&tutorId=45&hourlyRate=15')
			.then(response =>{
				alert("Success creating tutor!")
			})
			AXIOS.post('/scheduledCourse/create/1?stuEmail=' + localStorage.getItem('studentEmail') 
				+'&tutEmail=einstein@mcgill.ca&courseName=Introduction to Software Engineering&roomNumber=3&start=11:00:00&end=11:45:00&dat=2019-09-01')
			.then(response => {
				alert("Success creating scheduledCourse!");
			})
		}
	}
}