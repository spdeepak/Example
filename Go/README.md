# GO Example Projects



## Testing Go applications

* Run all tests in current directory`
  * `go test` 
* Test specified packages`
  * `go test {pkg1} {pkg2} ... {pkgn}` 
* Run tests in current package and descendents`
  * `go test ./...` 
* Generate verbose output (more information about how our tests actually executed, what passed, what succeeded, and the time that each one of our tests took)`
  * `go test -v` 
* Run tests matching a reg exp`
  * `go test -run {regexp}` 
* Test coverage`
  * `go test -cover` 
* Test coverage to analyze which functions are tested`
  * `go test -coverprofile {file}` //ex: `file` can be named as cover.out
  * `go tool cover -func {file}` See coverage report in terminal
  * `go tool cover -html {file}` See coverage report in HTML page 
* Test coverage to see heat map or a report showing how many times each statement was invoked`
  * `go test -coverprofile {file} -covermode count`
  * `go tool cover -html count` See coverage report in HTML page 
* Run a benchmark test`
  * `go test -bench .`
* Run a benchmark test with benchtime`
  * `go test -bench . -benchtime 10s` //For 10 seconds
* Report memory allocation statistics for benchmarks`
  * `go test -benchmem`
* Record execution trace for analysis`
  * `go test -trace trace.out`
* generate profile of requested type`
  * `go test -{type}profile {file}`
    * `type` can be
      * block
      * cover
      * cpu
      * mem
      * mutex
* Run specific tests to benchmark memory
  * `go test -bench {TestName} -memprofile {file}`
  * `go tool pprof {file}`