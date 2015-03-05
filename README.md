# Clojure SQL Shootout

When it comes to accessing databases Clojure has some great libraries for abstracting SQL. This repository compares several of these by implementing the same code using each of the libraries. What I've done is setup a really simple user database containing a list of users and their groups and for each library I've tried to see what it takes to retrieve the details for a specific user and their group memeberships.

The list of libraries that were tested is as follows:
* [clojure.java.jdbc](https://github.com/clojure/java.jdbc)
* [Aggregate](https://github.com/friemen/aggregate)
* [HoneySQL](https://github.com/jkk/honeysql)
* [Korma](http://sqlkorma.com/)
* [OJ](https://github.com/taylorlapeyre/oj)
* [SQLingvo](https://github.com/r0man/sqlingvo)
* [Yesql](https://github.com/krisajenkins/yesql)

## Usage

The easiest way to see to test the code is to load the file for the particular library into the REPL, for example `(use 'shootout.korma)`, and then call `(get-user-groups "joebloggs")`.

## License

Copyright © 2015 Anthony Manoras

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
