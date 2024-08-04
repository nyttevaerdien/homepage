# frontend/Dockerfile
FROM node:22.5.1-alpine AS prod

WORKDIR /app

COPY . /app

RUN npm install

CMD ["npm", "start"]

