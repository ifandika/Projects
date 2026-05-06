## Project 8 | NodeJs Server Max Client
_Assignment College Bachlore_

## Introduce
So in this project I will create simple NodeJs server, and then we test the connection from client with many client, for this moment I using NodeJs artillery for HTTP tools, is free for CLI and for Cloud is paid.

## Project Structure
vscode/
-- result.json : Result of tes connection using NodeJs artillery
-- script.yaml : Contains code for configure testing
-- server.js : Contains Js code for create simple server
-- test.http : Contains simple http test to server

## Example / Usage
First we need to install NodeJs Artillery for CLI (free)

```Bash
$ npm install -g artillery
```

And then we can quickly try with simple command.

```Bash
$ artillery quick --count 50 --duration 30 http://localhost:3000

# quick : for quick command / test
# -- count : for total of client
# --duration : duration test
# http... : address of server 
```

Or we can using file (yaml format) for more easly and advance / spesific.

```Bash
$ artillery run script.yaml

# run : running file
# script.yaml : file name

# or with output JSON

$ artillery run --output result.json script.yaml

# run : running file
# --output : for tag output with file
# result.json : file name output
# script.yaml : file name
```

For example output.

```Bash
Axioo@IFANDIKA-AXIOO MINGW64 /d/Ifandika/Projects/8_nodejs-server-max-clients/vscode (master)
$ artillery run script.yaml
Test run id: tytqx_7wqcbh5mk86xmapkfbjp4p9yngw3b_zzre
Phase started: Ramp up (index: 0, duration: 30s) 20:57:15(+0700)

Phase completed: Ramp up (index: 0, duration: 30s) 20:57:45(+0700)

Phase started: Peak load (index: 1, duration: 60s) 20:57:45(+0700)

--------------------------------------
Metrics for period to: 20:57:20(+0700) (width: 3.065s)
--------------------------------------

http.codes.200: ................................................................ 32
http.downloaded_bytes: ......................................................... 256
http.request_rate: ............................................................. 18/sec
http.requests: ................................................................. 32
http.response_time:
  min: ......................................................................... 0
  max: ......................................................................... 11
  mean: ........................................................................ 1.2
  median: ...................................................................... 1
  p95: ......................................................................... 2
  p99: ......................................................................... 3
http.response_time.2xx:
  min: ......................................................................... 0
  max: ......................................................................... 11
  mean: ........................................................................ 1.2
  median: ...................................................................... 1
  p95: ......................................................................... 2
  p99: ......................................................................... 3
http.responses: ................................................................ 32
vusers.completed: .............................................................. 32
vusers.created: ................................................................ 32
vusers.created_by_name.Get user data: .......................................... 32
vusers.failed: ................................................................. 0
vusers.session_length:
  min: ......................................................................... 3.7
  max: ......................................................................... 46.2
  mean: ........................................................................ 15.6
  median: ...................................................................... 5.5
  p95: ......................................................................... 39.3
  p99: ......................................................................... 39.3


--------------------------------------
Metrics for period to: 20:57:30(+0700) (width: 9.94s)
--------------------------------------
```