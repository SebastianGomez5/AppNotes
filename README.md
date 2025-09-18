# AppNotes

AppNotes is a simple full-stack project built with **Spring Boot (backend)** and **React (frontend)**.  
It allows you to **create, edit, and delete notes** in a clean and easy-to-use interface.  
The backend uses an **H2 in-memory database**, so you can start testing without any setup.

---

## Tech Stack
- **Backend**: Java, Spring Boot, Spring Data JPA, H2 Database
- **Frontend**: React, Vite, Axios
- **Tools**: Postman (for API testing), npm

---

##  Installation and Setup

#### Clone the repository
```bash
git clone https://github.com/SebastianGomez5/AppNotes
cd AppNotes
```
vNavigate to the **backend folder**:
```bash
cd backend-app
```
Run the **Spring Boot app**:
```bash
./mvnw spring-boot:run
```
The backend will be available at: http://localhost:8080/api/notas
**Default Database**: H2 (in-memory).
Access H2 Console: http://localhost:8080/h2-console
Use `jdbc:h2:mem:testdb` as the JDBC URL.


---

#### Frontend setup (React + Vite)
Navigate to the frontend folder:
```bash
cd frontend-app
```
Install dependencies:
```bash
npm install
```
Run the development server:
```bash
npm run dev
```
The frontend will be available at: http://localhost:5173

#### Preview
Here’s how the app looks:
![App Screenshot](https://i.ibb.co/N6JdG2PY/Captura-de-pantalla-2025-09-18-122515.jpg)

#### Preview
- Create new notes
- Edit existing notes
- Delete notes
- Simple and aesthetic UI
- In-memory database for easy testing

## Developer
Sebastian Gomez
- **Github**: [@SebastianGomez5](https://github.com/SebastianGomez5)
- **Linkedin**: [Sebastian Gomez](https://www.linkedin.com/in/sebastian-g%C3%B3mez-885814337/)