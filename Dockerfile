FROM maven:3.9.6-amazoncorretto-21 AS builder

WORKDIR /app

# Copia apenas o necessário para o build (pom e código fonte)
COPY pom.xml .
COPY src ./src

# Baixa dependências e empacota (pulando testes para acelerar)
RUN mvn -B -DskipTests package

FROM amazoncorretto:21-alpine AS runtime

# Create non-root user for security
RUN addgroup -g 1000 appgroup && \
    adduser -u 1000 -G appgroup -s /bin/sh -D appuser

# Set working directory
WORKDIR /app

# Ensure log directory exists and is writable by the non-root user
RUN mkdir -p /var/log/classinsight && \
    chown -R appuser:appgroup /var/log/classinsight

ARG SERVICE_NAME
ENV SERVICE_NAME=${SERVICE_NAME}

# Copia o JAR gerado pelo estágio de build
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

USER appuser

ENTRYPOINT ["java", "-jar", "app.jar"]