# Student Expense Manager

A console-based Java application for managing student expenses.

The project demonstrates core object-oriented programming concepts including inheritance, polymorphism, encapsulation, collections, and input validation.

## Features

- Add standard expenses
- Add discounted expenses
- View all recorded expenses
- Calculate total spending
- Find the highest expense
- Validate user input
- Menu-driven console interface

## Technologies Used

- Java
- Object-Oriented Programming
- ArrayList
- Scanner
- Git
- GitHub

## Object-Oriented Programming Concepts

This project demonstrates:

- **Encapsulation** through private fields and getter/setter methods
- **Inheritance** using `DiscountedExpense extends Expense`
- **Polymorphism** by storing different expense types in an `ArrayList<Expense>`
- **Method overriding** for calculating and displaying discounted expenses
- **Object-oriented class design** using separate classes for different responsibilities

## Project Structure

```text
src/
├── Expense.java
├── DiscountedExpense.java
└── StudentExpenseManager.java