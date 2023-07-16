<template>
    <div>
        <input class="search-input" v-model="searchTerm" type="text" placeholder="Search a cryptocurrency">
        <button @click="getCryptoData">Search</button>
        
        <div v-if="coinData && historicalData">
            <h2>{{ coinData.name }} ({{ coinData.symbol }})</h2>
            <p>Current Price: ${{ coinData.market_data.current_price.usd }}</p>
            <h3>Market Data</h3>
            <p>Market Cap: ${{ coinData.market_data.market_cap.usd }}</p>
            <p>24h Trading Volume: ${{ coinData.market_data.total_volume.usd }}</p>
            <h3>Historical Data</h3>
            <p>Price 30 days ago: ${{ price30DaysAgo }}</p>
            <p>Price one year ago: ${{ price365DaysAgo }}</p>
            <p>All-Time High: ${{ coinData.market_data.ath.usd }}</p>
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
        historicalData: null,
        price30DaysAgo: null,
        price365DaysAgo: null,
        };
    },
    methods: {
        async getCryptoData() {
            try {
                const lowercaseSearchTerm = this.searchTerm.toLowerCase();

                const response = await axios.get(`https://api.coingecko.com/api/v3/coins/${lowercaseSearchTerm}`);
                this.coinData = response.data;

                const historicalResponse = await axios.get(`https://api.coingecko.com/api/v3/coins/${lowercaseSearchTerm}/market_chart`, {
                    params: {
                        vs_currency: 'usd',
                        days: 365,
                    },
                });
                this.historicalData = historicalResponse.data;

                const oneDayInMilliseconds = 24 * 60 * 60 * 1000;
                const now = Date.now();

                const prices30DaysAgo = this.historicalData.prices.filter(([time]) => now - time <= 30 * oneDayInMilliseconds);
                this.price30DaysAgo = prices30DaysAgo[0][1];

                const prices365DaysAgo = this.historicalData.prices.filter(([time]) => now - time <= 365 * oneDayInMilliseconds);
                this.price365DaysAgo = prices365DaysAgo[0][1];

            } catch (error) {
                console.error(error);
            }
        },
    },
};
</script>

<style scoped>

.search-input {
    width: 150px;
}
</style>
