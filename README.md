---
Designed & implemented by **Thomas Ravi**
---

# Automation Framework - Selenium + Cucumber + TestNG + Docker Grid

# Overview

This project is a scalable automation framework built using:

- Selenium 4
- Cucumber (BDD)
- TestNG
- REST Assured (API automation)
- Selenium Grid 4 (Dockerized)
- GitHub Actions CI
- Parallel Execution
- ThreadLocal WebDriver Management

The framework supports:
- UI Automation
- API Automation
- Cross-browser testing
- Parallel execution
- Docker-based Grid execution
- CI integration

---

# Architecture Design

# Execution Modes

The framework supports two execution modes:

| Mode | Description |
|------|------------|
| Local | Runs browser locally for debugging |
| Grid | Runs tests on Dockerized Selenium Grid |

Execution is controlled using system property:
-Dexecution=local
-Dexecution=grid


---

# Browser Control

Browser can be switched dynamically:
-Dbrowser=chrome
-Dbrowser=firefox



---

# Thread Safety

- WebDriver is managed using `ThreadLocal`
- Supports parallel execution via TestNG DataProvider
- Avoids driver collision

---

# Selenium Grid Setup (Docker)

Grid is configured using `docker-compose.yml`:

- Selenium Hub 4.21.0
- Chrome Node
- Firefox Node
- Event-driven distributed architecture

Start Grid:
docker compose up -d


Stop Grid:
docker compose down


---


# Parallel Execution

Parallel execution implemented at scenario level:

@DataProvider(parallel = true)
Thread count can be controlled via TestNG.

---

# Retry Mechanism

Failed scenarios are captured and re-run using:
rerun:target/failed.txt

---

# CI Integration

GitHub Actions pipeline includes:
API Test Job
UI Test Job
Docker Grid startup
Grid health-check validation
Artifact upload
Container shutdown
CI always runs in Grid mode.

---

# How To Run
Run API Tests
mvn clean test -Dcucumber.filter.tags="@api"
Run UI Tests (Local)
mvn clean test -Dcucumber.filter.tags="@ui"
Run UI Tests (Grid)
docker compose up -d
mvn clean test -Dcucumber.filter.tags="@ui" -Dexecution=grid
docker compose down

---

# Key Highlights

Clean separation of UI & API runners
Environment-aware driver initialization
Dockerized infrastructure
Cross-browser support
Parallel-safe framework
CI-ready architecture
Scalable Grid setup
