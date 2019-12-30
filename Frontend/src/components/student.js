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
	//When the page loads, viewStudentInformation() and logged() are called.
	mounted() {
		this.viewStudentInformation()
		this.logged()

	},

	props: {
		student: {
			type: Object,
			required: true
		}
	},
	data() {
		return {
			studentSchedule: [5],
		};
	},
	async created() {
		try {
			const resAv = await axios.get(
				`http://localhost:8080/scheduledCourses/student/` + localStorage.getItem("studentEmail")
			);
			this.studentSchedule = resAv.data;
		} catch (e) {
			console.error(e);
		}
	},
	methods: {
		//Check information from the database, get the local variables and view it in StudentPage for the tags "email", "name" and "id".
		viewStudentInformation: function () {
			AXIOS.get('/students/' + localStorage.getItem("studentEmail"))
				.then(response => {
					document.getElementById("email").innerText = localStorage.getItem("studentEmail");
					document.getElementById("name").innerText = localStorage.getItem("studentName");
					document.getElementById("id").innerText = localStorage.getItem("studentId");
				})
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

		//For the "Edit Info" button, directs the user to the page where they can send a notification/email to the company manager.
		sendNotifPage: function () {
			Router.push({
				path: "/sendNotif/",
				name: "SendNotif"
			})
		},

		//For the "Schedule Course" button, directs the user to the page where they can select which course they want to find a tutor with.
		courseSelectionPage: function () {
			Router.push({
				path: "/courses",
				name: "Courses"
			})
		},

		//For the "Review" button, directs the user to the page where they can make a review for a tutor they previously had a session with.
		makeReview: function () {
			Router.push({
				path: "/reviewPage",
				name: "ReviewPage"
			})
		}

		,viewScheduledCourseInformation: function () {
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
		}
	}
}