# 🌐 Networking Fundamentals for Software Engineering Interviews

> A complete beginner-friendly networking cheat sheet covering the most frequently asked interview topics.

---

# Table of Contents

1. HTTP Methods
2. HTTP Status Codes
3. TCP vs UDP
4. DNS
5. SSL
6. TLS
7. REST API
8. GraphQL
9. Cookies
10. Sessions
11. JWT
12. OAuth
13. Load Balancer
14. Basic Networking Interview Questions

---

# 1. HTTP Methods

HTTP (HyperText Transfer Protocol) is used for communication between client and server.

| Method | Purpose | Idempotent | Safe |
|----------|----------|------------|------|
| GET | Retrieve data | ✅ | ✅ |
| POST | Create resource | ❌ | ❌ |
| PUT | Replace entire resource | ✅ | ❌ |
| PATCH | Update partial resource | ❌ | ❌ |
| DELETE | Delete resource | ✅ | ❌ |

## Examples

### GET

```http
GET /users/10
```

Returns user information.

---

### POST

```http
POST /users
```

Creates a new user.

---

### PUT

```http
PUT /users/10
```

Completely replaces user information.

---

### PATCH

```http
PATCH /users/10
```

Updates only selected fields.

---

### DELETE

```http
DELETE /users/10
```

Deletes user.

---

## Idempotent Meaning

Calling the request multiple times gives the same result.

Example:

```
DELETE /users/10
```

Deleting the same user multiple times still results in the user being deleted.

---

# 2. HTTP Status Codes

## 1xx — Informational

```
100 Continue
```

---

## 2xx — Success

| Code | Meaning |
|------|----------|
|200|OK|
|201|Created|
|202|Accepted|
|204|No Content|

Example

```
GET /users

200 OK
```

---

## 3xx — Redirection

|Code|Meaning|
|----|-------|
|301|Moved Permanently|
|302|Found|
|304|Not Modified|

---

## 4xx — Client Errors

|Code|Meaning|
|----|-------|
|400|Bad Request|
|401|Unauthorized|
|403|Forbidden|
|404|Not Found|
|405|Method Not Allowed|
|409|Conflict|
|429|Too Many Requests|

---

## 5xx — Server Errors

|Code|Meaning|
|----|-------|
|500|Internal Server Error|
|502|Bad Gateway|
|503|Service Unavailable|
|504|Gateway Timeout|

---

# 3. TCP vs UDP

## TCP (Transmission Control Protocol)

Features

- Connection-oriented
- Reliable
- Error checking
- Ordered delivery
- Slower

Examples

- HTTPS
- SSH
- FTP
- Email

---

## UDP (User Datagram Protocol)

Features

- Connectionless
- Fast
- No guarantee
- No ordering

Examples

- Video Streaming
- Gaming
- Voice Calls
- DNS

---

## Comparison

|Feature|TCP|UDP|
|--------|---|---|
|Reliable|✅|❌|
|Connection|Yes|No|
|Ordered|Yes|No|
|Speed|Slow|Fast|
|Error Recovery|Yes|No|

---

# 4. DNS (Domain Name System)

DNS converts a domain name into an IP address.

Example

```
google.com

↓

142.250.195.14
```

Without DNS, we'd have to remember IP addresses.

---

## DNS Lookup Steps

```
Browser

↓

Local DNS Cache

↓

ISP DNS

↓

Root Server

↓

TLD Server

↓

Authoritative DNS

↓

IP Address

↓

Website Opens
```

---

# 5. SSL

SSL = Secure Sockets Layer

- Old encryption protocol
- Encrypts communication
- Deprecated today

Current replacement:

```
TLS
```

---

# 6. TLS

TLS = Transport Layer Security

Used by HTTPS.

Provides

- Encryption
- Authentication
- Data Integrity

---

## TLS Handshake

```
Client

↓

Server

↓

Certificate

↓

Public Key Exchange

↓

Session Key Created

↓

Encrypted Communication
```

---

# Difference

SSL

- Old
- Insecure

TLS

- Modern
- Secure
- Faster

---

# 7. REST API

REST = Representational State Transfer

Rules

- Stateless
- Client-Server
- Uniform Interface
- Cacheable

Example

```
GET /users

POST /users

PUT /users/5

DELETE /users/5
```

Response

```json
{
  "id": 5,
  "name": "John"
}
```

---

## REST Advantages

- Simple
- Scalable
- Easy to cache
- Uses HTTP

---

# 8. GraphQL

Developed by Facebook.

Instead of multiple endpoints,

REST

```
/users

/posts

/comments
```

GraphQL

```
/graphql
```

Client requests exactly what it needs.

Example

```graphql
{
  user(id:1){
      name
      email
  }
}
```

Only returns

```json
{
 "name":"John",
 "email":"john@gmail.com"
}
```

No extra data.

---

## REST vs GraphQL

|REST|GraphQL|
|----|--------|
|Multiple endpoints|Single endpoint|
|Over-fetching|No|
|Under-fetching|No|
|Simple|Flexible|

