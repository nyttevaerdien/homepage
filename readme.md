My homepage application. Consists of 3 services:
- nginx: used as reverse proxy
- api: api for some homepage data (e.g. current obsession)
- frontend: react app serving static html

To build the artifacts run
`bash build.sh`

To start the application run
`cd configuration && docker compose up -d`

To open requests first install bruno
`brew install --cask bruno`

To apply configuration on server run
`cd configuration && scp -r . root@217.160.164.219:app/`

