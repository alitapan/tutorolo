<template>
  <div id="contact">
   <nav>
      <ul class="navigation-elements">
        <li>
          <a class="myButton" href="/#/">Home</a>
        </li>
        <li>
          <a class="myButton" href="/#/contactPage">Contact</a>
        </li>
        <li>
          <a class="myButton" href="/#/loginPage">Login</a>
        </li>
      </ul>
    </nav>
    <body>  

      <div id="content" style="padding:70px; border: 2px solid #000000;">
        <div>
          <p> Company Manager: Marwan Kanaan - marwan.kanaan@mcgill.ca </p>
          <p> Address: 3480 Rue University, Montréal, QC H3A 2K6 </p>
          <p> Development Team: Group 22 - https://github.com/McGill-ECSE321-Fall2019/project-group-22 </p>
          <p> Please contact if any bugs are found </p>
        </div>
      </div>
    </body> 
  </div>
</template>

<style> 
  ul {list-style-type: none;margin: 1;padding: 1;}
  li {float: left;display: inline; margin:13px;}
  li a {display: block;color: black;text-align: center;padding: 16px 16px;text-decoration: none;}
  li a:hover{background-color: rgba(0, 0, 0, 1); border-left: 1px solid black; border-right: 1px solid black;color:white;}
  .navigation-elements a,
.navigation-elements input[type="text"] {
  float: none;
  display: block;
  text-align: left;
  width: 100%;
  margin: 2px;
  padding: 14px;
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
  .content{position: relative; font-family: helvetica; background-color:#FBDBC0; color:#FBDBC0}
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
    
</style>