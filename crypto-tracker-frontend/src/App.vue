<template>
  <div id="app">
    <CryptoSearch />
  </div>
</template>

<script>
import CryptoSearch from './components/CryptoSearch.vue'

export default {
  name: 'App',
  components: {
    CryptoSearch
  }
}
</script>

<style>
body {
    font-size: 20px;
    font-weight: bold;
    color: white;;
}
html, body {
  height: 100%;
  margin: 0;
  padding: 0;
  background-image: url(~@/assets/shubham-dhage-gC_aoAjQl2Q-unsplash.jpg);
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  
  margin-top: 60px;
}
</style>
