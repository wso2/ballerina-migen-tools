# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Fixed
- Fixed an infinite recursion bug in `XmlPropertyWriter` caused by cyclic nested `UnionFunctionParam` types (e.g. `ClientCredentialsGrantConfig`). The generator now tracks visited types and stops recursive property unrolling cleanly, generating accurate bounded `init.xml` parameters and preventing runtime `SynapseException` mapping failures.

## [1.0.0] - 2025-02-05

### Added
- Initial release of the `ballerina-migen-tools` framework.
