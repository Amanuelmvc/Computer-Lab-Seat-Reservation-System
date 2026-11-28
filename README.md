# Computer Lab Seat Reservation System

## Project Description

This is a simple Java console program for students who need to reserve a seat in a computer lab. It helps show which seats are available and prevents a seat from being reserved twice while the program is running.

Reservations are stored in memory, so they are cleared when the program closes. Saving data, student accounts, and administrator tools are planned for later work.

## Project Information

- **Department:** Electrical Engineering
- **Group:** Group 9
- **Course:** CS2010 – Object Oriented Programming
- **Instructor:** Jemal Bedaso

## Group Members

1. Chala Assefa Nigussie
2. Fuad Aliyi Abdurahman
3. Sossina Simachew
4. Ammar Munir Mohammed
5. Amanuel Tilahun Lemecha

## Current Features

- View the status of ten seats
- Reserve an available seat using a student name
- Cancel a reservation
- Reject an attempt to reserve an occupied seat

## Run the Program

Install a JDK, open a terminal in this folder, and run:

```text
javac -d out Admin.java App.java ReservationService.java Seat.java Student.java User.java
java -cp out App
```

## Project Status

This is an early console prototype. It does not save reservations after the program exits. Student login, administrator features, a user interface, and permanent data storage are not implemented yet.
