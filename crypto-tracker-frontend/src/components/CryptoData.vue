<template>
    <div>
        <input type="text" v-model="cryptoName" placeholder="Enter cryptocurrency name">
        <button @click="fetchCryptoData">Search</button>
    <div v-if="cryptoData">
        <h1>{{ cryptoData.name }}</h1>
        <p>Current Price: {{ cryptoData.current_price }}</p>
        <p>Market Cap: {{ cryptoData.market_cap }}</p>
        <p>Total Volume: {{ cryptoData.total_volume }}</p>
    </div>
    </div>
</template>

<script>
export default {
    name: 'CryptoData',
    data() {
        return {
            cryptoName: '',
            cryptoData: null,
        };
    },
    methods: {
        async fetchCryptoData() {
           if(this.cryptoName.trim() != '') {
            const response = await fetch('http://localhost:8080/crypto/' + this.cryptoName);
            this.cryptoData = await response.json();
           }
      }
    }
};

</script>