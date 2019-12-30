<template>

<div>
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
    <div class="body-style">
      <div class="welcome-message">Search and choose your courses</div>
  <div class="search-wrapper">
  <form>
  <input type="text" v-model="search" name="focus" required class="search-box" placeholder="Enter a class name" />
  </form>
</div>

<div class="level-style">UNIVERSITY LEVEL</div>
<div class="row" style="margin-top: 50px;margin-left:15px; margin-right: 15px;display: flex; flex-wrap: wrap;">
    <div v-for=" course of univeristyLevel" :key="course.index">
        <router-link :to="{ name: 'ChooseTutors', params: { course} }" class="course-style router-link-style col-lg-2 col-md-3 col-sm-6 mb-2">{{course.name}}</router-link>
    </div>
  
</div>

<div class="level-style">CEGEP LEVEL</div>
<div class="row" style="margin-top: 50px;margin-left:15px; margin-right: 15px;display: flex; flex-wrap: wrap;">
    <div v-for=" course of cegepLevel" :key="course.index">
        <router-link :to="{ name: 'ChooseTutors', params: { course} }" class="course-style router-link-style col-lg-2 col-md-3 col-sm-6 mb-2">{{course.name}}</router-link>
    </div>
  
</div>

<div class="level-style">HIGH SCHOOL LEVEL</div>
<div class="row" style="margin-top: 50px;margin-left:15px; margin-right: 15px;display: flex; flex-wrap: wrap;">
    <div v-for=" course of highSchoolLevel" :key="course.index">
        <router-link :to="{ name: 'ChooseTutors', params: { course} }" class="course-style router-link-style col-lg-2 col-md-3 col-sm-6 mb-2">{{course.name}}</router-link>
    </div>
  
</div>

    </div>
   
</div>
  
</template>

<script>
import _ from "lodash";
export default {
  name: "Courses",
  data() {
    return {
      courses: [],
      search: ""
    };
  },
  async created() {
    try {
      const res = await axios.get(`http://localhost:8080/courses`);
      this.courses = res.data;
    } catch (e) {
      console.error(e);
    }
  },
  computed: {
    univeristyLevel: function() {
      return _.filter(this.filteredCourses, function(u) {
        return u.courseLevel == "University";
      });
    },
    cegepLevel: function() {
      return _.filter(this.filteredCourses, function(u) {
        return u.courseLevel == "CEGEP";
      });
    },
    highSchoolLevel: function() {
      return _.filter(this.filteredCourses, function(u) {
        return u.courseLevel == "HIGHSCHOOL";
      });
    },
    filteredCourses: function() {
      return this.courses.filter(course => {
        return course.name.toLowerCase().includes(this.search.toLowerCase());
      });
    }
  },
  methods: {}
};
</script>

<style scoped>
.welcome-message {
  text-align: center;
  margin-top: 10px;
  font-size: 50px;
  font-family: "jubilat", serif;
}
.search-box,
.close-icon,
.search-wrapper {
  position: relative;
  padding: 10px;
}
.search-wrapper {
  width: 500px;
  margin: auto;
  margin-top: 50px;
}
.search-box {
  width: 90%;
  border: 3px solid #ccc;
  outline: 0;
  border-radius: 7px;
  text-align: center;
}
.search-box:not(:valid) ~ .close-icon {
  display: none;
}
.request-section {
  /* position: fixed; */
  bottom: 0;
  width: 100%;
  margin-bottom: 10px;
}
.request-button {
  background-color: rgb(177, 140, 140);
  color: white;
  margin-left: 45vw;
  border-radius: 5px;
}
.course-style {
  padding: 10px;
  background-color: #b18c8c;
  margin: 2px;
  border-radius: 5px;
  color: white;
}
.course-style:hover {
  box-shadow: 0 3px 4px rgba(0, 0, 0, 0.25), 0 4px 4px rgba(0, 0, 0, 0.22);
}
.router-link-style {
  color: white;
}
.level-style {
  margin-bottom: -10px;
  font-weight: bold;
  text-align: center;
  margin-top: 10px;
}
a:hover,
a:visited,
a:link,
a:active {
  text-decoration: none;
}

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
  margin: 0;
  padding: 14px;
}

.content {
  position: relative;
  font-family: helvetica;
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
.body-style {
  background-color: white;
  border-top: 2px solid black;
}
</style>