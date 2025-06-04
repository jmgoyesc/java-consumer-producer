# java-consumer-producer

A sample Spring Boot project to explore concurrency in Java using a configurable in-memory producer-consumer system. The application exposes a REST API to dynamically adjust producer/consumer behavior and monitor real-time statistics. Designed as a learning playground with a focus on code quality, test coverage, and null-safety using JSpecify.

---

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [API Documentation](#api-documentation)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Testing](#testing)
- [Code Quality](#code-quality)
- [Planned Improvements](#planned-improvements)

---

## Overview

This project simulates a multi-threaded system in which producers generate messages and consumers process them. Both producers and consumers run in-memory with configurable speeds and instance counts. The system is designed to help explore concurrency patterns, Spring Boot APIs, and advanced null-safety practices using [JSpecify](https://jspecify.dev).

---

## Features

- In-memory message queue (no external dependencies)
- Dynamic configuration of producer and consumer speeds
- Adjustable number of producers and consumers at runtime
- REST API to control system behavior
- Real-time system statistics
- Clean concurrency handling
- OpenAPI-defined endpoints
- Unit tests using JUnit 5
- Null-safety with JSpecify

---

## Tech Stack

- Java 24
- Spring Boot 3.5
- Gradle
- JUnit 5
- JSpecify ([https://jspecify.dev](https://jspecify.dev))
- SpringDoc OpenAPI

---

## API Documentation

The full API is documented in [`docs/openapi.yaml`](docs/openapi.yaml). 

To view and interact with the API:
- Use [Swagger Editor](https://editor.swagger.io/)
- Or run the app and open Swagger UI: http://localhost:8080/swagger-ui.html

---

## Getting Started

### Prerequisites

- Java 24
- Gradle 7+

### Build & Run

```bash
./gradlew bootRun
```

## Usage

### 🚀 Change Producer Configuration

**POST /v1/producers**

Update the number and speed of producer threads.

**Request Body:**

```json
{
  "count": 3,
  "speed": {
    "value": 1,
    "unit": "SECONDS"
  }
}
```
**Response:**
- 204 No Content on success

### 🎯 Change Consumer Configuration

**POST /v1/consumers**

Update the number and speed of consumer threads.

**Request Body:**

```json
{
  "count": 2,
  "speed": {
    "value": 2,
    "unit": "SECONDS"
  }
}
```

**Response:**
- 204 No Content on success

### 📊 Get System Stats
**GET /v1/stats**

Returns current system state and performance metrics.

**Sample Response:**

```json
{
  "totalMessagesProduced": 150,
  "totalMessagesConsumed": 143,
  "producerCount": 3,
  "consumerCount": 2,
  "producerSpeed": "1 SECONDS",
  "consumerSpeed": "2 SECONDS",
  "producedPerMinute": 60,
  "consumedPerMinute": 30
}
```

## Testing
Run all tests using:

```bash
./gradlew test
```

Test coverage includes:
- REST endpoint behavior
- Concurrency and race conditions
- Speed/throttle configuration edge cases

## Code Quality
This project embraces modern Java practices for code health and safety:

- Null-safety with JSpecify
- Modular, testable design
- Static analysis tools (planned)
- REST contract via OpenAPI
- Clean separation of concerns

Future additions may include integration with static analyzers like SpotBugs, Checkstyle, and JaCoCo for code coverage.

## Planned Improvements
- [ ] Add Server-Sent Events (SSE) or WebSockets for real-time stats
- [ ] Include health and metrics endpoints via Spring Boot Actuator
- [ ] Add Docker support
- [ ] Integration with static code analysis tools
