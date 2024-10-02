#!/bin/bash

# Function to retrieve version number from build.gradle
get_version() {
    echo "$(grep "^version" api/build.gradle | awk -F= '{print $2}' | tr -d '[:space:]' | sed 's/^"\(.*\)"$/\1/')"
    }

# Check if a parameter was passed
if [ -z "$1" ]; then
    echo "Usage: $0 <semicolon-separated service names>"
    exit 1
fi

API_BASE_URL="$2"
API_USERNAME="$3"
API_PASSWORD="$4"

# Read the semicolon-separated list of services
IFS=';' read -ra SERVICES <<< "$1"

VERSION=$(echo "$(get_version)" | cut -c 2- | rev | cut -c 2- | rev)
echo "Version is $VERSION"

# Loop through each service and execute corresponding command
for SERVICE in "${SERVICES[@]}"; do
    case "$SERVICE" in
        api)
            echo "building api..."
            cd api
            ./gradlew --stop
            ./gradlew --build-file api/build.gradle clean jibDockerBuild
            cd ..
            ;;
        frontend)
            echo "building frontend..."
            cd frontend

            ENV_FILE=".env"
            echo "REACT_APP_API_BASE_URL=$API_BASE_URL" > $ENV_FILE
            echo "REACT_APP_API_USERNAME=$API_USERNAME" >> $ENV_FILE
            echo "REACT_APP_API_PASSWORD=$API_PASSWORD" >> $ENV_FILE

            docker build . -t nyttevaerdien/homepage-frontend:$VERSION
            cd ..
            ;;
        push_images)
            echo "pushing docker images..."
            docker push nyttevaerdien/homepage-api:$VERSION
            docker push nyttevaerdien/homepage-frontend:$VERSION
            ;;
        *)
            echo "Unknown service: $SERVICE"
            ;;
    esac
done

