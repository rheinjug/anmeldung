# DEVELOPMENT
FROM gradle:jdk11
EXPOSE 8080
WORKDIR /anmeldung
COPY . /anmeldung
RUN gradle bootJar
ENTRYPOINT java -jar /anmeldung/build/libs/anmeldung.jar
