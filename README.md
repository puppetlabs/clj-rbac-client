# rbac-client

A Clojure library designed to hold lightweight api clients for pe services.

## Usage

The clients are meant to provide alternate versions of the TK services.
You should be able to merely include them in the bootstrap.

### Configuration

The clients use ssl authorization vs the global.certs keys.

- `global.certs.ssl-key`: the key for this clients identity.
- `global.certs.ssl-cert`: the cert for this clients identity.
- `global.certs.ssl-ca-cert`: the ca-cert for this clients cert and the upstream service.

The location of the rbac and activity services are configured with the
`rbac-consumer.api-url` and `activity-consumer.api.url` settings respectivetly

### Activity

The activity service protocol should be considered temporary and unstable. It's
unclear to me how well this matches the activity reporting service or how stable
that protocol is.

## Testing

The tests require pki files in the `dev-resources/ssl/` directory of:
  * `ca.pem`: a CA cert with the CN of "puppet"
  * `key.pem`: a node private key
  * `cert.pem`: a cert signed by `ca.pem` for the private key at `key.pem` with a CN of "localhost"
  * `alternate-ca.pem`: a valid but untrusted CA cert

The repo contains these files needed for testing, though if needed you may
want to read `dev-resources/gen-pki.sh` for the commands to generate additional
sets of files.

## License

Copyright © 2016 Puppet

Distributed under the Apache License version 2.0
