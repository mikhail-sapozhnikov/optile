# README for the Optile test automation task

Test suite contains 5 cases:
1) Login and Logout
2) Upload File
3) Delete File (combined with file upload)
4) Create Folder
5) Change Name

Note: Upload File functionality was tested only on Windows OS and should fail on other OS, please tell me if it is needed for another OS

In order to run tests please enter needed parameter values in the testng.xml file, which can be found in ./src/test/resources folder:
1) "login" and "pass" - Dropbox login credentials
2) "filePath" - absolute path to a file which should be uploaded to Dropbox, for example: "C:\TestFolder\pic01.png"
3) "fileName" - name of the file, for example: "pic01.png"

### Steps to run tests:

1) Install JDK 8 and Maven on your PC
2) Configure environment variables for JDK 8 and Maven
3) Clone project files to any folder
4) From the src/test/resources folder run below command for Linux:
```bash
chmod +x chromedriver_linux64
```
For Mac:
```bash
chmod +x chromedriver_mac64
```
5) From the project's root directory run below command (Chrome browser should be installed):
```bash
mvn clean test
```