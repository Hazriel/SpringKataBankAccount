# KATA : Bank Account
## Usage

To run the application, use the spring-boot maven plugin :

```sh
./mvnw spring-boot:run
```

The API will be served on `localhost:8080` using an in-memory h2 database.

## User Stories

This Spring Boot API manages resources to cover the following user stories :

### Make a deposit or withdrawal

Making a deposit/withdrawal is possible through the creation of a transaction for an account.

```
POST /api/v1/transactions
```

Expected request body :
```json
{
  "accountId": 1,
  "amount": 200
}
```

For a deposit :
```sh
curl -X POST -H 'Content-Type: application/json' -d '{"accountId": 1, "amount": 150}' localhost:8080/api/v1/transactions
```

For a withdrawal :
```sh
curl -X POST 'Content-Type: application/json' -d '{"accountId": 1, "amount": -50}' localhost:8080/api/v1/transactions
```

### Inspect one's account

Inspecting one's account is done through a request on an account endpoint.

```
GET /api/v1/accounts/{id}
```

Excepted response :
```json
{
    "accountId": 1,
    "money": 250.0,
    "owner": {
        "id": 1,
        "firstname": "John",
        "lastname": "Doe"
    },
    "transactions": [
        {
            "transactionId": 1,
            "accountId": 1,
            "amount": 150.0,
            "time": "2022-09-21T23:16:58.174014"
        }
    ],
    "createdAt": "2022-09-21T23:03:40.574123"
}
```

## Default data

By default a `John Doe` user with an account exists with the id `1`.
