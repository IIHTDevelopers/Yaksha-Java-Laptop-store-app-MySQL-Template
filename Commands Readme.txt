BackEnd-Commands
* cd into your backend project folder

* To build your project use command:
	mvn clean package -Dmaven.test.skip

* To launch your application, move into the target folder (cd target).  Run the following command to run the application:
	java -jar <your application jar file name>

* Please use 127.0.0.1 instead of localhost to test rest endpoints.

* Default credentials for MySQL:
	Username: root
	Password: pass@word1

* To login to mysql instance: Open new terminal and use following command:
	-sudo systemctl enable mysql
	-sudo systemctl start mysql
	-mysql -u root -p
	The last command will ask for password which is ‘pass@word1’

* Mandatory: Before final submission run the following command:
	mvn test

* You need to use CTRL+Shift+B - command compulsorily on code IDE, before final submission as well. This will push or save the updated contents in the internal git/repository, and will be used to evaluate the code quality.



