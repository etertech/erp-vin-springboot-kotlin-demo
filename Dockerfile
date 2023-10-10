# Utilisez l'image officielle OpenJDK 17 comme base
FROM openjdk:17-jdk-slim

# Créez un volume pour /tmp
VOLUME /tmp


# Copiez le JAR de votre application dans l'image
COPY build/libs/erpvin-0.0.1-SNAPSHOT.jar app.jar

# Exposez le port de votre application si nécessaire
EXPOSE 8089

# Exécutez l'application
ENTRYPOINT ["java","-jar","/app.jar"]