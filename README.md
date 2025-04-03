# Portfolio API - Automated Testing with CI/CD

Hey there! Welcome to **PortfolioAPI**—a little Spring Boot project I put together to manage portfolio items (whether stocks, projects, or anything else you like). But this isn't just about building an API—it's about making sure it actually works! That’s why I’ve packed in automated testing using **JUnit, Mockito, and GitHub Actions** to keep everything running smoothly.

So, let’s jump in! 🚀

---

## 🚀 What’s This About?
This is a simple **REST API** that lets you:
- **Add** new portfolio items.
- **Fetch** an item by ID.
- **List** all portfolio items.

But the real magic? **Automated testing & CI/CD!** Every push runs through tests to ensure nothing breaks, and with GitHub Actions, we’re keeping things streamlined.

### ✨ Features
- **POST /api/portfolio** → Add an item (name, description, value).
- **GET /api/portfolio/{id}** → Retrieve a specific item.
- **GET /api/portfolio** → View all portfolio items.
- **Unit & Integration tests** to ensure the API works.
- **CI/CD pipeline** for automated testing on every push/pull request.

---

## 🛠️ Getting Started

### 📌 Prerequisites
Before you run this project, make sure you have:
- **Java 21** (latest and greatest!).
- **Maven** (comes with a wrapper, so no worries if you don’t have it installed).
- **Git** (to clone the repo).
- An **IDE** (IntelliJ, Eclipse, or even VS Code if you’re feeling adventurous!).

### 🏃 Running the App Locally
1. **Clone the Repo**
   ```bash
   git clone <your-repo-url>
   cd SoftwareTestAutomation
   ```
2. **Build & Test the Project**
   ```bash
   ./mvnw clean install
   ```
   If you see green checks, you’re all set! ✅
3. **Start the Application**
   ```bash
   ./mvnw spring-boot:run
   ```
   The API will be up and running at `http://localhost:8080`.
4. **Try It Out!** 🎯
   ```bash
   curl -X POST -H "Content-Type: application/json" -d '{"name":"Stock","description":"Tech stock","value":100.0}' http://localhost:8080/api/portfolio
   ```
   
   Fetch an item:
   ```bash
   curl http://localhost:8080/api/portfolio/1
   ```

---

## 📂 Project Structure

```
PortfolioAPI/
├── src/
│   ├── main/
│   │   ├── java/com/testAutomation/
│   │   │   ├── SoftwareTestAutomationApplication.java  # Main entry point
│   │   │   ├── controller/                             # API endpoints
│   │   │   ├── model/                                 # Data classes
│   │   │   └── service/                               # Business logic
│   │   └── resources/
│   │       └── application.properties                # Config
│   └── test/
│       └── java/com/testAutomation/
│           ├── controller/                           # Integration tests
│           └── service/                              # Unit tests
├── .github/workflows/
│   └── ci.yml                                        # CI/CD pipeline
├── pom.xml                                           # Dependencies
└── README.md                                         
```

---

## 🧪 Testing: The Secret Sauce 🛠️
This project comes with **two types of tests** to ensure quality:

✅ **Unit Tests** (`PortfolioServiceTest`) → Test business logic independently.
✅ **Integration Tests** (`PortfolioControllerTest`) → Test full API flows using `MockMvc` and `Mockito`.

### 📢 Running Tests
```bash
./mvnw test
```
If everything is working as expected, you’ll see those sweet green checkmarks! ✅

---

## 🚀 CI/CD: Keeping Things Smooth
This project includes a **GitHub Actions workflow** (`.github/workflows/ci.yml`) that:
- Runs tests on every **push or pull request** to `main`.
- Ensures consistency with **Java 21 and Maven**.
- Prepares the app for deployment (you can add more steps for that!).

---
## Note:
This README is Ai generted.
