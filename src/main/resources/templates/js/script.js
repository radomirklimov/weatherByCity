var map 

//fetchs API
async function fetchWeatherData(city) {
    try{
        const response = await fetch('http://localhost:8080/' + city)
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const data = await response.json();
        
        displayWeather(data);
       
    }catch (error) {
        document.getElementById('naming').textContent = 'invalid city';
        document.getElementById('value').textContent = 'invalid city';
        document.getElementById('mainWeather').textContent = 'invalid city';
        document.getElementById('weatherDescription').textContent = 'invalid city';
        document.getElementById("sunRise").innerHTML = ""
        document.getElementById("sunSet").innerHTML = ""
        document.getElementById("map").innerHTML = ""
        return;
    }

}

//displays data
function displayWeather(data){

   
     const namingDiv = document.getElementById('naming');
     namingDiv.innerHTML = `
     ${data.name}, ${data.sys.country}<br><br>
     feels like:<br><br>
     pressure:<br><br>
     wind:
     `;

     const valueDiv = document.getElementById('value');
     valueDiv.innerHTML = `
     ${data.main.temp} °C<br><br>
     ${data.main.feels_like} °C<br><br>
     ${data.main.pressure} hPa<br><br>
     ${data.wind.speed} m/s
     `;

     const mainWeatherDiv = document.getElementById('mainWeather');
     mainWeatherDiv.innerHTML = `
     ${data.weather[0].main}
     `;

     const weatherDescriptionDiv = document.getElementById('weatherDescription');
     weatherDescriptionDiv.innerHTML = `
     ${data.weather[0].description}<br><br>
     `;

     const weatherIcon = document.createElement("img")
     const iconUrl = `https://openweathermap.org/img/wn/${data.weather[0].icon}@2x.png`;
     weatherIcon.src = iconUrl;
     weatherIcon.alt = 'Weather Icon';
     weatherDescriptionDiv.appendChild(weatherIcon)

     const sunRiseDiv = document.getElementById('sunRise');
     sunRiseDiv.innerHTML = `Sunrise: ${new Date(data.sys.sunrise * 1000).toLocaleTimeString()}`;


     const sunSetDiv = document.getElementById('sunSet');
     sunSetDiv.innerHTML = `Sunset: ${new Date(data.sys.sunset * 1000).toLocaleTimeString()}`;

    //map
    if (map != undefined){
        map.remove();
    }

    map = L.map('map').setView([data.coord.lat, data.coord.lon], 13);

    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    }).addTo(map);

    var marker = L.marker([data.coord.lat, data.coord.lon]).addTo(map);

};



//starts the program 
document.getElementById("inputCity").addEventListener("keydown", function(event) {
        if (event.key === "Enter") {
            const input = document.getElementById("inputCity");
            const city = input.value;

            if (city === ""){
                return;
            }

            fetchWeatherData(city)
        }
    }
);


