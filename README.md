# Plateforme de Réservation d'Ateliers Artisanaux avec Spring Boot 

## Description
Ce projet vise à créer une application de gestion des ateliers artisanaux, permettant aux utilisateurs de consulter la liste des ateliers, de réserver des créneaux et d'annuler des réservations. 
C'est une projet Spring Boot, générer avec Spring Initializr  incluant les dépendances Spring Web, Thymeleaf, Spring Data JPA, et MySQL Driver.

## Pour commencer

### Prérequis
- Configurez votre IDE et le fichier application.properties pour la connexion à MySQL
- Créez une base de données via MySQL Workbench.

### Visualiser l'arborecence du projet
-Assurez de suivre l'architecture MVC
 ↓**demoReservationArtisnaux**
 →controllers
 →entities
 →repositories
 →services
 →serviecesImp
 →ressources
 templates 

 ### Installation

1. installer les dependances necessaires:
- Spring Web, Thymeleaf, Spring Data JPA, et MySQL Driver.

2.Lancez l'application :
 - maven->updateProjects
 - maven clean
 - maven install
 - run javaApplication

### Fonctionnalités demandés

 Affichage de la liste des ateliers
• Réservation un créneau
• Annuler une réservation

## Technologies Utilisées

- Spring Initializer: générer un projet SpringBoot
- Hibernate et JPA: persistance de données
- Thymeleaf: templates
- Mysql workbench: base de données
- Architecture MVC
- Repository : hériter les methode CRUD
- Requette HTTP

##  Préparation pour le Déploiement
- la class main étend : SpringBootServletInitializer
- insérer le plugin Maven spring-boot-maven-plugin dans le fichier pom.xml

##  les ressources sur Git


## Auteur:

- *Titi Sana Asma*

## Remerciements

Un grand merci à l'enseignante, *Amal Boukhdhir*, pour avoir fourni les explications détallée au niveau de toute la session.

 
