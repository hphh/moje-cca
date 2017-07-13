set PROJECT_DIR=c:\Users\her\git\moje-cca
set PROJECT_NAME=moje-cca

net stop mojeCca
set PROD_DIR=%~dp0
cd %PROJECT_DIR%

call mvn clean package -P prod

cd %PROD_DIR%

copy %PROJECT_DIR%\target\%PROJECT_NAME%-swarm.jar .\

net start mojeCca

pause