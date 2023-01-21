#### EclipsLink ORM Tool : one of the JPA implementation 

- if there is no schema in database then this App will through error .
- In this App auto ddl configuration used in persistece file means if we create buisness entity i.e class specified by `Entity` annotations 
if this entity mapped table not present in database then this config will create table if not available and if available then use existing for data persisance of this entity
- if mapped entity table not available in database and table created dynamically using App then order of column in that table ,will not be the same as the order of fields in business entity.it will create column in albhabetically order.

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

