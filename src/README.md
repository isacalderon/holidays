### Brief

It's November, and everyone is planning their holiday vacation. But management is struggling! They need a solution to approve vacation requests while also ensuring that there are still enough employees in the office to achieve end-of-year goals.

Your task is to build one HTTP API that allows employees to make vacation requests, and another that provides managers with an overview of all vacation requests and allows them to decline or approve requests.

### Tasks

- Implement assignment using:
    - Language: Java
    - Framework: Spring
- There should be API routes that allow workers to:
    - See their requests
        - Filter by status (approved, pending, rejected)
    - See their number of remaining vacation days
    - Make a new request if they have not exhausted their total limit (30 per year)
- There should be API routes that allow managers to:
    - See an overview of all requests
        - Filter by pending and approved
    - See an overview for each individual employee
    - See an overview of overlapping requests
    - Process an individual request and either approve or reject it
- Write tests for your business logic

Each request should, at minimum, have the following signature:
```
{
  "id": ENTITY_ID,
  "author": WORKER_ID,
  "status": STATUS_OPTION, // may be one of: "approved", "rejected", "pending"
  "resolved_by": MANAGER_ID,
  "request_created_at": "2020-08-09T12:57:13.506Z",
  "vacation_start_date" "2020-08-24T00:00:00.000Z",
  "vacation_end_date" "2020-09-04T00:00:00.000Z",
}
```
#To Run the project
First you need to create a database in Postgresql, then fill it. 
In the folder resourcesToRun, you'll find the schema database and 
the scripts to fill it, also the Postman collection to run some test 

#The swagger documentation

http://localhost/api/swagger-ui.html

#Git

https://github.com/isacalderon/holidays.git



