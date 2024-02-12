FROM eclipse-temurin:21-jdk AS builder
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install -DskipTests


FROM eclipse-temurin:21-jre
WORKDIR /opt/app
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
EXPOSE 7000:7000
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]
