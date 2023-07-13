# project-db
The final project of the fourth module of the JavaRush quest https://javarush.com/quests/lectures/jru.module4.lecture08

Description
-------

Demonstration of increasing the performance of a query to the database.
Used technologies: MySQL, Hibernate, Redis, Docker.

We have a relational database query that is running slowly. We can speed it up and put frequently requested data into the
Redis(in-memory key-value data store).

Result
----------
<img width="1010" alt="Снимок экрана 2023-03-15 в 15 15 24" src="https://user-images.githubusercontent.com/105919648/225336727-e0a6bc75-e806-4278-a815-067f8f9de825.png">

Application entry point
---------
*com/javarush/tchaban/mysqldb/Main.java*
