<template>
  <div id="app">
    <img src="./assets/cover.png" alt="Company Logo Here" width="600">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "app"
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #000000;
  margin-top: 80px;
  background-color: #a9c4ff;
}
</style>
