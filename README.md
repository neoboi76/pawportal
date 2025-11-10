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
- [Docker Setup #1 (Clone Repository)](#-docker-setup-1-clone-repository)
- [Docker Setup #2 (Pre-built Images)](#-docker-setup-2-pre-built-images)
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
git clone https://github.com/neoboi76/pawportal.git

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

## 🐳 Docker Setup #1 (Clone Repository)

This setup is for users who want to build and run the application using Docker after cloning the repository. Docker Compose will build the images from source and manage all services.

### Prerequisites

- Docker Desktop installed and running
- At least 4GB of RAM allocated to Docker

### Step 1: Clone the Repository

```bash
git clone https://github.com/neoboi76/pawportal.git
cd pawportal
```

### Step 2: Configure Environment Variables

A sample environment file is included in the repository. Copy and edit it:

```bash
# For Windows
copy .env.sample .env

# For Mac/Linux
cp .env.sample .env
```

Edit the `.env` file and replace the placeholder values:

```env
# =========================================================
# = SERVER CONFIGURATION
# =========================================================
SERVER_PORT=8080

# =========================================================
# = DATABASE CONFIGURATION (PostgreSQL)
# =========================================================
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/pawportal_db
SPRING_DATASOURCE_USERNAME=pawportal_user
SPRING_DATASOURCE_PASSWORD=pawportal_password
SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.postgresql.Driver

# =========================================================
# = JPA / HIBERNATE CONFIGURATION
# =========================================================
SPRING_JPA_HIBERNATE_DDL_AUTO=update
SPRING_JPA_SHOW_SQL=true
SPRING_JPA_PROPERTIES_HIBERNATE_FORMAT_SQL=true
SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT=org.hibernate.dialect.PostgreSQLDialect

# =========================================================
# = JWT CONFIGURATION
# =========================================================
JWT_SECRET=your_jwt_secret_here_minimum_256_bits
JWT_EXPIRATION=86400000
JWT_REFRESH_EXPIRATION=604800000

# =========================================================
# = LOGGING
# =========================================================
LOGGING_LEVEL_ORG_HIBERNATE_SQL=DEBUG
LOGGING_LEVEL_ORG_HIBERNATE_TYPE_DESCRIPTOR_SQL_BASICBINDER=TRACE

# =========================================================
# = EMAIL CONFIGURATION
# =========================================================
SPRING_MAIL_USERNAME=your_email_here@gmail.com
SPRING_MAIL_PASSWORD=your_gmail_app_password_here
SPRING_MAIL_PORT=587
SPRING_MAIL_PROPERTIES_MAIL_SMTP_AUTH=true
SPRING_MAIL_PROPERTIES_MAIL_SMTP_STARTTLS_ENABLE=true
SPRING_MAIL_PROPERTIES_MAIL_SMTP_STARTTLS_REQUIRED=true
SPRING_MAIL_PROPERTIES_MAIL_SMTP_CONNECTIONTIMEOUT=5000
SPRING_MAIL_PROPERTIES_MAIL_SMTP_TIMEOUT=5000
SPRING_MAIL_PROPERTIES_MAIL_SMTP_WRITETIMEOUT=5000
```

**⚠️ Important:** Replace all placeholder values with your actual credentials:

- `JWT_SECRET`: A secure random string (at least 32 characters)
- `SPRING_MAIL_USERNAME`: Your Gmail address
- `SPRING_MAIL_PASSWORD`: Your Gmail app password (not your regular password)

### Step 3: Run with Docker Compose

The `docker-compose.yml` file is already included in the repository and configured to:

- Build the backend and frontend from source
- Set up a PostgreSQL database
- Connect all services together

```bash
# Start all services (database, backend, frontend)
docker-compose up -d

# View logs
docker-compose logs -f

# View logs for a specific service
docker-compose logs -f backend
docker-compose logs -f frontend
docker-compose logs -f database
```

### Step 4: Access the Application

Once all containers are running:

- **Frontend:** http://localhost:4200
- **Backend API:** http://localhost:8080
- **Database:** localhost:5432

### Managing the Application

**Stop the application:**

```bash
docker-compose down
```

**Stop and remove all data (including database):**

```bash
docker-compose down -v
```

**Rebuild after code changes:**

```bash
docker-compose up -d --build
```

**Restart a specific service:**

```bash
docker-compose restart backend
docker-compose restart frontend
```

### Troubleshooting

**If containers fail to start:**

```bash
# Check container status
docker-compose ps

# View logs for errors
docker-compose logs backend
docker-compose logs frontend
docker-compose logs database

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

## 🐳 Docker Setup #2 (Pre-built Images)

This setup is for users who want to run PawPortal quickly without cloning the repository. It uses pre-built Docker images from GitHub Container Registry (GHCR).

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

Create a file named `.env` in your project directory with the following content:

```env
# =========================================================
# = SERVER CONFIGURATION
# =========================================================
SERVER_PORT=8080

# =========================================================
# = DATABASE CONFIGURATION (PostgreSQL)
# =========================================================
SPRING_DATASOURCE_URL=jdbc:postgresql://database:5432/pawportal
SPRING_DATASOURCE_USERNAME=pawportal_user
SPRING_DATASOURCE_PASSWORD=pawportal_password
SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.postgresql.Driver

# =========================================================
# = JPA / HIBERNATE CONFIGURATION
# =========================================================
SPRING_JPA_HIBERNATE_DDL_AUTO=update
SPRING_JPA_SHOW_SQL=true
SPRING_JPA_PROPERTIES_HIBERNATE_FORMAT_SQL=true
SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT=org.hibernate.dialect.PostgreSQLDialect

# =========================================================
# = JWT CONFIGURATION
# =========================================================
JWT_SECRET=your_jwt_secret_here_minimum_256_bits
JWT_EXPIRATION=86400000
JWT_REFRESH_EXPIRATION=604800000

# =========================================================
# = LOGGING
# =========================================================
LOGGING_LEVEL_ORG_HIBERNATE_SQL=DEBUG
LOGGING_LEVEL_ORG_HIBERNATE_TYPE_DESCRIPTOR_SQL_BASICBINDER=TRACE

# =========================================================
# = MAIL CONFIGURATION
# =========================================================
SPRING_MAIL_USERNAME=your_email_here@gmail.com
SPRING_MAIL_PASSWORD=your_gmail_app_password_here
SPRING_MAIL_PORT=587
SPRING_MAIL_PROPERTIES_MAIL_SMTP_AUTH=true
SPRING_MAIL_PROPERTIES_MAIL_SMTP_STARTTLS_ENABLE=true
SPRING_MAIL_PROPERTIES_MAIL_SMTP_STARTTLS_REQUIRED=true
SPRING_MAIL_PROPERTIES_MAIL_SMTP_CONNECTIONTIMEOUT=5000
SPRING_MAIL_PROPERTIES_MAIL_SMTP_TIMEOUT=5000
SPRING_MAIL_PROPERTIES_MAIL_SMTP_WRITETIMEOUT=5000
```

**⚠️ Important:** Replace all placeholder values with your actual credentials:

- `JWT_SECRET`: A secure random string (at least 32 characters)
- `SPRING_MAIL_USERNAME`: Your Gmail address
- `SPRING_MAIL_PASSWORD`: Your Gmail app password (not your regular password)

### Step 3: Create Docker Compose File

Create a file named `docker-compose.yml` in the same directory:

```yaml
version: "3.8"

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
    image: ghcr.io/neoboi76/pawportal-backend:latest
    container_name: pawportal-backend
    env_file: .env
    ports:
      - "8080:8080"
    depends_on:
      database:
        condition: service_healthy
    networks:
      - pawportal-network
    restart: unless-stopped

  frontend:
    image: ghcr.io/neoboi76/pawportal-frontend:latest
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

- **[GitHub Repository](https://github.com/neoboi76/pawportal)**
- **[Video Demo](https://drive.google.com/file/d/1coeHhwrSjsdpD4GdpH1G5L3V7Ta48Tuc/view?usp=sharing)**

---

## 👥 Team

**Group 6 - ITS181-2 Project**

| Name                                                            | Role           | Contributions                                                    |
| --------------------------------------------------------------- | -------------- | ---------------------------------------------------------------- |
| **[Kenji Mark Alan Arceo](mailto:kmarceo@mymail.mapua.edu.ph)** | Developer      | Frontend components, UI/UX design, User interface implementation |
| **[Carl Norbi Felonia](mailto:cncfelonia@mymail.mapua.edu.ph)** | Developer      | Backend services, Business logic, API development                |
| **[Ryonan Owen Ferrer](mailto:roferrer@mymail.mapua.edu.ph)**   | Developer      | Database design, Data management, Backend integration            |
| **[Dino Alfred Timbol](mailto:dattimbol@mymail.mapua.edu.ph)**  | Lead Developer | System architecture, Authentication, Security implementation     |
| **[Mike Emil Vocal](mailto:mevocal@mymail.mapua.edu.ph)**       | Developer      | Testing, Documentation, Deployment, Quality assurance            |

**Course:** ITS181-2 - Advanced Systems Integration and Architecture 2  
**Institution:** _Mapúa University - School of Information Technology_  
**Academic Year:** 2024-2025

---

## 🙏 Acknowledgements

We would like to express our gratitude to:

- **Prof. Antonette Gabriel** - For guidance and support throughout the project development
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
- **GitHub Issues:** [Create an issue](https://github.com/neoboi76/pawportal/issues)

---

<p align="center">
  <em>Connecting rescued dogs with loving families, one adoption at a time.</em><br><br>
  <strong>Made by Group 6</strong>
</p>
