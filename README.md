# Prerequisites

- Java 17
- Maven 3.8+
- Docker (only for Grid mode)

# Running API Tests
mvn clean test -Dcucumber.filter.tags="@api"

# Running UI Tests (Local)
mvn clean test -Dcucumber.filter.tags="@ui"

# Running UI Tests (Grid)
docker compose up -d
mvn clean test -Dcucumber.filter.tags="@ui" -Dexecution=grid
docker compose down