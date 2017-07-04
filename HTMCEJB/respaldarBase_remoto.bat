@echo off

echo Este batch hara un respaldo de la base de datos htmc
pause
set RutaPostgres="C:\Program Files\PostgreSQL\9.3\bin"

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

set /p nombre_archivo=Ingrese el nombre del respaldo: 
c:
cd "C:\Program Files\PostgreSQL\9.3\bin"
pause
rem pg_dump -h 172.16.14.26 -p 5432 -U postgres -C -f E:\workspaces\HTMCEJB\%nombre_archivo%.dump sci_htmc
pg_dump -h localhost -p 5432 -U postgres -C -f E:\workspaces\HTMCEJB\%nombre_archivo%.dump sci_htmc

pause
echo Espero se haya creado el respaldo de la base de datos
pause
exit

