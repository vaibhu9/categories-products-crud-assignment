FROM openjdk:21

WORKDIR /categories-products-crud-assignment

COPY /build/libs/categories-products-crud-assignment-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9090

ENTRYPOINT [ "java", "-jar", "app.jar" ]