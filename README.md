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
- Or run the app and open Swagger UI:
