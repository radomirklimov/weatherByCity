This is a website that fetches data from a weather API, processes it to work correctly, and displays it on a simple website.

getting data from Weather API
I connect to the API and fetch only the data I want to display on my website. After that, I convert it from JSON format to a restTemplate for further use.

Output to the server
By using a service and RestController, I output the weather data on the server.

Front-end
Now, we can get the city input from the user and, with the help of JavaScript, send the request to our Spring Boot server. After receiving the response, we simply build the HTML and CSS for a user-friendly interface.
