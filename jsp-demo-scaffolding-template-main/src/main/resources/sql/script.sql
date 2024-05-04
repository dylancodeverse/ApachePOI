CREATE TABLE promotion (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    year INTEGER NOT NULL
);

CREATE TABLE student (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    first_name VARCHAR(100),
    birthdate DATE NOT NULL,
    promotion_id INTEGER REFERENCES promotion(id) NOT NULL
);

CREATE TABLE semester (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE subject (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    coefficient INTEGER NOT NULL,
    semester_id INTEGER REFERENCES semester(id) NOT NULL
);

CREATE TABLE student_grade (
    id SERIAL PRIMARY KEY,
    grade DOUBLE PRECISION NOT NULL,
    student_id INTEGER REFERENCES student(id) NOT NULL,
    subject_id INTEGER REFERENCES subject(id) NOT NULL,
    "date" DATE NOT NULL
);