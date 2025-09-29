@echo off
REM Clean all generated keystore/truststore and exported certs in current folder
setlocal
set FILES=serverkeystore.jks clienttruststore.jks clientkeystore.jks servertruststore.jks server.cer client.cer

for %%F in (%FILES%) do (
  if exist "%%F" (
    echo Deleting %%F
    del /f /q "%%F"
  )
)

echo Done. Removed keystores/truststores and exported certs.
endlocal
