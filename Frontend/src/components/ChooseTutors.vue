<template>
<div class="card-container">
<nav>
      <ul style=" font-family: helvetica;
  position: absolute;
  background-color: #55608f;
  border-bottom: 4px solid black;
  width: 100%;
  top: 0px;
  z-index: 40;
  left: 0;">
        <li>
	        	<a class="myButton" href="/#/studentpage">Student Hub</a>
	      	</li>
          <li>
          <a class="myButton" href="/#/">Sign Out</a>
          </li>
      </ul>
    </nav>
    <div class="body-style">
      <div class="tutors-title">
    Here are all the tutors for {{this.$route.params.course.courseCode}} 
</div>
<div class="all-cards-style">
    <div  v-for="tutor of tutors" :key="tutor.index">
<div class="card card-1">
    <span><b>Name:</b> {{tutor.name}}</span>
    <span><b>Id:</b> {{tutor.id}}</span>
    <span><b>Email Adresss:</b> {{tutor.email}}</span>
    <span><b>Hourly Rate:</b> ${{tutor.hourlyRate}}</span>
    <span><b style="color: green">Availability:</b> <TutorAvailability :email="tutor.email"></TutorAvailability> </span>
    <router-link  to="./confirmationPage" class="booking-style">Book Now</router-link>
</div>
</div>
</div>

    </div>

</div>

</template>

<script>
import TutorAvailability from "@/components/TutorAvailability";
export default {
  name: "ChooseTutors",
  components: {
    TutorAvailability
  },
  data() {
    return {
      tutors: [],
      res: null
    };
  },
  async created() {
    try {
      const res = await axios.get(
        `http://localhost:8080/tutors/courses/` +
          this.$route.params.course.courseCode
      );
      this.tutors = res.data;
    } catch (e) {
      console.error(e);
    }
  },
  methods: {
    bookSession() {
      axios
        .post(`http://localhost:8080/scheduledCourse/create/`, {
          id: 8,
          stuEmail: "a@gmail.com",
          tutEmail: "einstein@mcgill.ca",
          courseName: "Model Based Programming",
          roomNumber: 2,
          start: "01:00:00",
          end: "01:40:00",
          dat: "2019 - 09 - 01"
        })
        .then(response => (this.res = response.data));
    }
  }
};
</script>

<style>
li {
  margin: 10px;
}
.tutors-title {
  text-align: center;
  margin-top: 70px;
  font-size: 50px;
  font-family: "jubilat", serif;
}
.card {
  background: #fff;
  border-radius: 2px;
  height: 350px;
  margin: 1rem;
  width: 350px;
  text-align: left;
  padding: 10px;
}
.card-1 {
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
  transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);
  background-color: #a9c4ff;
}
.card-1:hover {
  box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.22);
  transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);
}
.booking-style {
  border-radius: 5px;
  margin-top: 10px;
  background-color: rgb(177, 140, 140);
  color: white;
  text-align: center;
}
.all-cards-style {
  display: flex;
  flex-wrap: wrap;
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
  width: 100%;
  top: 0px;
  z-index: 40;
  left: 0;
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

.body-style {
  background-color: white;
  border-top: 2px solid black;
}
</style>