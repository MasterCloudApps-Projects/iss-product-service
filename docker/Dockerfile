FROM maven:3.6.3-jdk-11-slim AS BUILD_STAGE
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -B -f pom.xml clean package -DskipTests

FROM openjdk:11-jdk-slim
COPY --from=BUILD_STAGE /workspace/target/iss-product-service*.jar iss-product-service.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","iss-product-service.jar"]