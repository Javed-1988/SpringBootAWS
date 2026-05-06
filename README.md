# SpringBootAWS

A Spring Boot application demonstrating integration with AWS, including deployment on Elastic Beanstalk and CI/CD pipelines.

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

## Running the Application

1. Clone the repository.
2. Navigate to the project directory.
3. Run the following command to start the application:

   ```bash
   mvn spring-boot:run
   ```

The application will start on port 8080 by default.

## API Endpoints

- `GET /` - Returns a welcome message.
- `GET /add/{id}` - Returns the result of multiplying the provided ID by 2.
- `GET /name?name={name}` - Returns a personalized welcome message for the provided name.

## Technologies Used

- Spring Boot
- AWS (Elastic Beanstalk, CI/CD Pipeline)
- Maven

## Deployment

This application is configured for deployment on AWS Elastic Beanstalk with a CI/CD pipeline using AWS CodePipeline and CodeBuild (refer to `buildspec.yml` for build specifications).
