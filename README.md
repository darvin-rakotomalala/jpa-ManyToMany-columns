## Spring Data JPA/Hibernate | Many-To-Many with columns
Dans ce repo, nous allons voir un exemple d'API REST CRUD de mappage ManyToMany avec des colonnes supplémentaires à l'aide de Spring Boot.

### Technologies
---
- Java 11
- Spring Boot 2.7.7
- Spring Data JPA
- Lombok
- MapStruct
- Maven 3+
- PostgreSQL

### Exemple
---
En supposant que nous ayons les tables de base de données suivantes :
* Entité `Book`
* Entité `Publisher`
* Entité `book_publisher` - en tant qu'entité avec 2 relations plusieurs-à-un avec les entités Book et Publisher.
* On peut publier un livre dans différents formats, comme un livre électronique, un livre de poche et une couverture rigide. Chaque format peut être publié par un éditeur différent. C'est pourquoi le format est stocké dans la colonne format de la table BookPublisher.

### Exécuter et tester le projet
---
- Exécuter l'application `mvn spring-boot:run`
- Importer dans Postman la collection `jpa-ManyToMany-columns.postman_collection.json` pour tester les APIs
- Vous pouver utiliser aussi l'url du Swagger ou importer l'url Swagger dans Postman
	- Les descriptions OpenAPI seront disponibles au chemin `/v3/api-docs` par défaut : http://localhost:8081/v3/api-docs/ et/ou http://localhost:8081/swagger-ui/index.html