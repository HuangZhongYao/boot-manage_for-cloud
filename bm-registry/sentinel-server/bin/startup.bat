chcp 65001
set "CURRENT_DIR=%~dp0"
echo CURRENT_DIR: %CURRENT_DIR%
java -jar -Xms300m -Xmx512m  ../lib/sentinel-dashboard-1.8.8.jar --spring.config.location=file:../conf/application.yml