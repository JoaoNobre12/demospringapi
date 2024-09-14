# Demo Spring API

This is a demo project for an API built with Spring Boot.

## Technologies Used

- Java
- Spring Boot
- Maven

## Project Structure

The project is organized as follows:

- `src/main/java/com/casa/demospring/demo/controller`: Contains the API controllers.
  - `OrderController.java`: Controller for order-related operations.
  - `ProductController.java`: Controller for product-related operations.
  - `UserController.java`: Controller for user-related operations.
- `src/main/java/com/casa/demospring/demo/entities`: Contains the project entities.
- `src/main/java/com/casa/demospring/demo/services`: Contains the project services.

## Endpoints

### OrderController

- `GET /orders`: Returns all orders.
- `GET /orders/{id}`: Returns a specific order by ID.

### ProductController

- `GET /products`: Returns all products.
- `GET /products/{id}`: Returns a specific product by ID.

### UserController

- `GET /users`: Returns all users.
- `GET /users/{id}`: Returns a specific user by ID.
- `POST /users`: Inserts a new user.
- `DELETE /users/{id}`: Deletes a user by ID.
- `PUT /users/{id}`: Updates a user by ID.

## How to Run

1. Clone the repository:
    ```sh
    git clone <REPOSITORY_URL>
    ```
2. Navigate to the project directory:
    ```sh
    cd demospringapi
    ```
3. Compile and run the project using Maven:
    ```sh
    mvn spring-boot:run
    ```

## Contribution

Feel free to contribute to the project. To do so, follow these steps:

1. Fork the repository.
2. Create a new branch:
    ```sh
    git checkout -b my-new-feature
    ```
3. Make the desired changes and commit:
    ```sh
    git commit -m "Add new feature"
    ```
4. Push the changes to the remote repository:
    ```sh
    git push origin my-new-feature
    ```
5. Open a Pull Request.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.