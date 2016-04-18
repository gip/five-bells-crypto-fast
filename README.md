# five-bells-crypto-fast

A module for fast crypto operations. 

## Routes

`PUT /crypto/ps256/sign`

## Starting the server

Install `sbt`, version `0.13.x` or newer

Create DER file for the private key using openssl:

`openssl pkcs8 -topk8 -inform PEM -outform DER -in private_key.pem -out private_key.der -nocrypt`

Start the server:

`sbt "run <path_to_der_file>"`