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
	methods: {
		gotoLogin: function () {
			Router.push({
				path: "/loginPage/",
				name: "LoginPage"
			});
		},

		gotoSignup: function () {
			Router.push({
				path: '/signUpPage',
				name: 'SignUpPage'
			});
		},

		//Function to go to the student profile page
		test: function () {
			AXIOS.post('/student/create/ali@gmail.com?password=123&name=ali&studentId=112')
				.then(response => {

					AXIOS.post('/tutor/create/einstein@mcgill.ca?password=334&name=albert&tutorId=45&hourlyRate=15')
						.then(response => {
							AXIOS.post('availability/create/2?date=2019-01-01&start=11:00:00&end=12:00:00&tutEmail=einstein@mcgill.ca')
								.then(response => {

								})
							AXIOS.post('availability/create/4?date=2019-01-01&start=09:00:00&end=10:00:00&tutEmail=einstein@mcgill.ca')
								.then(response => {

								})
							AXIOS.post('/course/create/Introduction to Software Engineering?courseLevel=University&courseCode=ECSE321')
								.then(response => {

								})
							AXIOS.post('/course/create/Model Based Programming?courseLevel=University&courseCode=ECSE223')
								.then(response => {

								})
							AXIOS.post('/tutors/add/course/Introduction to Software Engineering?tutEmail=einstein@mcgill.ca')
								.then(response => {

								})
							AXIOS.post('/tutors/add/course/Model Based Programming?tutEmail=einstein@mcgill.ca')
								.then(response => {

								})
							AXIOS.post('/tutors/add/course/Calculus I?tutEmail=einstein@mcgill.ca')
								.then(response => {

								})
							AXIOS.post('/scheduledCourse/create/1?stuEmail=ali@gmail.com&tutEmail=einstein@mcgill.ca&courseName=Introduction to Software Engineering&roomNumber=3&start=11:00:00&end=11:45:00&dat=2019-09-01')
								.then(response => {

								})
							AXIOS.post('/course/create/Calculus IV?courseLevel=University&courseCode=MATH264')
								.then(response => {
								})

							AXIOS.post('/course/create/Electromagnetic Waves?courseLevel=University&courseCode=ECSE354')
								.then(response => {
								})

							AXIOS.post('/course/create/Economics of the Env.?courseLevel=University&courseCode=ECON225')
								.then(response => {
								})

							AXIOS.post('/course/create/Introduction to Life Sciences?courseLevel=CEGEP&courseCode=BBB001')
								.then(response => {
								})

							AXIOS.post('/course/create/Classics 2?courseLevel=CEGEP&courseCode=AAA333')
								.then(response => {
								})

							AXIOS.post('/course/create/Classics 1 ?courseLevel=CEGEP&courseCode=AAA334')
								.then(response => {
								})

							AXIOS.post('/tutor/create/rutherford@mcgill.ca?password=334&name=ernest&tutorId=335&hourlyRate=17')
								.then(response => {

									AXIOS.post('availability/create/4?date=2019-01-01&start=013:00:00&end=18:00:00&tutEmail=rutherford@mcgill.ca')
										.then(response => {

										})

									AXIOS.post('/tutors/add/course/Electromagnetic Waves?					tutEmail=rutherford@mcgill.ca')
										.then(response => {
										})

									AXIOS.post('/tutors/add/course/Economics of the Env.?					tutEmail=rutherford@mcgill.ca')
										.then(response => {
										})

								})

							AXIOS.post('/tutor/create/trottier@mcgill.ca?password=334&name=lorne&tutorId=735&hourlyRate=7')
								.then(response => {

									AXIOS.post('availability/create/4?date=2019-01-01&start=013:00:00&end=18:00:00&tutEmail=trottier@mcgill.ca')
										.then(response => {

										})

									AXIOS.post('/tutors/add/course/Electromagnetic Waves?					tutEmail=trottier@mcgill.ca')
										.then(response => {
										})

									AXIOS.post('/tutors/add/course/Economics of the Env.?					tutEmail=trottier@mcgill.ca')
										.then(response => {
										})

									AXIOS.post('/tutors/add/course/Introduction to Life Sciences?				tutEmail=trottier@mcgill.ca')
										.then(response => {
										})

								})

							AXIOS.post('/companyManager/create/marawan.kanaan@mcgill.ca?password=321&name=Marwan Kanaan&companyManagerId=1')
								.then(response => {
									alert("Success creating all!");
								})
						})
				})

		}
	}

}