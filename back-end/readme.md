# Back-End Nox Study
## Edit Data Model
https://app.diagrams.net/?libs=general;uml#G12-2A2GoSeEhGe6eZasPhUrWICUWk2bql

## Installation
- Install the docker to the machine
- Go to noxstudy/back-end to start the PostgresSQL database
```bash
docker-compose -f .\docker-compose.postgres.yml up -d
```
- Open **CLI** of **postgres_container** in Docker-Desktop to access database and see if it works with this syntax: psql -U <user-name> -W <database-name>
```
psql -U postgres -W nox-study
```
For Mac issue:
vi .bash_profile
Press i
Add: export PATH=/Library/PostgreSQL/9.6.10/bin:$PATH
esc -> :wq to save

For pgadmin connect:
docker inspect container_id -> Get ipv4 to host field

## Usage
- Run the class NoxStudyApplication
- Check the api to make sure the back-end works well
    - http://localhost:8080/api/no-auth/health-check

* Authentication:
    - http://localhost:8080/api/authenticate
        - Guess:
         ```bash
             username: guess@gmail.com
             password: 123
         ```

        - Student:
        ```bash
            username: student@gmail.com
            password: 123
        ```

        - Teacher:
        ```bash
            username: teacher@gmail.com
            password: 123
        ```

        - Administrator:
        ```bash
            username: admin@gmail.com
            password: 123
        ```