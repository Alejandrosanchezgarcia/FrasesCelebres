# FrasesCelebres
Proyecto de clase donde se muestran una frases célebres y sus autores.
Puede visualizarlo en java o en javaFx.

# Autores
Alejandro Sanchez Garcia
Carmen Mª Rufo Palomo

# Cómo Visualizar este proyecto.

1- Asegurese de tener instalado MySQL en su versión 14.14 distrib 5.7.30.
Para comprobarlo puede usar el comando $mysql --version

2- Compruebe que sus credenciales como usuario son:
usuario= root
password = root

Si no es asi puede cambiarlo en la clase ServiceFrase en su línea 36 
ruta: FrasesCelebres/src/main/java/com/aula114/bean/ServiceFrase

3- Cree la database, solamente tendra que copiar el contenido del archivo dump.sql en entorno MySQL.

4- Cabe destacar que puede ejecutar el programa tanto en java como en javaFx.
Tan solo deberá indicar que main quiere ejecutar.
java --> Main.java
javaFx --> MainFx.java

Deben ser ejecutados en la carpeta donde se encuentra el pom.xml

Los comandos son:

4.1- mvn clean compile (en caso de tener algún target ya creado)
4.2- mvn dependency:copy-dependencies package
4.3.1- para java--> java -cp target/JSFMaven.jar:target/dependency/*:. com.aula114.bean.Main
4.3.2- para javafx--> java -cp target/JSFMaven.jar:target/dependency/*:. com.aula114.bean.MainFx

