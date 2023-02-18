#### EclipsLink ORM Tool : one of the JPA implementation 

- if there is no schema in database then this App will through error .
- In this App auto ddl configuration used in persistece file means if we create buisness entity i.e class specified by `Entity` annotations 
if this entity mapped table not present in database then this config will create table if not available and if available then use existing for data persisance of this entity
- if mapped entity table not available in database and table created dynamically using App then order of column in that table ,will not be the same as the order of fields in business entity.it will create column in albhabetically order.

- There is no "findAll" method in JPA API. Spring Data JPA has one but that is NOT the JPA API, and it is hardly "more elegant", simply hiding JPA API code and making the user further from the real code

##### steps while creating this JPA application 
  1. created  persistent.xml file in resources/META-INF folder structure.
  2. to communicate application with the database we need to obtain Persistence Context.
     ```
     Persistence Context is an environment or cache 
     where entity instances(which are capable of holding data and thereby having the ability 
     to be persisted in a database) are managed by Entity Manager.It syncs the entity with database.
     All objects having @Entity annotation are capable of being persisted.
     @Entity is nothing but a class which helps us create objects in order to communicate with the database.
     And the way the objects communicate is using methods.And who supplies those methods is the Entity Manager.
     
     ```
  3. we can access the Persistence Context by using the APIs in EntityManager.
  4. EntityManager instance get through EntityManagerFactory instance and it is obtained by bootstrap class Persistence as below .
```
EntityManagerFactory emfactory 
  = Persistence.createEntityManagerFactory("value of name attribute of persistence-unit tag in persistent.xml file");      
EntityManager entitymanager = emfactory.createEntityManager();
```
 5. Every time we call createEntityManager() method, it will return a new instance of EntityManager.
 6. the object referenced by an entity is managed by entity manager .i.e An EntityManager object manages a set of entities that are defined by a persistence unit.
 7. EntityManager interface is used to allow applications to manage and search for entities in the relational database.

#### Query

- can we tell JPA/hibernate tool to create ddl with specific column order ? 
>For now it generate ddl and sort columns with propery name order.

#### Tips
```
our code should never depend on the ordering of columns in the database.
there is technically no guarantee that columns will be returned in a particular order when you SELECT *.
If you want the columns in a particular order, specify it in your SQL query.

we should create the database via separately maintained database scripts.
Maintaining the database via scripts becomes much more necessary once the application goes into production.

```

#### if we close jpa entitymanager ?
>Answer1
```
After calling close, the application must not invoke any further methods on the EntityManager
instance except for getTransaction and isOpen , or the IllegalStateException will be thrown. 
If the close method is invoked when a transaction is active, the persistence context remains
managed until the transaction completes.
```
[refference](https://stackoverflow.com/questions/10762974/should-jpa-entity-manager-be-closed#:~:text=The%20EntityManager.,the%20IllegalStateException%20will%20be%20thrown.).
>Answer2
 : it totally depends on how we want to used trnsaction in our application.
```
Actually entity manager is the key to get access to the persistence context where all the entities reside.
If our application is a JSE application then we have to consider what is the life expectancy of your context.

Let's consider that you will create an entity manager per user's request.
So,while you are attending a given request,you will keep your entity manager open, and when you finish with it,you close it.

In a JSE application, you may have considered that you would like to keep your entity manager open 
the entire life of the application (supposing you're not dealing with big amounts of data) then you close it
when your application shuts down.

Bottom line, when you open it and when you close depends entirely on your strategy and your design.
You close it when you no longer need the entities in its context.

In your example,since we are creating the EM in the method, we should close it before returning,
otherwise, we will no longer have access to it again (unless you're keeping it in some registry, which is not evident in the code).


```

### `read more about `[ JPA ](https://github.com/DeepakZunzunkar/Study-Material/blob/master/JAVA/JPA.md)
