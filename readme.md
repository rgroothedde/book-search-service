# Book search service
This application is created as a demo use case using Ktor en Kotlin.
It exposes an endpoint for searching books, and uses the Google Books API.

## Running the application
Use the gradle run task for starting the application: `./gradlew run`
The application will be available on `localhost:8080/boeken` 

### Search parameters
* `zoektekst` - Required. Search for books that contain this text string. For example: [http://localhost:8080/boeken?zoektekst=kotlin+testing]
* `taal` - Optional. Only search for books with this language, specified by the two-letter ISO-639-1 code, 
such as "en" or "fr". For example  [http://localhost:8080/boeken?zoektekst=kotlin+testing&taal=nl]

## Todo
* Write integration tests using the Mock Engine (see [https://ktor.io/docs/http-client-testing.html] )
* Serve openAPI documentation with Swagger UI included

