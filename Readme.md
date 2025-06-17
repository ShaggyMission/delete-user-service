# 🗑️ User Deletion Service - Shaggy Mission

<div align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Boot" />
  <img src="https://img.shields.io/badge/Spring%20WebFlux-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring WebFlux" />
  <img src="https://img.shields.io/badge/JPA-59666C?style=for-the-badge&logo=hibernate&logoColor=white" alt="JPA" />
  <img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black" alt="Swagger" />
</div>

<div align="center">
  <h3>🚀 Secure User Deletion Microservice for Pet Rescue Platform</h3>
  <p><em>Part of the Shaggy Mission ecosystem - Safely removing inactive users while maintaining data integrity! 🐾</em></p>
</div>

---

## 🌟 Overview

The **User Deletion Service** is a secure user management microservice in the Shaggy Mission platform that handles the complete removal of user accounts. This service ensures safe deletion of user data while maintaining referential integrity across the distributed system by coordinating with the role management service.

## 🎯 What This Service Does

- **Secure User Deletion**: Safely removes user accounts from the platform
- **Distributed Cleanup**: Coordinates with role service to remove user assignments
- **Data Integrity**: Validates user existence before deletion operations
- **Reactive Communication**: Uses WebClient for asynchronous service-to-service communication
- **Error Handling**: Comprehensive error management for failed operations
- **API Documentation**: Swagger integration for endpoint documentation

## 🛠️ Tech Stack

- **Language**: Java with Spring Boot framework
- **Database**: JPA (Java Persistence API) with Hibernate ORM
- **Communication**: Spring WebFlux WebClient for reactive HTTP calls
- **Documentation**: Swagger UI with OpenAPI 3 annotations
- **Architecture**: Microservices with distributed transaction handling
- **Error Handling**: Custom exception management and logging

## 📡 API Endpoints

### User Deletion Endpoint
**`DELETE /users/{id}`**
- Removes user account and associated role assignments
- Validates user existence before deletion
- Coordinates with role management service
- Returns success/error status with descriptive messages

**Path Parameters:**
- `id` (String): Unique identifier of the user to delete

**Response Codes:**
- `200 OK`: User successfully deleted
- `404 NOT FOUND`: User not found in database
- `500 INTERNAL SERVER ERROR`: Deletion operation failed

```json
{
  "message": "User successfully deleted"
}
```

### Error Response Format
```json
{
  "error": "User not found",
  "status": 404
}
```

## 🔧 Core Functionality

### User Deletion Process
The service orchestrates a multi-step deletion process by first validating user existence in the local database, removing the user record from the local database, asynchronously communicating with the role service to remove role assignments, handling both success and error scenarios for the distributed operation, and providing comprehensive logging for operation tracking.

### Distributed System Coordination
The service implements reactive communication patterns using Spring WebFlux WebClient to ensure proper cleanup across microservices. It handles the complexity of distributed transactions by managing local database operations first, then coordinating with external services for complete user removal.

### Error Management
Comprehensive error handling covers scenarios including user not found exceptions, database operation failures, external service communication errors, and network connectivity issues. Each error type returns appropriate HTTP status codes with descriptive messages.

## 🌐 Service Integration

This microservice integrates seamlessly with the Shaggy Mission platform ecosystem by communicating with the role management service at `http://localhost:3001/roles/assign-role/{id}` for role cleanup operations. The reactive architecture ensures non-blocking operations while maintaining data consistency across services.

## 🔒 Security Features

- **Input Validation**: Validates user ID format and existence
- **Safe Deletion**: Prevents orphaned data through coordinated cleanup
- **Error Isolation**: Isolates failures to prevent cascade effects
- **Audit Logging**: Tracks deletion operations for security monitoring
- **Exception Handling**: Secure error responses without sensitive data exposure

## 🗃️ Database Operations

The service performs database operations through JPA repositories, utilizing Spring Data JPA for user existence validation and deletion operations. The UserRepository interface extends JpaRepository to provide standard CRUD operations with additional custom validation logic.

## 📊 Monitoring & Logging

The service includes built-in monitoring through console logging for successful role deletions and error tracking for failed operations. This enables administrators to monitor the health of user deletion processes and quickly identify any issues in the distributed cleanup workflow.

---

<div align="center">
  <p><strong>Built with ❤️ for street dogs and cats everywhere 🐕🐱</strong></p>
  <p><em>Every user deletion helps maintain platform integrity and data security!</em></p>
</div>