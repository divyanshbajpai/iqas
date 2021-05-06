# iqas
Automated FAQ Bot generation through Knowledge Source

Components:

- Model: Contains dockerized Inference model accessible over REST API.
- Server: Contains the impelentation of API which end-users will consume. //to-do swagger
- Admin-client: Contains the UI for the admin (managing Knowledge bases)
- Client: Contains UI for end-users(querying for answers)

## Installation

### Server

- Run mongodb in Docker
``sh
docker run -d -p 27017:27017 --name iqas-mongo -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=secret mongo
``
- Open IntelliJ or Eclipse
- New Project -> Existing Maven Project from VCS -> point to this repo
- Assuming the above steps works
- Maven dependency installation will start in backgroud, might take a while
- Navigate to 'ServerApplication.java' and run as 'spring application'

## Building documentation

Install `mkdocs`.

Run `npm run build:docs` to build the site and add the swagger spec.

