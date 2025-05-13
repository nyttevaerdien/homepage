# frontend/Dockerfile
FROM node:22.5.1-alpine AS prod

WORKDIR /app

COPY . /app

RUN npm install -g serve

RUN npm install

RUN NODE_OPTIONS=--openssl-legacy-provider npm run build

# Expose the port the application will run on
EXPOSE 3000

# Set the default command to serve the app
CMD ["serve", "-s", "build", "-l", "3000"]
