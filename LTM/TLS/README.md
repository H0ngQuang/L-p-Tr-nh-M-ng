# TLS/SSL Java Demo (Sockets)

## Structure
- `src/NormalServer.java` / `src/NormalClient.java` — TCP plaintext for Wireshark comparison
- `src/TLSServer.java` / `src/TLSClient.java` — TLS one-way (server keystore, client truststore)
- `src/MTlsServer.java` / `src/MTlsClient.java` — TLS mutual (2-way SSL)
- `scripts/create-certs.bat` / `scripts/create-certs.sh` — generate keystores/truststores

## Quick start
1. Open a terminal at this folder.
2. Generate certs:
   - Windows: `scripts\create-certs.bat`
   - Linux/Mac: `chmod +x scripts/create-certs.sh && scripts/create-certs.sh`
3. Run plaintext:
   - Start `NormalServer` then `NormalClient` (port 8080).
4. Run TLS one-way:
   - Start `TLSServer` then `TLSClient` (port 8443).
   - Optional handshake logs: JVM option `-Djavax.net.debug=ssl`.
5. Run mTLS:
   - Start `MTlsServer` then `MTlsClient`.
   - Try connecting `TLSClient` to `MTlsServer` (should fail due to missing client cert).

Password used for demo: `123456`.
