DROP DATABASE IF EXISTS alumnos;
CREATE DATABASE IF NOT EXISTS alumnos;
USE alumnos;

CREATE TABLE alumno (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  apellido VARCHAR(50) NOT NULL,
  telefono VARCHAR(50) NOT NULL,
  correo VARCHAR(50) NOT NULL,
  curso VARCHAR(50) NOT NULL,
  genero VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO alumno (nombre, apellido, telefono, correo, curso, genero) VALUES
('Juan', 'Pérez', '555-1234', 'juan.perez@example.com', 'ESO', 'M'),
('María', 'López', '555-5678', 'maria.lopez@example.com', 'ESO', 'F'),
('Carlos', 'Martínez', '555-9101', 'carlos.martinez@example.com', 'Bachillerato', 'M'),
('Ana', 'González', '555-1122', 'ana.gonzalez@example.com', 'ESO', 'F'),
('Luis', 'García', '555-3344', 'luis.garcia@example.com', 'Bachillerato', 'M'),
('Lucía', 'Fernández', '555-5566', 'lucia.fernandez@example.com', 'ESO', 'F'),
('Roberto', 'Hernández', '555-7788', 'roberto.hernandez@example.com', 'Bachillerato', 'M'),
('Patricia', 'Sánchez', '555-9900', 'patricia.sanchez@example.com', 'Bachillerato', 'F'),
('Jorge', 'Ramírez', '555-2233', 'jorge.ramirez@example.com', 'Bachillerato', 'M'),
('Sofía', 'Alvarez', '555-4466', 'sofia.alvarez@example.com', 'ESO', 'F');

SELECT * FROM alumno;