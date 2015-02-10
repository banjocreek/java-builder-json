JSON Builders
=============

[![Build Status](https://travis-ci.org/banjocreek/java-builder-json.svg?branch=master)](https://travis-ci.org/banjocreek/java-builder-json)

JSON builder API. 

Defines a builder kernel and interfaces for mutable and
immutable JSON builders.


# Motivation

The javax.json builders can be difficult to use in some
cases because:

* They are single use. Once one emits its object, it clears
  itself.
* They cannot be nested.
* They cannot be constructed from existing Json structures.

This module provides an alternative API for building JSON
structures by addressing the difficulties above and:

* Supporting immutable and mutable builder semantics.
* Continuation of previously-specified path.
* Enhancement of previously-specified path.
* Default object value.
* Array concatenation.

# Usage

## Include Dependencies
```xml
<dependency>
    <groupId>com.banjocreek.riverbed</groupId>
    <artifactId>riverbed-builder-json</artifactId>
    <version>${v.jsonbuilder}</version>
</dependency>
```
See [Maven Central](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.banjocreek.riverbed%22%20AND%20a%3A%22riverbed-builder-json%22) for latest version.


# Implementation

This module adapts classes from the javax.json package. Your
project must include an implementation of javax.json but this
module does not specify one.

The Glassfish imeplementation is used in the tests.

# Versions

While the API is stabilizing, releases will be called 0.x.
No compatibilities between versions with that pattern can be assumed.

The first release with a stable API will be called 1.x and versions
released with that pattern will be backward compatible with
any other 1.x version having smaller x.



