@echo off
set PASS=123456

REM === Server side ===
keytool -genkeypair -alias server -keyalg RSA -keysize 2048 -keystore serverkeystore.jks -storepass %PASS% -dname "CN=localhost, OU=Demo, O=Demo, L=HN, ST=HN, C=VN" -validity 365
keytool -export -alias server -keystore serverkeystore.jks -storepass %PASS% -file server.cer

REM Trust for 1-way TLS (client trusts server)
keytool -import -alias server -file server.cer -keystore clienttruststore.jks -storepass %PASS% -noprompt

REM === Client side (for mTLS) ===
keytool -genkeypair -alias client -keyalg RSA -keysize 2048 -keystore clientkeystore.jks -storepass %PASS% -dname "CN=tls-client, OU=Demo, O=Demo, L=HN, ST=HN, C=VN" -validity 365
keytool -export -alias client -keystore clientkeystore.jks -storepass %PASS% -file client.cer

REM Server trusts client (for mTLS)
keytool -import -alias client -file client.cer -keystore servertruststore.jks -storepass %PASS% -noprompt

echo Done. Generated: serverkeystore.jks, clienttruststore.jks, clientkeystore.jks, servertruststore.jks
