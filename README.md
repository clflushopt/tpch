# Apache Trino TPCHGen Package (Forked)

This is a personal fork of the original Apache Trino TPCHGen tool. The original
reason I forked it was to have a source of truth of TPCH datasets beyond DuckDB's
and is used to provide the seeds for the test suite of my Rust implementation
in [tpchgen-rs](https://github.com/clflushopt/tpchgen-rs).

# Usage

I have tested this on macOS (Darwin 24.1.0) i.e. Sequoia 15.1 on a Macbook M3 and
on Fedora 41 on an AMD workstation.

I didn't fix the several issues I encountered such as all tests fail when run on
macOS but overall you I made it work just enough to get what I want (sorry).

```sh

mvn clean
mvn package
mvn -B test
```

# License

The project is under an Apache 2.0 license see [LICENSE] and thus inherits its parent
license.

# Changes

- Add `Runner.java` to allow a CLI like interface for code generation.
- Plugin a CSV writer to write the data out.
- Disable `checkstyle` since it conflicts with my default LSP formatter.
- Add tests that write to Stdout to make sure things work and are not broken.
