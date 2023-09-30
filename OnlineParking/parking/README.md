# Parking
Parking management with Spring Boot

This is a Spring Boot application example based on a parking. This application provides some REST services for simple
operations like park and unpark a car. All operations are described in detail below.
The persistence is implemented using an in-memory database with h2.
It auses Basic Auth to secure the services. The existing users are:

- User: user
- Password: password
- Roles: USER

and

- User: admin
- Password: admin
- Roles: ADMIN

## Build

Application uses Maven as build system, so in order to generate the executable JAR file you only need to execute:

```bash
$ mvn package
```

The executable file can be found at `[...]/target/parking-1.0.0.jar`.


## Run

You can run the server with the following command:

```bash
$ java -jar parking-1.0.0.jar
```

Server will start listening on port `8080`. Example [http://localhost:8080]().


## Operations
[Create parking](#create-parking)  
[Park car](#park-car)  
[Unpark car](#unpark-car)  
[Print parking](#print-parking)  

### Create parking
Creates a new parking with the given configuration.

* **URL**

  /parking

* **Method:**

  `POST`

*  **URL Params**

  None

* **Data Params**

  * size: integer
    * Square size of the parking
  * pedestrianExits: integer[]
    * Index of the pedestrian exits
  * disabledBays: integer[]
    * Index of the disabled-only bays

### Get number of available bays
Gets the number of available parking bays left

* **URL**

  /parking/{id}

* **Method:**

  `GET`

*  **URL Params**

  * id: integer
    * id of the parking

* **Data Params**

  None

### Park car
Parks a car of the given type ('D' being dedicated to disabled people) in closest -to pedestrian exit- and first (starting from the parking's entrance)
available bay. Disabled people can only park on dedicated bays.

* **URL**

  /parking/{id}/park/{carType}

* **Method:**

  `PUT`

*  **URL Params**

  * id: integer
    * id of the parking
  * carType: char
    * Car char representation that has to be parked

* **Data Params**

  None

### Unpark car
Unparks the car from the given index

* **URL**

  /parking/{id}/unpark/{index}

* **Method:**

  `PUT`

*  **URL Params**

  * id: integer
    * id of the parking
  * index: integer
    * index of the car to unpark

* **Data Params**

  None

### Print parking
Print a 2-dimensional representation of the parking with the following rules:
     <ul>
     <li>'=' is a pedestrian exit
     <li>'@' is a disabled-only empty bay
     <li>'U' is a non-disabled empty bay
     <li>'D' is a disabled-only occupied bay
     <li>the char representation of a parked vehicle for non-empty bays.
     </ul>

U, D, @ and = can be considered as reserved chars.

Once an end of lane is reached, then the next lane is reversed (to represent the fact that cars need to turn around)

* **URL**

  /parking/{id}/print

* **Method:**

  `GET`

*  **URL Params**

  * id: integer
    * id of the parking

* **Data Params**

  None

The complete API Rest definition is in [Swagger definition](./parking-swagger.yaml)

## Tests

The repo contains unit test files (Unitary and Integration test).

In order to run Maven integrated tests, run the following command:

```bash
$ mvn clean verify
```
Also, you can test all endpoints with the given Postman collection:

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/87fe92bb795ecfdf6e3c)

## Nice to have (not implemented yet)
- Logging
- Validations
- Error handling
