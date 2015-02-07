JSON Builders
=============

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
* Augmentation of previously-specified paths.
* Augmentation of existing JSON objects.

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



