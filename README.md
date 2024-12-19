# E-Commerce Product Management System

## Overview
A robust Spring Boot-based E-Commerce Product Management System that provides advanced product management capabilities, efficient categorization, and seamless data handling using both SQL and NoSQL databases. The system implements binary tree structures for optimized product categorization and retrieval.

## Features
- Advanced product and category management
- Multi-profile support (development, production)
- Monitoring capabilities with Spring Actuators
- Efficient request handling with Dispatcher Servlet
- Hybrid database architecture (JPA + MongoDB)
- Binary tree implementation for product categorization
- RESTful API endpoints for all operations
- Product review system with MongoDB integration

## Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Data MongoDB
- Spring Boot Actuator
- Maven/Gradle

## API Endpoints

### Category Management
```
GET    /api/categories         - Get all categories
GET    /api/categories/{id}    - Get category by ID
GET    /api/categories/name/{name} - Get category by name
POST   /api/categories         - Create new category
PUT    /api/categories/{id}    - Update existing category
DELETE /api/categories/{id}    - Delete category
```

### Product Management
```
GET    /api/products          - Get all products
GET    /api/products/{id}     - Get product by ID
GET    /api/products/category/{categoryId} - Get products by category
POST   /api/products          - Create new product
PUT    /api/products/{id}     - Update existing product
DELETE /api/products/{id}     - Delete product
```

### Product Reviews
```
POST   /api/products/{productId}/reviews    - Add product review
GET    /api/products/{productId}/reviews    - Get reviews for product
PUT    /api/products/reviews/{reviewId}     - Update review
DELETE /api/products/reviews/{reviewId}     - Delete review
```

## Setup Instructions

1. Clone the repository:
```bash
git clone https://github.com/mawule-gabriel/ProductManagementSys.git
cd product-management-sys
```

2. Configure database properties in `application.properties`:
```properties
# SQL Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/product_management
spring.datasource.username=your_username
spring.datasource.password=your_password

# MongoDB Configuration
spring.data.mongodb.uri=mongodb://localhost:27017/product_reviews
```

3. Build the project:
```bash
./mvnw clean install
```

4. Run the application:
```bash
./mvnw spring-boot:run
```



## Key Features Implementation

### Profile Management
- Development and production profiles with separate configurations
- Environment-specific database configurations
- Custom logging levels per profile

### Binary Tree Implementation
- Efficient product categorization using binary tree structure
- Optimized search and retrieval operations
- Integrated with standard database operations

### Data Management
- JPA for relational data (Products, Categories)
- MongoDB for document storage (Product Reviews)
- Custom query implementations
- Pagination and sorting support

## Monitoring and Management

The application includes Spring Boot Actuator endpoints for monitoring:
```
/actuator/health    - System health information
/actuator/metrics   - Application metrics
/actuator/info      - Application information
```

## Testing

Run the tests using:
```bash
./mvnw test
```

## Contributing
1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments
- Spring Boot Documentation
- MongoDB Documentation
- Binary Tree Implementation Guidelines
