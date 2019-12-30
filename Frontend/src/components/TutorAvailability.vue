<template>
<div>
  
       <div v-for="availability of availabilities" :key="availability.index">
         <input @change="SelectedInformation" :name="availability.index" type="radio" :value="availability" v-model="selectedAvailabilities">
         <label>{{availability.availableDate}}: from {{availability.startTime}} to {{availability.endTime}} </label>          
    </div> 
               	<a style="color: red" href="/#/courses"><b>Choose a Different Course!</b></a>

</div>
  
</template>

<script src="./tutoravalibility.js"></script>

<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}
li {
  float: left;
  display: inline;
  margin: 0;
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
.navigation-elements {
  font-family: helvetica;
  position: absolute;
  background-color: #fbdbc0;
  border-bottom: 4px solid black;
  border-top: 4px solid #fbdbc0;
  width: 100%;
  top: 0px;
  z-index: 40;
  left: 0;
}
.content {
  position: relative;
  font-family: helvetica;
}
</style>