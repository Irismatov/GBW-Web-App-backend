# Base image
FROM openjdk:17-jdk-slim

# Ilova uchun port
EXPOSE 7878

# Ilova nomi va versiyasi
ARG JAR_FILE=target/your-application-name.jar

# Ilova faylini konteynerga ko'chirish
COPY ${JAR_FILE} app.jar

# Ilovani ishga tushirish
ENTRYPOINT ["java", "-jar", "app.jar"]