call runcrud.bat
if "%ERRORLEVEL%" == "0" goto startbrowser
echo.
echo SHOWTASKS has errors – breaking work
goto fail

:startbrowser
start "" http://www.stackoverflow.com
start "" http://localhost:8080/crud/v1/task/tasks

:fail
echo.
echo There were errors