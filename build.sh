./gradlew --stop
./gradlew --build-file api/build.gradle clean jibDockerBuild
docker push nyttevaerdien/homepage-api:2.0.0

cd frontend
docker build . -t nyttevaerdien/homepage-frontend:2.0.0
docker push nyttevaerdien/homepage-frontend:2.0.0
