#### EclipsLink ORM Tool : one of the JPA implementation 

- if there is no schema in database then this App will through error .
- In this App auto ddl configuration used in persistece file means if we create buisness entity i.e class specified by `Entity` annotations 
if this entity mapped table not present in database then this config will create table if not available and if available then use existing for data persisance of this entity
- if mapped entity table not available in database and table created dynamically using App then order of column in that table ,will not be the same as the order of fields in business entity.it will create column in albhabetically order.

- There is no "findAll" method in JPA API. Spring Data JPA has one but that is NOT the JPA API, and it is hardly "more elegant", simply hiding JPA API code and making the user further from the real code

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
```
After calling close, the application must not invoke any further methods on the EntityManager
instance except for getTransaction and isOpen , or the IllegalStateException will be thrown. 
If the close method is invoked when a transaction is active, the persistence context remains
managed until the transaction completes.
```
