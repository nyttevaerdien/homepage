My homepage application. Consists of 3 services:
- nginx: used as reverse proxy
- api: api for some homepage data (e.g. current obsession)
- frontend: react app serving static html

To build the artifacts run
`./build.sh "api;frontend;push_images"`

To start the application run
`docker compose up -f configuration/docker-compose.yml -d`

To open requests first install bruno
`brew install --cask bruno`

To apply configuration on server run
`scp -r configuration/* root@217.160.164.219:app/`

