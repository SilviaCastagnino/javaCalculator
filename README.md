# Java Advanced Calculator
## Overview

As a software engineer, I am constantly looking to deepen my understanding of object-oriented programming and robust input handling. This project was developed to move beyond simple logic and explore how to build a resilient, user-friendly console application that can manage state (history logs) and handle unexpected user behavior gracefully.

The software is a console-based Advanced Calculator written in Java. It supports basic arithmetic operations (Addition, Subtraction, Multiplication, Division) but sets itself apart by implementing a dynamic history tracking system. It uses a First-In-First-Out (FIFO) logic to maintain a log of the last 10 operations, allowing users to review or clear their calculation history during a session.

My purpose for writing this software was to master Java's Exception Handling and the Collections Framework. Specifically, I focused on creating "bulletproof" input methods that use try-catch blocks and buffer management to ensure the program never crashes due to invalid user input (like entering text when a number is expected).

[Software Demo Video](https://youtu.be/vFs-ZN7RFFc)

## Development Environment

To build this tool, I used the following environment:
- IDE: IntelliJ IDEA / VS Code (choose your preferred one).
- JDK: Java Development Kit (JDK) 17 or higher.
- Version Control: Git for managing code iterations.

The software is written entirely in Java. I utilized the following standard libraries:
- java.util.Scanner: For processing user input from the console.
- java.util.ArrayList & java.util.List: To implement the dynamic history log.
- java.util.InputMismatchException: To handle and recover from incorrect data entry.

## Useful Websites  

- [W3Schools](https://www.w3schools.com/java/java_try_catch.asp)
- [Java](https://docs.oracle.com/en/java/)

## Future Work

While the current version is stable, I plan to implement the following improvements:
- Persistent Storage: Currently, the history log is lost when the program closes. I want to add File I/O to save the history to a .txt or .json file.
- Scientific Operations: Expand the math engine to include square roots, exponentiation, and trigonometric functions (sin, cos, tan).
- GUI Migration: Move from a console-based interface to a Graphical User Interface (GUI) using JavaFX or Swing to improve user experience.
- Expression Parsing: Implement a logic that allows users to type full strings (e.g., "5 + 10 / 2") instead of entering numbers one by one.
