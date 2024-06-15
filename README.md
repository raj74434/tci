# tci

This project provides a REST API to manage employee bonuses, including inserting new employees and retrieving employee bonus information by date.


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
<br/>
spring.datasource.url=jdbc:mysql://localhost:3306/your-database
<br/>
spring.datasource.username=your-username
<br/>
spring.datasource.password=your-password
<br/>
spring.jpa.hibernate.ddl-auto=update
<br/>


## API Endpoints
 Insert Employees
 <br/>
URL:  /tci/employee-bonus
<br/>

Method: POST
<br/>
Request Body: RequestDto
<br/>
Response: String message indicating success
<br/>

## Sample
## RequestDto


{
    <br/>
    "errorMessage": null,
    <br/>
    "data": [
        <br/>
        {
            <br/>
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
                <br/>
               
            ]
           
        }
        
    ]
    
}


## Response

"Employees Inserted"


## Get Employees List by Date
URL: /tci/employee-bonus
<br/>
Method: GET
<br/>
Request Param: date (format: MMM-dd-yyyy, e.g., May-20-2009)

## Response Sample

{
    <br/>
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
  <br/>
  "errorMessage": null
}



## Test Cases are also present for test these methods
