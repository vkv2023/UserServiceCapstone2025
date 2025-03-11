# UserServiceCapstone2025
UserServiceCapstone2025 Authentication Mechanism for User Service

# (Implementing Auth2)
[/https://docs.spring.io/spring-authorization-server/reference/getting-started.html/]:
1- Creating Authorization server 
1.a) Validate the user 
1.b) Generate the token
1.c) Store the token
1.d) Send token to client

Uses OIDC - Open ID Connect extends AUth2  

[//]: # (How-to: Implement core services with JPA)
[//]: # (Authorization server Database)
[/https://docs.spring.io/spring-authorization-server/reference/guides/how-to-jpa.html/]:


[//]: # (RegisteredClientRepository)
1- Define the data model
2- Create JPA entities (as it is in Security -> models package )
3- Create Spring Data repositories ( security -> repositories)
4- Implement core services (services -> services)

[//]: # (Change the @BLOB to @Lob for Client and Authorization)