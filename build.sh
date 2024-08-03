./gradlew --stop
./gradlew clean
./gradlew --build-file model/build.gradle build
./gradlew --build-file api/build.gradle jibDockerBuild
./gradlew --build-file frontend/build.gradle jibDockerBuild
docker push nyttevaerdien/homepage-frontend:1.3.0
docker push nyttevaerdien/homepage-api:1.3.0
