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

	data() {
    return {
      companyManager: {
        type: Object
      },

      email: "",
      password: "",
      name: "",
      id: "",
      error: "",
      message:"",
    };
  },

	methods: {

		//Get the company manager information and send the notification to him.
		sendNotification: function() {
			var message = document.getElementById('message').value;
			AXIOS.get('/companyManager/')
			.then(response => {
				this.companyManager= response.data;
				localStorage.setItem("cmEmail", this.companyManager.email);
			})
			var managerEmail = this.companyManager.email;
			AXIOS.post('/notification/create/' + message + '?senderEmail=' + localStorage.getItem("studentEmail") + '&cmEmail=' + localStorage.getItem("cmEmail"))
			.then(response => {
              	alert("Success!");
			})
			
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
		createCompanyManager: function() {
			AXIOS.post('/companyManager/create/marawan.kanaan@mcgill.ca?password=321&name=Marwan Kanaan&companyManagerId=1')
			.then(response => {
				alert("Success creating company manager!");
			})
		}
	}
}