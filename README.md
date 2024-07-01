# Maven
---

## How to Build

```bash
mvn clean install
```

## How to Compile

```bash
mvn compile
```

## How to Run

```bash
 java -jar target/mini-project-2-1.0.1.jar 
```

## How to Test

```bash
 mvn clean test 
```

## How to View Javadoc

After building the project, you can view the generated Javadoc for the library system. The Javadoc files are located in the `doc` folder. To access the documentation, open the `index.html` file located in the `doc` folder using a web browser.

Path:
```bash
mini-project-2/docs/index.html

```
# Mini Project 2
---
# Library Management System
A simple book library system that incorporates OOP principles. It handles two different book types: E-Books and Physical Books. The Library Management System is a simple Java application that allows users to manage a collection of books and e-books. Users can add, delete, and search for books and e-books. The application also demonstrates the use of the four pillars of Object-Oriented Programming (OOP): Encapsulation, Inheritance, Polymorphism, and Abstraction.

## Features

- Add a new Book or E-Book to the library.
- Delete an existing Book or E-Book from the library.
- Search for a Book or E-Book by title.
- User-friendly console interface.

## OOP Concepts

### Encapsulation

- Each class encapsulates its data and methods, exposing only the necessary interfaces.
-  The `Book` and `EBook` classes encapsulate details like title, author, ISBN, etc.

### Inheritance

- The `Book` and `EBook` classes inherit from the `Category` class, demonstrating the use of inheritance.
- `Book` and `EBook` extend `Category` and inherit its properties and methods.

### Polymorphism

- The `Category` class has an abstract method `printType()`, which is overridden by `Book` and `EBook`.
- The `printType()` method is implemented differently in `Book` and `EBook`.

### Abstraction

- The `Category` class is abstract and defines common properties and methods for its subclasses.
- `Category` provides a common interface for `Book` and `EBook`.


# Mini Project 3
---
# Simple E-Commerce Cart System
This project is a simple e-commerce cart system implemented in Java. It allows users to add products to a shopping cart, view the cart items, and calculate the total price of the items in the cart. The project uses the Java Collections Framework, Generics, and Lambda Expressions.

## Features

- Add Product to Cart: Add products with a name and price to the shopping cart.
- View Cart Items: Display the list of items with their names and formatted prices in the cart.
- Calculate Total Price: Calculate and display the total price of the items in the cart.


---

### Author
Vashti Leonie D. Bauson
