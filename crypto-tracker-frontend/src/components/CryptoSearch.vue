<template>
    <div>
        <input v-model="searchTerm" type="text" placeholder="Search a cryptocurrency">
        <button @click="getCryptoData">Search</button>
        
        <div v-if="coinData">
            <h2>{{ coinData.name }} ({{ coinData.symbol }})</h2>
            <p>{{ coinData.description.en }}</p>
            <p>Homepage: <a :href="coinData.links.homepage[0]" target="_blank">{{ coinData.links.homepage[0] }}</a></p>

            <h3>Market Data</h3>
            <p>Market Cap: ${{ coinData.market_data.market_cap.usd }}</p>
            <p>24h Trading Volume: ${{ coinData.market_data.total_volume.usd }}</p>

            <h3>Tickers</h3>
            <div v-for="(ticker, index) in coinData.tickers" :key="index">
                <p>Exchange: {{ ticker.market.name }}</p>
                <p>Trade Volume: ${{ ticker.converted_volume.usd }}</p>
                <p>Trade URL: <a :href="ticker.trade_url" target="_blank">{{ ticker.trade_url }}</a></p>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    data() {
     return {
        searchTerm: '',
        coinData: null,
        };
    },
    methods: {
        async getCryptoData() {
            try {
                const response = await axios.get(`https://api.coingecko.com/api/v3/coins/${this.searchTerm}`);
                this.coinData = response.data;
            } catch (error) {
                console.error(error);
            }
        },
    },
};
</script>
