FROM openjdk:17
EXPOSE 8084
ADD "target/commande-0.0.1-SNAPSHOT.jar" "commande.jar"
ENTRYPOINT ["java","-jar","commande.jar"]