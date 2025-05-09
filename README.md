# 📚 Plataforma Académica

Este proyecto es una plataforma académica construida con **Spring Boot** que gestiona entidades educativas como estudiantes, profesores, materias, evaluaciones, horarios y matrículas.

## 🧰 Tecnologías

- Java 17+
- Spring Boot
- Spring Data JPA
- Lombok
- Maven


## 📦 Estructura del proyecto

```text
plataforma_academica/
├── model/                 # Entidades JPA (Subject, Student, Teacher, etc.)
├── repositories/          # Interfaces JpaRepository
├── services/              # Interfaces de lógica de negocio
├── services/impl/         # Implementaciones de servicios
├── controllers/           # Controladores REST
└── resources/
    └── application.yml    # Configuración de Spring Boot
