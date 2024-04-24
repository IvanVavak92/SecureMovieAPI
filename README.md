# Movie API Project

This project is a simple REST API that provides endpoints for fetching movie data from The Movie Database (TMDb) API. JWT token authentication is implemented for secure access to the API endpoints.

## Features

- Fetch popular movies from TMDb API.
- Fetch top-rated movies from TMDb API.
- Fetch trending movies and TV shows from TMDb API.
- Secure access to endpoints using JWT token authentication.

## Technologies Used

- Spring Boot
- Spring Data JPA
- Spring Web
- Jackson (for JSON processing)
- Hibernate (as JPA provider)
- MySQL (or your preferred database)
- JSON Web Token (JWT) for authentication

  ### Endpoints

- **GET /getMovies**: Retrieves a list of popular movies from TMDb API.
- **GET /getTopRatedMovies**: Retrieves a list of top-rated movies from TMDb API.
- **GET /trending**: Retrieves trending movies and TV shows from TMDb API.
