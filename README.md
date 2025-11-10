# PawPortal: Dog Adoption Management System

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Angular](https://img.shields.io/badge/Angular-20.3.0-red.svg)](https://angular.io/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15+-blue.svg)](https://www.postgresql.org/)

A comprehensive web-based dog adoption management system developed for the Valenzuela City Veterinary Office to streamline the pet adoption process and connect rescued dogs with loving families.

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Prerequisites](#-prerequisites)
- [Local Setup (Manual)](#-local-setup-manual)
  - [Step 1: Clone the Repository](#step-1-clone-the-repository)
  - [Step 2: Database Setup](#step-2-database-setup)
  - [Step 3: Backend Setup](#step-3-backend-setup)
  - [Step 4: Frontend Setup](#step-4-frontend-setup)
- [Docker Setup](#-docker-setup)
- [Alternative Docker Setup (Pre-built Images)](#-alternative-docker-setup-pre-built-images)
- [Testing the Application](#-testing-the-application)
- [Project Documentation](#-project-documentation)
- [Team](#-team)
- [Acknowledgements](#-acknowledgements)

---

## 🎯 Overview

PawPortal is an enterprise-grade dog adoption management platform designed to facilitate the adoption process for rescued dogs in Valenzuela City. The system provides a seamless experience for potential adopters to browse available dogs, submit adoption applications, and communicate with the City Veterinary Office, while giving administrators powerful tools to manage the entire adoption workflow.

**Key Capabilities:**

- Comprehensive dog profile management with detailed information
- Multi-step adoption application process with validation
- User authentication and authorization with JWT
- Admin dashboard for managing dogs, users, and applications
- Contact form system for inquiries
- Audit logging for security and compliance
- Responsive design optimized for all devices
- Email notifications for password resets

---

## ✨ Features

- ✅ **User Management**: Secure registration, login, and profile management
- ✅ **Dog Listings**: Browse available dogs with detailed profiles and photos
- ✅ **Adoption Applications**: Submit and track adoption applications
- ✅ **Admin Dashboard**: Comprehensive management interface for staff
- ✅ **Contact System**: Direct communication channel with the veterinary office
- ✅ **Audit Logging**: Complete activity tracking for security and compliance
- ✅ **Email Integration**: Password reset functionality with email notifications
- ✅ **Responsive Design**: Mobile-friendly interface built with Tailwind CSS
- ✅ **Secure Authentication**: JWT-based authentication with token blacklisting

---

## 🛠 Tech Stack

### Backend

- **Java 17**
- **Spring Boot 3.5.7**
- **Spring Security** (JWT Authentication)
- **Spring Data JPA** (Hibernate)
- **PostgreSQL** (Database)
- **Spring Mail** (Email Integration)
- **Lombok** (Boilerplate reduction)

### Frontend

- **Angular 20.3.0**
- **Tailwind CSS 4.1.16**
- **RxJS** (Reactive programming)
- **Font Awesome** (Icons)

### DevOps

- **Docker & Docker Compose**
- **Maven** (Build tool)
- **npm** (Package manager)

---

## 📦 Prerequisites

Before you begin, ensure you have the following installed:

### Required Software

| Software               | Version                   | Download Link                                                          |
| ---------------------- | ------------------------- | ---------------------------------------------------------------------- |
| **Java JDK**           | 17+                       | [Download](https://www.oracle.com/java/technologies/downloads/#java17) |
| **Node.js**            | 18+                       | [Download](https://nodejs.org/)                                        |
| **PostgreSQL**         | 14+                       | [Download](https://www.postgresql.org/download/)                       |
| **Maven**              | 3.8+                      | Included in IntelliJ IDEA                                              |
| **Git**                | Latest                    | [Download](https://git-scm.com/)                                       |
| **IntelliJ IDEA**      | Community Edition         | [Download](https://www.jetbrains.com/idea/download/)                   |
| **Visual Studio Code** | Latest                    | [Download](https://code.visualstudio.com/)                             |
| **Docker Desktop**     | Latest (for Docker setup) | [Download](https://www.docker.com/products/docker-desktop)             |

### Configuration Requirements

**Gmail App Password** (for email functionality):
- Visit: https://myaccount.google.com/apppasswords
- Generate an app-specific password
- Use this instead of your regular Gmail password

---

## 🚀 Local Setup (Manual)

### Step 1: Clone the Repository

```bash
# Clone the repository
git clone https://github.com/YOUR_USERNAME/pawportal.git

# Navigate to project directory
cd pawportal
```

---

### Step 2: Database Setup

#### Option A: Using pgAdmin 4

1. **Open pgAdmin 4**

2. **Create a new database:**
   - Right-click on "Databases" → Create → Database
   - Database name: `pawportal_db`
   - Owner: `postgres` (or your PostgreSQL username)
   - Click "Save"

3. **Verify connection:**
   - Host: `localhost`
   - Port: `5432`
   - Database: `pawportal_db`
   - Username: `postgres`
   - Password: Your PostgreSQL password

#### Option B: Using SQL Shell (psql)

```sql
-- Open psql and run:
CREATE DATABASE pawportal_db;

-- Verify database creation
\l

-- Connect to the database
\c pawportal_db
```

---

### Step 3: Backend Setup

#### 1. Navigate to Backend Directory

```bash
cd backend
```

#### 2. Configure Application Properties

Create a file named `application.properties` in `src/main/resources/`:

```bash
# For Windows
type nul > src\main\resources\application.properties

# For Mac/Linux
touch src/main/resources/application.properties
```

#### 3. Add Configuration

Open `src/main/resources/application.properties` and add:

```properties
# =========================================================
# = SERVER CONFIGURATION
# =========================================================
server.port=8080

# =========================================================
# = DATABASE CONFIGURATION (PostgreSQL)
# =========================================================
spring.datasource.url=jdbc:postgresql://localhost:5432/pawportal_db
spring.datasource.username=postgres
spring.datasource.password=YOUR_POSTGRESQL_PASSWORD
spring.datasource.driver-class-name=org.postgresql.Driver

# =========================================================
# = JPA / HIBERNATE CONFIGURATION
# =========================================================
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# =========================================================
# = JWT CONFIGURATION
# =========================================================
jwt.secret=YOUR_SECRET_KEY_HERE_MINIMUM_256_BITS_LONG_STRING
jwt.expiration=86400000

# =========================================================
# = EMAIL CONFIGURATION
# =========================================================
spring.mail.host=smtp.gmail.com
spring.mail.username=YOUR_GMAIL_ADDRESS
spring.mail.password=YOUR_GMAIL_APP_PASSWORD
spring.mail.port=587
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.connectiontimeout=5000
spring.mail.properties.mail.smtp.timeout=5000
spring.mail.properties.mail.smtp.writetimeout=5000
```

**Important Notes:**
- Replace `YOUR_POSTGRESQL_PASSWORD` with your actual PostgreSQL password
- Replace `YOUR_SECRET_KEY_HERE_MINIMUM_256_BITS_LONG_STRING` with a secure random string (at least 32 characters)
- Replace `YOUR_GMAIL_ADDRESS` and `YOUR_GMAIL_APP_PASSWORD` with your Gmail credentials

#### 4. Build and Run Backend

**Method 1: Using IntelliJ IDEA**

1. Open IntelliJ IDEA
2. File → Open → Select the `backend` folder
3. Wait for Maven to download dependencies (this may take a few minutes)
4. Locate `BackendApplication.java` in `src/main/java/com/pawportal/backend/`
5. Right-click → Run 'BackendApplication'
6. Verify the backend is running at http://localhost:8080

**Method 2: Using Maven Command Line**

```bash
# From the backend directory
./mvnw clean install

# Run the application
./mvnw spring-boot:run
```

**For Windows:**
```cmd
mvnw.cmd clean install
mvnw.cmd spring-boot:run
```

#### 5. Verify Backend is Running

Open your browser and navigate to:
- http://localhost:8080

You should see a 401 Unauthorized or 403 Forbidden response (this is expected - it means the backend is running).

---

### Step 4: Frontend Setup

#### 1. Navigate to Frontend Directory

```bash
# From the project root
cd frontend
```

#### 2. Install Dependencies

```bash
npm install
```

This will install all required packages including:
- Angular 20.3.0
- Tailwind CSS 4.1.16
- Font Awesome
- RxJS

**Note:** This may take 5-10 minutes depending on your internet connection.

#### 3. Run the Frontend

```bash
npm start
```

Or explicitly:
```bash
ng serve
```

The Angular development server will start on http://localhost:4200

#### 4. Access the Application

Open your browser and navigate to:
- http://localhost:4200

You should see the PawPortal login/home page.

---

## 🐳 Docker Setup

Docker provides a containerized environment that ensures consistency across different machines.

### Prerequisites

- Docker Desktop installed and running
- At least 4GB of RAM allocated to Docker

### Step 1: Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/pawportal.git
cd pawportal
```

### Step 2: Create Environment File (Backend)

Create `application.properties` in the `backend/src/main/resources/` directory:

```bash
# For Windows
type nul > backend\src\main\resources\application.properties

# For Mac/Linux
touch backend/src/main/resources/application.properties
```

Add the following content:

```properties
# =========================================================
# = SERVER CONFIGURATION
# =========================================================
server.port=8080

# =========================================================
# = DATABASE CONFIGURATION (PostgreSQL)
# =========================================================
spring.datasource.url=jdbc:postgresql://database:5432/pawportal
spring.datasource.username=pawportal_user
spring.datasource.password=pawportal_password
spring.datasource.driver-class-name=org.postgresql.Driver

# =========================================================
# = JPA / HIBERNATE CONFIGURATION
# =========================================================
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# =========================================================
# = JWT CONFIGURATION
# =========================================================
jwt.secret=YOUR_SECRET_KEY_HERE_MINIMUM_256_BITS_LONG_STRING
jwt.expiration=86400000

# =========================================================
# = EMAIL CONFIGURATION
# =========================================================
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=YOUR_GMAIL_ADDRESS
spring.mail.password=YOUR_GMAIL_APP_PASSWORD
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.connectiontimeout=5000
spring.mail.properties.mail.smtp.timeout=5000
spring.mail.properties.mail.smtp.writetimeout=5000
```

**⚠️ Important:** Replace placeholder values with your actual credentials.

### Step 3: Create Dockerfiles

#### Backend Dockerfile

Create `backend/Dockerfile`:

```dockerfile
FROM maven:3.9.11-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

#### Frontend Dockerfile

Create `frontend/Dockerfile`:

```dockerfile
FROM node:20-alpine AS build
WORKDIR /app
COPY package*.json ./
RUN npm ci
COPY . .
RUN npm run build

FROM nginx:alpine
COPY --from=build /app/dist/frontend/browser /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
```

#### Frontend Nginx Configuration

Create `frontend/nginx.conf`:

```nginx
server {
    listen 80;
    server_name localhost;
    root /usr/share/nginx/html;
    index index.html;

    location / {
        try_files $uri $uri/ /index.html;
    }

    location /api/ {
        proxy_pass http://backend:8080/;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
    }
}
```

### Step 4: Create Docker Compose File

Create `docker-compose.yml` in the project root:

```yaml
version: '3.8'

services:
  database:
    image: postgres:15-alpine
    container_name: pawportal-db
    environment:
      POSTGRES_DB: pawportal
      POSTGRES_USER: pawportal_user
      POSTGRES_PASSWORD: pawportal_password
    ports:
      - "5432:5432"
    volumes:
      - pawportal_postgres_data:/var/lib/postgresql/data
    networks:
      - pawportal-network
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U pawportal_user -d pawportal"]
      interval: 10s
      timeout: 5s
      retries: 5

  backend:
    build:
      context: ./backend
      dockerfile: Dockerfile
    container_name: pawportal-backend
    ports:
      - "8080:8080"
    depends_on:
      database:
        condition: service_healthy
    networks:
      - pawportal-network
    restart: unless-stopped

  frontend:
    build:
      context: ./frontend
      dockerfile: Dockerfile
    container_name: pawportal-frontend
    ports:
      - "4200:80"
    depends_on:
      - backend
    networks:
      - pawportal-network
    restart: unless-stopped

volumes:
  pawportal_postgres_data:

networks:
  pawportal-network:
    driver: bridge
```

### Step 5: Run with Docker Compose

```bash
# Start all services (database, backend, frontend)
docker-compose up -d

# View logs
docker-compose logs -f

# Stop all services
docker-compose down
```

### Step 6: Access the Application

- **Frontend:** http://localhost:4200
- **Backend API:** http://localhost:8080
- **Database:** localhost:5432

### Troubleshooting Docker

**If containers fail to start:**

```bash
# Check container status
docker-compose ps

# View logs for a specific service
docker-compose logs backend
docker-compose logs frontend
docker-compose logs database

# Restart a specific service
docker-compose restart backend

# Rebuild and restart
docker-compose up -d --build
```

**Database connection issues:**

```bash
# Ensure database is healthy
docker-compose ps

# Check database logs
docker-compose logs database

# Connect to database manually
docker exec -it pawportal-db psql -U pawportal_user -d pawportal
```

**To completely reset:**

```bash
# Stop and remove all containers, networks, and volumes
docker-compose down -v

# Rebuild from scratch
docker-compose up -d --build
```

---

## 🐳 Alternative Docker Setup (Pre-built Images)

If you prefer not to clone the entire repository, you can run PawPortal directly using pre-built Docker images from GitHub Container Registry (GHCR).

### Prerequisites

- Docker Desktop installed and running
- At least 4GB of RAM allocated to Docker

### Step 1: Create Project Directory

```bash
# For Windows
mkdir pawportal-docker
cd pawportal-docker

# For Mac/Linux
mkdir pawportal-docker && cd pawportal-docker
```

### Step 2: Create Environment File

Create a `.env` file in your project directory:

```env
# JWT Configuration
JWT_SECRET=YOUR_SECRET_KEY_HERE_MINIMUM_256_BITS_LONG_STRING

# Email Configuration
EMAIL_USERNAME=YOUR_GMAIL_ADDRESS
EMAIL_PASSWORD=YOUR_GMAIL_APP_PASSWORD
```

**⚠️ Important:** Replace all placeholder values with your actual credentials.

### Step 3: Create Docker Compose File

Create a file named `docker-compose.yml`:

```yaml
version: '3.8'

services:
  database:
    image: postgres:15-alpine
    container_name: pawportal-db
    environment:
      POSTGRES_DB: pawportal
      POSTGRES_USER: pawportal_user
      POSTGRES_PASSWORD: pawportal_password
    ports:
      - "5432:5432"
    volumes:
      - pawportal_postgres_data:/var/lib/postgresql/data
    networks:
      - pawportal-network
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U pawportal_user -d pawportal"]
      interval: 10s
      timeout: 5s
      retries: 5

  backend:
    image: ghcr.io/YOUR_USERNAME/pawportal-backend:latest
    container_name: pawportal-backend
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://database:5432/pawportal
      SPRING_DATASOURCE_USERNAME: pawportal_user
      SPRING_DATASOURCE_PASSWORD: pawportal_password
      JWT_SECRET: ${JWT_SECRET}
      JWT_EXPIRATION: 86400000
      SPRING_MAIL_HOST: smtp.gmail.com
      SPRING_MAIL_PORT: 587
      SPRING_MAIL_USERNAME: ${EMAIL_USERNAME}
      SPRING_MAIL_PASSWORD: ${EMAIL_PASSWORD}
      SPRING_MAIL_PROPERTIES_MAIL_SMTP_AUTH: true
      SPRING_MAIL_PROPERTIES_MAIL_SMTP_STARTTLS_ENABLE: true
    ports:
      - "8080:8080"
    depends_on:
      database:
        condition: service_healthy
    networks:
      - pawportal-network
    restart: unless-stopped

  frontend:
    image: ghcr.io/YOUR_USERNAME/pawportal-frontend:latest
    container_name: pawportal-frontend
    ports:
      - "4200:80"
    depends_on:
      - backend
    networks:
      - pawportal-network
    restart: unless-stopped

volumes:
  pawportal_postgres_data:

networks:
  pawportal-network:
    driver: bridge
```

### Step 4: Start the Application

```bash
docker-compose up -d
```

This will:
1. Pull the pre-built images from GitHub Container Registry (first time only)
2. Create and start the database container
3. Wait for the database to be healthy
4. Start the backend container
5. Start the frontend container

### Step 5: Access the Application

Once all containers are running:
- **Frontend:** http://localhost:4200
- **Backend API:** http://localhost:8080
- **Database:** localhost:5432

### Managing the Application

**View logs:**
```bash
# All services
docker-compose logs -f

# Specific service
docker-compose logs -f backend
docker-compose logs -f frontend
docker-compose logs -f database
```

**Stop the application:**
```bash
docker-compose down
```

**Stop and remove all data (including database):**
```bash
docker-compose down -v
```

**Update to latest images:**
```bash
# Pull latest images
docker-compose pull

# Restart with new images
docker-compose up -d
```

---

## 🧪 Testing the Application

### Create an Account

1. Navigate to http://localhost:4200
2. Click "Sign Up"
3. Fill in the registration form:
   - First Name
   - Last Name
   - Email
   - Password (minimum 6 characters)
4. Click "Sign up now"

### Login

1. Use your registered email and password
2. Click "Login now"
3. You will be redirected to the Home page

### Browse Dogs

1. Navigate to "Our Pawls" from the menu
2. View available dogs for adoption
3. Click on any dog to see detailed information
4. Apply for adoption by filling out the application form

### Admin Access

The application uses role-based authentication. Admin users have access to additional features:
- Dog management (add, edit, delete)
- Application review and approval
- User management
- Contact form management
- Audit log viewing

**Note:** Admin privileges are assigned at the database level or through admin promotion features.

---

## 📖 Project Documentation

For detailed project information, please refer to:

- **[GitHub Repository](https://github.com/YOUR_USERNAME/pawportal)**
- **[Live Demo](DEMO_LINK)** (if available)
- **[API Documentation](API_DOCS_LINK)** (if available)

---

## 👥 Team

**Group 6 - ITS181-2 Project**

| Name                                                                   | Role           | Contributions                                                          |
| ---------------------------------------------------------------------- | -------------- | ---------------------------------------------------------------------- |
| **[Kenji Mark Alan Arceo](mailto:kmarceo@mymail.mapua.edu.ph)**      | Developer      | Frontend components, UI/UX design, User interface implementation       |
| **[Carl Norbi Felonia](mailto:cncfelonia@mymail.mapua.edu.ph)**      | Developer      | Backend services, Business logic, API development                       |
| **[Ryonan Owen Ferrer](mailto:roferrer@mymail.mapua.edu.ph)**        | Developer      | Database design, Data management, Backend integration                   |
| **[Dino Alfred Timbol](mailto:dattimbol@mymail.mapua.edu.ph)**       | Lead Developer | System architecture, Authentication, Security implementation            |
| **[Mike Emil Vocal](mailto:mevocal@mymail.mapua.edu.ph)**            | Developer      | Testing, Documentation, Deployment, Quality assurance                   |

**Course:** ITS181-2 - Advanced Systems Integration and Architecture 2  
**Institution:** _Mapúa University - School of Information Technology_  
**Academic Year:** 2024-2025

---

## 🙏 Acknowledgements

We would like to express our gratitude to:

- **Mapúa University Faculty** - For guidance and support throughout the project development
- **Valenzuela City Veterinary Office** - For the project concept and partnership opportunity
- **Spring Boot Community** - For excellent documentation and support
- **Angular Team** - For the robust frontend framework
- **Stack Overflow Community** - For invaluable troubleshooting assistance

### Technologies & Libraries

Special thanks to the open-source projects that made this possible:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Angular](https://angular.io/)
- [Tailwind CSS](https://tailwindcss.com/)
- [PostgreSQL](https://www.postgresql.org/)
- [Docker](https://www.docker.com/)
- [Font Awesome](https://fontawesome.com/)

---

## 📞 Contact

For questions, suggestions, or collaboration opportunities:

- **Email:** pawportal.business@outlook.com
- **GitHub Issues:** [Create an issue](https://github.com/YOUR_USERNAME/pawportal/issues)

---

<p align="center">
  <em>Connecting rescued dogs with loving families, one adoption at a time.</em><br><br>
  <strong>Made with ❤️ by Group 6</strong>
</p>

---

## ⭐ Star History

If you find this project useful, please consider giving it a star! ⭐

[![Star History Chart](https://api.star-history.com/svg?repos=YOUR_USERNAME/pawportal&type=Date)](https://star-history.com/#YOUR_USERNAME/pawportal&Date)