---

# 9. Cookies

Small data stored inside browser.

Used for

- Login
- Theme
- Preferences
- Shopping Cart

Example

```
Cookie

username=John
```

---

## Types

- Session Cookie
- Persistent Cookie
- Secure Cookie
- HttpOnly Cookie

---

# 10. Sessions

Session stores user information on server.

Browser stores only

```
Session ID
```

Flow

```
Login

↓

Server creates Session

↓

Session ID sent

↓

Browser stores Session ID

↓

Future requests include Session ID
```

---

# Cookies vs Sessions

|Cookies|Sessions|
|---------|---------|
|Stored in Browser|Stored in Server|
|Less Secure|More Secure|
|Small Data|Large Data|

---

# 11. JWT (JSON Web Token)

JWT is used for authentication.

Structure

```
Header

.

Payload

.

Signature
```

Looks like

```
xxxxx.yyyyy.zzzzz
```

---

## Authentication Flow

```
Login

↓

Server verifies

↓

JWT Generated

↓

Client stores JWT

↓

JWT sent with every request

↓

Server validates JWT
```

Authorization Header

```
Authorization: Bearer JWT_TOKEN
```

---

## Advantages

- Stateless
- Fast
- Easy to scale

---

# 12. OAuth

OAuth allows one application to access another application without sharing passwords.

Example

```
Login with Google

Login with GitHub

Login with Facebook
```

Flow

```
User

↓

Google Login

↓

Permission

↓

Access Token

↓

Application
```

---

## OAuth vs JWT

OAuth

- Authorization Framework

JWT

- Token Format

Often OAuth uses JWT as the access token.

---

# 13. Load Balancer

A load balancer distributes incoming requests among multiple servers.

Without Load Balancer

```
Users

↓

Server

↓

Crash
```

With Load Balancer

```
Users

↓

Load Balancer

↓

Server 1

↓

Server 2

↓

Server 3
```

---

## Types

### Round Robin

```
1

↓

2

↓

3

↓

1

↓

2
```

---

### Least Connections

Request goes to server having the fewest active connections.

---

### IP Hash

Same client always goes to the same server.

---

## Benefits

- High Availability
- Fault Tolerance
- Better Performance
- Scalability

---

# Authentication Flow (Overall)

```
Browser

↓

Login Request

↓

Server

↓

Verify Credentials

↓

JWT / Session Created

↓

Browser Stores Token

↓

Future Requests

↓

Authorization Header

↓

Server Verification

↓

Response
```

---

# HTTPS Flow

```
Browser

↓

DNS Lookup

↓

Server IP

↓

TCP Handshake

↓

TLS Handshake

↓

Encrypted HTTP Communication

↓

Response
```

---

# Common Interview Questions

## HTTP

- What is HTTP?
- Difference between HTTP and HTTPS?
- Explain GET vs POST.
- PUT vs PATCH?
- What are idempotent methods?
- What are safe methods?

---

## Status Codes

- Difference between 401 and 403?
- Difference between 404 and 500?
- What does 201 mean?
- Why use 204?

---

## TCP/UDP

- Difference between TCP and UDP?
- Which protocol does DNS use?
- Why does video streaming use UDP?
- Explain TCP Three-Way Handshake.

---

## DNS

- What is DNS?
- Explain DNS lookup.
- What is DNS cache?

---

## SSL/TLS

- Difference between SSL and TLS?
- What is HTTPS?
- Explain TLS Handshake.

---

## REST

- What is REST?
- REST principles?
- Why should REST APIs be stateless?
- What is idempotency?

---

## GraphQL

- REST vs GraphQL?
- Why GraphQL?
- Advantages and disadvantages?

---

## Cookies & Sessions

- Difference between Cookies and Sessions?
- Where are Cookies stored?
- Where are Sessions stored?
- What is Session ID?

---

## JWT

- What is JWT?
- Explain JWT structure.
- Why JWT is stateless?
- Where should JWT be stored?
- Difference between JWT and Session Authentication?

---

## OAuth

- What is OAuth?
- Difference between Authentication and Authorization?
- OAuth vs JWT?
- Explain Login with Google.

---

## Load Balancer

- Why is a Load Balancer used?
- Round Robin vs Least Connections?
- What happens if one server goes down?
- What is Sticky Session?

---

# Quick Revision

✅ HTTP → Communication Protocol

✅ HTTPS → HTTP + TLS Encryption

✅ TCP → Reliable

✅ UDP → Fast

✅ DNS → Domain → IP

✅ SSL → Old Security Protocol

✅ TLS → Modern Security Protocol

✅ REST → Stateless APIs

✅ GraphQL → Query Exactly Needed Data

✅ Cookies → Stored in Browser

✅ Sessions → Stored on Server

✅ JWT → Stateless Authentication Token

✅ OAuth → Authorization Framework

✅ Load Balancer → Distributes Traffic Across Servers