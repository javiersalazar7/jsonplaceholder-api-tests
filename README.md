# JSONPlaceholder API Test Suite

This is a sample automated test suite for the [JSONPlaceholder](https://jsonplaceholder.typicode.com/) fake REST API.  
Built with Java, JUnit 5, RestAssured, and GitHub Actions.

## ✅ Tests Included

- `GET /posts` — Verifies 100 posts are returned
- `GET /posts/1` — Validates post data
- `GET /posts/999` — Checks 404 for non-existing post
- `POST /posts` — Confirms post creation returns 201

## 🧪 Run Tests

```bash
mvn test
