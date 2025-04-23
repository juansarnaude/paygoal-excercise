# Product Controller API Documentation

## Base URL
All endpoints are accessible under the base path: `/api/products`

## Endpoints

### 1. Create a Product
- **Method**: `POST`
- **Path**: `/api/products`
- **Description**: Creates a new product.
- **Request Body**: `ProductDTO`
    - `name`: String, required, non-empty
    - `description`: String, required, non-empty
    - `price`: Double, required, must be >= 0
    - `quantity`: Integer, required, must be >= 0
- **Responses**:
    - `201 Created`: Product created successfully, returns the created `Product`.
    - `400 Bad Request`: Invalid input data.
    - `409 Conflict`: Data integrity violation (e.g., duplicate product name).
- **Example Request**:
  ```json
  {
    "name": "Laptop",
    "description": "High-performance laptop",
    "price": 999.99,
    "quantity": 10
  }
  ```
- **Example Response (201)**:
  ```json
  {
    "id": 1,
    "name": "Laptop",
    "description": "High-performance laptop",
    "price": 999.99,
    "quantity": 10
  }
  ```

### 2. Update a Product
- **Method**: `PUT`
- **Path**: `/api/products/{id}`
- **Description**: Updates an existing product by ID.
- **Path Parameter**:
    - `id`: Long, required, the ID of the product to update.
- **Request Body**: `ProductDTO`
- **Responses**:
    - `200 OK`: Product updated successfully, returns the updated `Product`.
    - `404 Not Found`: Product with the specified ID does not exist.
    - `409 Conflict`: Data integrity violation.
- **Example Request**:
  ```json
  {
    "name": "Laptop Pro",
    "description": "Updated high-performance laptop",
    "price": 1299.99,
    "quantity": 15
  }
  ```
- **Example Response (200)**:
  ```json
  {
    "id": 1,
    "name": "Laptop Pro",
    "description": "Updated high-performance laptop",
    "price": 1299.99,
    "quantity": 15
  }
  ```

### 3. Get a Product by ID
- **Method**: `GET`
- **Path**: `/api/products/{id}`
- **Description**: Retrieves a product by its ID.
- **Path Parameter**:
    - `id`: Long, required, the ID of the product.
- **Responses**:
    - `200 OK`: Product found, returns the `Product`.
    - `404 Not Found`: Product with the specified ID does not exist.
- **Example Response (200)**:
  ```json
  {
    "id": 1,
    "name": "Laptop",
    "description": "High-performance laptop",
    "price": 999.99,
    "quantity": 10
  }
  ```

### 4. Get All Products
- **Method**: `GET`
- **Path**: `/api/products`
- **Description**: Retrieves all products, with optional sorting by price.
- **Query Parameters**:
    - `sortByPrice`: Boolean, optional, default `false`. If `true`, sorts products by price.
    - `asc`: Boolean, optional, default `false`. If `true`, sorts in ascending order; otherwise, descending.
- **Responses**:
    - `200 OK`: Returns a list of `Product` objects.
- **Example Request**: `/api/products?sortByPrice=true&asc=true`
- **Example Response (200)**:
  ```json
  [
    {
      "id": 1,
      "name": "Mouse",
      "description": "Wireless mouse",
      "price": 29.99,
      "quantity": 50
    },
    {
      "id": 2,
      "name": "Laptop",
      "description": "High-performance laptop",
      "price": 999.99,
      "quantity": 10
    }
  ]
  ```

### 5. Search Product by Name
- **Method**: `GET`
- **Path**: `/api/products/search`
- **Description**: Retrieves a product by its name.
- **Query Parameter**:
    - `name`: String, required, the name of the product to search for.
- **Responses**:
    - `200 OK`: Product found, returns the `Product`.
    - `404 Not Found`: Product with the specified name does not exist.
- **Example Request**: `/api/products/search?name=Laptop`
- **Example Response (200)**:
  ```json
  {
    "id": 1,
    "name": "Laptop",
    "description": "High-performance laptop",
    "price": 999.99,
    "quantity": 10
  }
  ```

### 6. Delete a Product
- **Method**: `DELETE`
- **Path**: `/api/products/{id}`
- **Description**: Deletes a product by its ID.
- **Path Parameter**:
    - `id`: Long, required, the ID of the product to delete.
- **Responses**:
    - `204 No Content`: Product deleted successfully.
    - `404 Not Found`: Product with the specified ID does not exist.
- **Example Request**: `/api/products/1`
- **Example Response (204)**: (No content)

## ProductDTO
- `name`: Must be non-empty, also it must be unique.
- `description`: Must be non-empty.
- `price`: Must be a non-null double >= 0.
- `quantity`: Must be a non-null integer >= 0.