# postgres-extensions-practice-samples
Postgres extensions practice samples integrate with spring boot

**Build status:**

| Project | Status |
| --- | --- |
| Projects | ![](https://travis-ci.com/uuhnaut69/postgres-extensions-practice-samples.svg?branch=master) |

# Zombodb

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
  
  - Init db in this example following offical github of zombodb https://github.com/zombodb/zombodb/blob/master/TUTORIAL.md
  </p>
</details>

# Pgroonga

<details>
  <summary><b>Pgroonga</b></summary>
  <p>
    PGroonga is a PostgreSQL extension to use Groonga as the index.

PostgreSQL supports full text search against languages that use only alphabet and digit. It means that PostgreSQL doesn't support full text search against Japanese, Chinese and so on. You can use super fast full text search feature against all languages by installing PGroonga into your PostgreSQL!
  </p>
  
  <p>
  - Run docker
  
  ``` bash
  
  cd spring-boot-pgroonga-samples && docker-compose up -d
  ```
  </p> 

  - Add extension to db
  
  ``` bash
  
  create extension pgroonga;
  ```
  
  - Create pgroonga index:
  
  ```bash
  
  CREATE INDEX pgroonga_full_name_index ON account USING pgroonga (full_name);
  ```
  
  - Disable sequential scan to ensure using pgroonga index:
  
  ```bash
  
  SET enable_seqscan = off;
  ```
  
  - Generate dummy data endpoint
  
  ``` bash
  
  [POST] localhost:8080/accounts
  ```
  
  - Query endpoint:
  
  ``` bash
  
  [GET] localhost:8080/accounts?text=Thomas
  ```
</details>
