import axios from 'axios'
import Router from "../router";

var config = require('../../config')
var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort
var AXIOS = axios.create({
	baseURL: backendUrl,
	headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

//Required parameters from the course page:
//local variables: date, time, tutor and scId

export default {
	//When the page loads, viewStudentInformation() and logged() are called.
	mounted() {
		this.viewScheduledCourseInformation()
		this.logged()

	},

	props: {
		student: {
			type: Object,
			required: true
		}
	},
	methods: {

		viewScheduledCourseInformation: function () {
			document.getElementById("date").innerText = localStorage.getItem("selectedDate");
			document.getElementById("startTime").innerText = localStorage.getItem("selectedStartTime");
			document.getElementById("endTime").innerText = localStorage.getItem("selectedEndTime");
			document.getElementById("tutor").innerText = localStorage.getItem("SelectedTutorEmail");

			var a = 0;
			AXIOS.get(`/scheduledCourse/getNum`)
				.then(response => {
					a = response.data;
				})
			a = a + 1;

			AXIOS.post(`/scheduledCourse/create/` + a + '?stuEmail=' + localStorage.getItem("studentEmail") + '&tutEmail=' + localStorage.getItem("SelectedTutorEmail")
				+ '&courseName=' + localStorage.getItem("selectedCourse") + '&roomNumber=3&start=' + localStorage.getItem("selectedStartTime") + '&end=' + localStorage.getItem("selectedEndTime")
				+ '&dat=' + localStorage.getItem("selectedDate"))
				.then(response => {
					alert('Notification sent to to the tutor!');
				})
				.catch(e => {
					aler('Scheduling failed! Please contact the administration.');
				});
		},

		//Checks if the user is logged in, otherwise sends them back to the login page if the browser times out.
		logged: function () {
			var isLoggedIn = localStorage.getItem("isLoggedIn");
			// Send the user back to the login page if they are not logged in.
			if (isLoggedIn === "false") {
				Router.push({
					path: "/loginPage/",
					name: "LoginPage"
				});
			}
		},
	}
}