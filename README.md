# tci

This project provides a REST API to manage employee bonuses, including inserting new employees and retrieving employee bonus information by date.

## Table of Contents

- [Overview](#overview)
- [Requirements](#requirements)
- [Setup](#setup)
- [API Endpoints](#api-endpoints)
- [Running Tests](#running-tests)

## Overview

The Employee Bonus Management System allows you to insert employee details and retrieve a list of employees along with their bonuses based on a specific date.

## Requirements

- Java 8 or higher
- Spring Boot
- Gradle
- MySQL Database

## Setup

1. Clone the repository
2. Configure the database

spring.datasource.url=jdbc:mysql://localhost:3306/your-database
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update


## API Endpoints
 Insert Employees
URL: /tci/employee-bonus
Method: POST
Request Body: RequestDto
Response: String message indicating success

## Sample
## RequestDto


{
    "errorMessage": null,
    "data": [
        {
            "currency": "INR",
            "employees": [
                {
                    "empName": "raj singh",
                    "amount": 5000.0
                },
                {
                    "empName": "raj singh",
                    "amount": 5000.0
                },
               
            ]
        }
    ]
}


## Response

"Employees Inserted"


## Get Employees List by Date
URL: /tci/employee-bonus
Method: GET
Request Param: date (format: MMM-dd-yyyy, e.g., May-20-2009)

## Response Sample

{
  "data": [
    {
      "currency": "USD",
      "employees": [
        {
          "empName": "Alice",
          "amount": 5000
        },
        {
          "empName": "Bob",
          "amount": 6000
        }
      ]
    }
  ],
  "errorMessage": null
}



## Test Cases are also present to test these methods
