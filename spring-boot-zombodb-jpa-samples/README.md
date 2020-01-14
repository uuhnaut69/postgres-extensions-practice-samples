# GUIDE

- Generate dummy data via endpoint

  ```bash

  [POST] localhost:8080/jobs
  ```

- Create index zombodb for jobs and fields:

  Index child table
  ```sql

  CREATE INDEX idxfields ON field USING zombodb ((field.*))WITH (url='http://localhost:9200/');
  ```

  Index parent table
  ```sql

  CREATE INDEX idxjobs ON job USING zombodb ((job.*))WITH (url='http://localhost:9200/');
  ```

- Full-text query via endpoint

  ```bash

  [GET] localhost:8080/jobs?text=Java
  ```

