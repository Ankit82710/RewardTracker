# RewardTracker
RestApi
## Overview

This application calculates reward points for customers based on their transactions. Customers earn:
- 2 points for every dollar spent over $100
- 1 point for every dollar spent between $50 and $100

The application exposes RESTful APIs to calculate monthly and total points for customers.

## Structure

- **Controller**: Exposes API endpoints for transaction-related operations.
- **Service**: Business logic to calculate reward points.
- **Model**: Entity classes like `Transaction` representing the database structure.
- **Repository**: Database interaction layer.

## How to Run

1. Clone this repository.
2. Use `mvn spring-boot:run` to start the application.
3. Access the API at `http://localhost:8080`.

## API Endpoints

- `POST /api/transactions/monthly-points`: Accepts a list of transactions and returns monthly points for each customer.
- `POST /api/transactions/total-points`: Accepts a list of transactions and returns total points for all customers.

  -http://localhost:8080/api/transactions/monthly-points  post

[{
        "customerId": 1,
        "amountSpent": 120,
        "transactionDate": "2025-02-23"
    },
    {
        "customerId": 1,
        "amountSpent": 80,
        "transactionDate": "2025-02-24"
 }]
 
 Response
 
 {
    "1-FEBRUARY": 120
}

http://localhost:8080/api/transactions/total-points post

response
20

