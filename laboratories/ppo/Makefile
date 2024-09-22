JAVAC = docker compose run --rm java javac
JAVA = docker compose run --rm java java -cp

PHP = docker compose run --rm php php
COMPOSER = docker compose run --rm php composer install --working-dir

PYTHON = docker compose run --rm python python

lab02-java:
	@$(JAVAC) ./exercises/lab02/*.java
	@$(JAVA) ./exercises/lab02 lab02

lab02-php:
	@$(PHP) ./exercises/lab02/lab02.php

lab02-python:
	@$(PYTHON) ./exercises/lab02/lab02.py

lab03-java:
	@$(JAVAC) ./exercises/lab03/*.java
	@$(JAVA) ./exercises/lab03 lab03

lab03-php:
	@$(PHP) ./exercises/lab03/lab03.php

lab03-python:
	@$(PYTHON) ./exercises/lab03/lab03.py

lab04-java:
	@$(JAVAC) ./exercises/lab04/*.java
	@$(JAVA) ./exercises/lab04 lab04

lab04-php:
	@$(PHP) ./exercises/lab04/lab04.php

lab04-python:
	@$(PYTHON) ./exercises/lab04/lab04.py

lab05-java:
	@$(JAVAC) ./exercises/lab05/java/Main.java ./exercises/lab05/java/lab05/*.java
	@$(JAVA) ./exercises/lab05/java Main

lab05-php:
	@$(COMPOSER) ./exercises/lab05/php
	@$(PHP) ./exercises/lab05/php/index.php

lab05-python:
	@$(PYTHON) ./exercises/lab05/python/main.py

lab06-java:
	@$(JAVAC) ./exercises/lab06/java/Main.java ./exercises/lab06/java/lab06/*.java ./exercises/lab06/java/lab06/**/*.java
	@$(JAVA) ./exercises/lab06/java Main

lab06-php:
	@$(COMPOSER) ./exercises/lab06/php
	@$(PHP) ./exercises/lab06/php/index.php

lab06-python:
	@$(PYTHON) ./exercises/lab06/python/main.py

lab07-java:
	@$(JAVAC) ./exercises/lab07/java/Main.java ./exercises/lab07/java/lab07/**/*.java
	@$(JAVA) ./exercises/lab07/java Main

lab07-php:
	@$(COMPOSER) ./exercises/lab07/php
	@$(PHP) ./exercises/lab07/php/index.php

lab07-python:
	@$(PYTHON) ./exercises/lab07/python/main.py

lab08-java:
	@$(JAVAC) ./exercises/lab08/java/Main.java ./exercises/lab08/java/lab08/*.java
	@$(JAVA) ./exercises/lab08/java Main

lab08-php:
	@$(COMPOSER) ./exercises/lab08/php
	@$(PHP) ./exercises/lab08/php/index.php

lab08-python:
	@$(PYTHON) ./exercises/lab08/python/main.py

lab09-java:
	@$(JAVAC) ./exercises/lab09/java/Main.java ./exercises/lab09/java/lab09/*.java ./exercises/lab09/java/lab09/**/*.java
	@$(JAVA) ./exercises/lab09/java Main

lab09-php:
	@$(COMPOSER) ./exercises/lab09/php/index.php
	@$(PHP) ./exercises/lab09/php/index.php

lab09-python:
	@$(PYTHON) ./exercises/lab09/python/main.py

lab10-java:
	@$(JAVAC) ./exercises/lab10/java/Main.java  ./exercises/lab10/java/lab10/*.java ./exercises/lab10/java/lab10/**/*.java
	@$(JAVA) ./exercises/lab10/java Main version
	@$(JAVA) ./exercises/lab10/java Main quote
	@$(JAVA) ./exercises/lab10/java Main quote:popular
	@$(JAVA) ./exercises/lab10/java Main quote:id 2

lab10-php:
	@$(COMPOSER) ./exercises/lab10/php
	@$(PHP) ./exercises/lab10/php/index.php version
	@$(PHP) ./exercises/lab10/php/index.php quote
	@$(PHP) ./exercises/lab10/php/index.php quote:popular
	@$(PHP) ./exercises/lab10/php/index.php quote:id 2

lab10-python:
	@$(PYTHON) ./exercises/lab10/python/main.py version
	@$(PYTHON) ./exercises/lab10/python/main.py quote
	@$(PYTHON) ./exercises/lab10/python/main.py quote:popular
	@$(PYTHON) ./exercises/lab10/python/main.py quote:id 2