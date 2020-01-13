# postgres-extensions-practice-samples
Postgres extensions practice samples integrate with spring boot

**Build status:**

| Project | Status |
| --- | --- |
| Postgres zombodb sample | ![](https://travis-ci.com/uuhnaut69/postgres-extensions-practice-samples.svg?branch=master) |

# Installation

<details>
  <summary><b>Zombodb</b></summary>
  
  <p>
Zombodb brings powerful text-search and analytics features to Postgres by using Elasticsearch as an index type. Its comprehensive query language and SQL functions enable new and creative ways to query your relational data.
  </p>
  
  <p>
    
  - Clone zombodb from source https://github.com/zombodb/zombodb.git

  - Using terminal go to clone folder

  - Config pg_config must be in your $PATH and be the binary for your target Postgres installation. Examples:
  
  ``` bash
  
  export PATH="$PATH:/Applications/Postgres.app/Contents/Versions/10/bin"
  ```
  
  - Make install 
  
  ``` bash
  
  make clean install
  
  ```
  
  - Go to directory /Users/uuhnaut/Library/Application\ Support/Postgres/var-10/ and add this to postgresql.conf && restart postgres
  
  ``` bash
  
  zdb.default_elasticsearch_url = 'http://localhost:9200/'
  ```
  
  </p>
</details>
