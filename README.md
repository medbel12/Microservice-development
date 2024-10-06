# Fonctionnalités
## Le projet inclut les fonctionnalités suivantes :

## Création de projet Spring Boot :

Utilisation des dépendances Web, Spring Data JPA, H2, et Lombok.
### Création de l'entité JPA Compte :

L'entité représente un compte bancaire avec des attributs comme id, balance, type, etc.
### Création de l'interface CompteRepository :

Basée sur Spring Data, cette interface fournit des opérations CRUD sur les comptes.
Test de la couche DAO :

Tests de la couche de persistance pour s'assurer du bon fonctionnement de CompteRepository.
### Création d'un service RESTful :

Un contrôleur REST permettant la gestion des comptes via des opérations GET, POST, PUT, DELETE.
### Documentation Swagger :

Génération de la documentation API à l'aide de Swagger pour tester et visualiser les endpoints REST.
### Exposition de l'API RESTful avec Spring Data Rest :

Utilisation de projections pour personnaliser les réponses des endpoints RESTful.
### Création de DTOs et Mappers :

Utilisation de DTOs et Mappers pour transférer les données entre les couches.
### Création de la couche Service :

La couche Service contient la logique métier de l'application.
### Intégration de GraphQL :

Un service GraphQL est mis en place pour permettre l'interaction avec les comptes bancaires via des requêtes GraphQL.
