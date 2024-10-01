# Bank Listing Project

This project exposes an endpoint that allows for the listing of banks. Transaction endpoints require additional permissions.

## Technologies Used

- **Framework:** Spring
- **Dependency Manager:** Maven
- **Language:** Java 8
- **Server:** Jetty (embedded server)

## Security System

The application uses a **Basic Auth** security system. The pre-registered access credentials are:

- **Username:** `user`
- **Password:** `password`

## Endpoint

The path for the bank listing endpoint is: /api/bank/banks

## Port of Execution

The application runs on port **8080**.