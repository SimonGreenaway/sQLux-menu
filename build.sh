cd src
javac -cp ../apache-commons-collections4.jar sqlux/SqluxMenu.java sqlux/Ini.java
java -cp ../apache-commons-collections4.jar:. sqlux.SqluxMenu
