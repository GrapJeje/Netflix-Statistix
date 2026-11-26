# Netflix Statistix

## Benodigdheden

Om het project te kunnen starten heb je de volgende programma's nodig:

- Java 21
- IntelliJ IDEA
- Docker Desktop
- Maven

## Project opstarten

### 1. Project downloaden

Clone de repository naar je computer en open het project in IntelliJ IDEA.

### 2. Docker starten

Zorg ervoor dat Docker Desktop actief is.

Open de terminal in de hoofdmap van het project en voer het volgende commando uit:

```bash
docker compose up -d
```

Hiermee wordt de PostgreSQL-database gestart.

### 3. Environment variables instellen

Maak in de hoofdmap van het project een `.env`-bestand aan.

Vul hierin de volgende gegevens in:

```dotenv
DB_NAME=netflixstatistix
DB_USERNAME=root
DB_PASSWORD=test
DB_PORT=5432
```

### 4. Spring Boot starten

Open het project in IntelliJ IDEA.

Zoek de hoofdklasse van de Spring Boot-applicatie en start deze door op de groene startknop te klikken.

Spring Boot maakt verbinding met de PostgreSQL-database. Hibernate maakt vervolgens de benodigde tabellen aan op basis van de entities.

### 5. Controleren of alles werkt

Je kunt in IntelliJ IDEA bij het Database-venster controleren of de database verbonden is.

De database heet `netflixstatistix`. Onder `schemas > public > tables` kun je de aangemaakte tabellen bekijken.
