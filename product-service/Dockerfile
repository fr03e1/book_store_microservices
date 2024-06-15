# BUILDER
FROM maven:3.8.5-openjdk-17 AS builder
ARG ENVIRONMENT=test
ENV ENVIRONMENT=${ENVIRONMENT}

WORKDIR /app

COPY pom.xml .

RUN --mount=type=cache,target=/root/.m2 \
    mvn dependency:go-offline

COPY . .

RUN mvn clean package -P ${ENVIRONMENT}

# RUNNER
FROM openjdk:17
WORKDIR /app

COPY --from=builder /app/target/product-service.jar ./

ENTRYPOINT ["java", "-jar", "/app/product-service.jar"]