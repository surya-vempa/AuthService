### Problem statement

Auth service is responsible for authentication and authorization of incoming requests from the Templatisation service and API Gateway.

### ✨ Functional Requirements

- User should be able to Sign up and login
- User would not be asked to login everytime whenever he/she opens the app
- Store encrypted passwords in the database
- Access tokens and refresh tokens should be allotted
- Tokens should be passed over HTTPs requests
- Event published to userService should be recoverable and fault tolerant

### ✨ Non Functional requirements

- Authentication should not take too much time to avoid app open lag
- Database should be designed in such a way to avoid the complex and LRQ

![Image](https://github.com/user-attachments/assets/2d106148-0217-4895-a01b-7fc4853b36fa)
