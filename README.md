# FlowerDesk Console

FlowerDesk is a robust, Java-based console application designed to manage IT helpdesk tickets. Built with a strict N-Tier Model-View-Controller (MVC) architecture, the application provides separate, secure workflows for standard Users and IT Agents to seamlessly manage support requests.
🌟 Key Features

    Role-Based Access: Distinct login and dashboard experiences for standard Users and IT Agents.  

    User Portal: Allows users to sign up, log in, raise new IT support tickets, and check the status of their requests.

    IT Agent Portal: Allows support agents to view incoming tickets and resolve them.

    Input Validation: Built-in utility classes to ensure data integrity and proper formatting before processing.

    Simulated Persistence: Utilizes a centralized Repository layer to act as an in-memory database for seamless data flow.

🏗️ Architecture & Design

This application strictly adheres to an expanded 5-Layer MVC architectural pattern to ensure clean separation of concerns, scalability, and maintainability:

    View Layer (com.flowerdeskconsole.view): Handles all console I/O, routing inputs from the user to the controllers and displaying notifications.  

    Controller Layer (com.flowerdeskconsole.controller): Acts as the traffic cop, receiving user input from the View and routing it to the appropriate Service logic.  

    Service Layer (com.flowerdeskconsole.service): Contains the core business logic and rules of the application (e.g., UserService, AgentService).  

    Model/DAO Layer (com.flowerdeskconsole.model): Contains the Data Objects (User, Ticket) and Data Access Objects (UserDAO, TicketDAO) responsible for data manipulation.  

    Repository Layer (com.flowerdeskconsole.repository): Manages the central data storage (FlowerDeskDB).  

Additionally, a Utils Layer (com.flowerdeskconsole.utils) abstracts away repetitive tasks like InputGetter, Validation, and Notification to keep the core layers lean.  
📂 Project Structure
Plaintext

src/
└── com.flowerdeskconsole/
    ├── FlowerDeskApp.java           # Main application entry point
    ├── controller/
    │   ├── ITAgentHomePageController.java
    │   ├── LoginController.java
    │   ├── SignUpController.java
    │   └── UserHomePageController.java
    ├── model/
    │   ├── Ticket.java              # Data Object
    │   ├── TicketDAO.java           # Data Access Object
    │   ├── User.java                # Data Object
    │   └── UserDAO.java             # Data Access Object
    ├── repository/
    │   └── FlowerDeskDB.java        # Simulated Database
    ├── service/
    │   ├── AgentService.java
    │   ├── UserService.java
    │   └── UserSignUpAndLoginService.java
    ├── utils/
    │   ├── AppInfo.java
    │   ├── InputGetter.java
    │   ├── Notification.java
    │   └── Validation.java
    └── view/
        ├── ITAgentHomePageView.java
        ├── LoginView.java
        ├── SignUpView.java
        └── UserHomePageView.java

🚀 Getting Started
Prerequisites

    Java Development Kit (JDK) 8 or higher installed on your system.

    An IDE (IntelliJ IDEA, Eclipse, VS Code) or command-line terminal.

Installation & Execution

    Clone or download this repository.

    Open the project in your preferred Java IDE.

    Ensure your src folder is marked as the Sources Root.

    Locate FlowerDeskApp.java inside src/com/flowerdeskconsole/.

    Run the main method to launch the console application.

🔮 Future Enhancements

    Database Integration: Replace the in-memory FlowerDeskDB with a fully relational MySQL database using JDBC.

    DAO/Service Interfaces: Implement interface-driven design (e.g., UserDAO interface with UserDAOImpl class) for greater architectural flexibility.

    Password Hashing: Integrate security measures for storing user passwords safely.
