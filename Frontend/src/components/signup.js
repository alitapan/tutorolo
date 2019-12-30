  
import axios from "axios";
import Router from "../router";

var config = require("../../config");
// Axios config
var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { "Access-Control-Allow-Origin": frontendUrl }
});

export default{
	data(){
		return {
			student:{
				type: Object
			},
			email: "",
			password: "",
			name: "",
			id: "",
			error: ""
		};
	},


	methods:{

		signup: function(name, email, idNumber, password) {
			if(name == "" || email == ""||idNumber == "" || password == "")
			{
				document.getElementById("title1").innerText = "Please enter a valid user name, email, id and password!";
			}
			else
			{
				AXIOS.get(`/students/`+ email)
				    .then(response => {
				        this.student = response.data;
				        if (this.student.password == email) {
				        	document.getElementById("title1").innerText= "This email already exists in our system!";
				        }
				        if (this.student.id == idNumber) {
				        	document.getElementById("title1").innerText= "This id already exists in our system!";
				        }
				    })
				    .catch(e => {
				    	console.log(e.message);
				        AXIOS.post(`/student/create/` + email + '?password=' + password + '&name=' + name + '&studentId=' + idNumber)
						.then(response =>{
							alert("Success!");
							this.goToLoginPage();
						});	
				    });
				}
		},

		goToLoginPage:function(){
			Router.push({
				path: "/loginPage/",
				name: "LoginPage"
			});
		}

	}
}