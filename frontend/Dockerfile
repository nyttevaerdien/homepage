# frontend/Dockerfile
FROM node:22.5.1-alpine AS prod

# Set build arguments for environment variables
ARG REACT_APP_API_USERNAME
ARG REACT_APP_API_PASSWORD

WORKDIR /app

COPY . /app

RUN npm install -g serve

RUN npm install

RUN npm run build

# Expose the port the application will run on
EXPOSE 3000

# Set the default command to serve the app
CMD ["serve", "-s", "build", "-l", "3000"]
