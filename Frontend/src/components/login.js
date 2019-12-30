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




export default {
  data() 
  {
    return {
      student: {
        type: Object
      },
      email: "",
      password: "",
      name: "",
      id: "",
      error: "",
    };
  },

  methods: {
    //Dummy function to store variables into the database so we can login.
    dummy: function() {
      AXIOS.post('/student/create/ali@gmail.com?password=123&name=ali&studentId=112')
            .then(response => {
              alert("Success!");
            })
    },

    //Send GET request to find student assosiated with the email. If the password matches 
    //then the local variables are assigned to the browser, otherwise prints out error.
    login: function(email, password) {
      if(email == "" || password == "")
      {
        document.getElementById("title1").innerText = "Please enter a valid user email and password!";
      }
      else{
      AXIOS.get(`/students/` + email)
        .then(response => {
          this.student = response.data;
          if (this.student.password === password) {
            this.goToStudentPage();
            localStorage.setItem("isLoggedIn", "true");
            localStorage.setItem("studentEmail", this.student.email);
            localStorage.setItem("studentName", this.student.name);
            localStorage.setItem("studentId", this.student.id);
            this.$loggedInEvent.$emit("setLoggedInState", true);
          } else {
            document.getElementById("title1").innerText = "Invalid user email or password";
          }
        })

        .catch(e => {
          console.log(e.message);
          document.getElementById("title1").innerText =
           "Invalid user email or password";
        });
      }
    },

    //Function to go to the student profile page
      goToStudentPage: function() {
      Router.push({
        path: "/studentpage/",
        name: "studentpage"
      });
    }
  }
}