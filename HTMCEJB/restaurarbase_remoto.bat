@echo off

: Sets the proper date and time stamp with 24Hr Time for log file naming
: convention
set anio=%date:~-4,4%
set mes=%date:~-7,2%
set dia=%date:~-10,2%
set Milliseconds= %time:~-2,2%
set Seconds= %time:~-5,2%
set Minutes= %time:~-8,2%
set Hours= %time:~-11,2%

set final_archivo=%anio%%mes%%dia%%Hours%%Minutes%%Seconds%
ECHO %final_archivo%
d:
cd "E:\workspaces\HTMCEJB"
dir *.dump

echo Este batch cargara la nueva base de datos de casos
pause
c:
cd "C:\Program Files\PostgreSQL\9.3\bin"
set /p nombre_archivo=Ingrese el nombre del respaldo: 

rem psql -h 172.16.14.26 -p 5432 -U postgres < E:\workspaces\HTMCEJB\%nombre_archivo%.dump
psql -h localhost -p 5432 -U postgres < E:\workspaces\HTMCEJB\%nombre_archivo%.dump
pause
echo Espero se haya restaurado la base de datos
pause
exit

