# 🗄 SQL Handbook

> A comprehensive SQL learning path covering everything from basic queries to advanced database concepts, query optimization, and interview preparation.

---

# 📚 Learning Roadmap

```text
SQL Basics
      │
      ▼
DDL / DML
      │
      ▼
Filtering & Sorting
      │
      ▼
Joins
      │
      ▼
Aggregate Functions
      │
      ▼
GROUP BY & HAVING
      │
      ▼
Subqueries
      │
      ▼
Window Functions
      │
      ▼
Views
      │
      ▼
Indexes
      │
      ▼
Transactions
      │
      ▼
Normalization
      │
      ▼
Query Optimization
      │
      ▼
Interview Questions
      │
      ▼
Practice Problems
```

---

# 📂 Folder Structure

```text
SQL/
│
├── README.md
│
├── 01-sql-basics.md
├── 02-ddl-dml-dcl-tcl.md
├── 03-filtering-sorting.md
├── 04-aggregate-functions.md
├── 05-group-by-having.md
├── 06-joins.md
├── 07-subqueries.md
├── 08-window-functions.md
├── 09-constraints.md
├── 10-indexing.md
├── 11-normalization.md
├── 12-transactions-acid.md
├── 13-views.md
├── 14-stored-procedures-triggers.md
├── 15-query-optimization.md
├── 16-common-functions.md
├── 17-interview-questions.md
├── 18-top-sql-problems.md
│
└── sql-cheatsheet.md
```

---

# 📘 File Descriptions

---

## 📄 01-sql-basics.md

Learn the fundamentals of SQL.

### Topics

* What is SQL?
* DBMS vs RDBMS
* Database Terminology
* SQL Syntax
* SQL Data Types
* Primary Key
* Foreign Key
* Candidate Key
* Composite Key
* Super Key
* Alternate Key

---

## 📄 02-ddl-dml-dcl-tcl.md

SQL command categories.

### DDL

* CREATE
* ALTER
* DROP
* TRUNCATE
* RENAME

### DML

* SELECT
* INSERT
* UPDATE
* DELETE

### DCL

* GRANT
* REVOKE

### TCL

* COMMIT
* ROLLBACK
* SAVEPOINT

---

## 📄 03-filtering-sorting.md

Filtering records.

Topics

* WHERE
* DISTINCT
* LIKE
* BETWEEN
* IN
* NOT IN
* EXISTS
* ANY
* ALL
* IS NULL
* IS NOT NULL
* ORDER BY
* ASC
* DESC
* LIMIT
* OFFSET

---

## 📄 04-aggregate-functions.md

Topics

* COUNT()
* SUM()
* AVG()
* MIN()
* MAX()

Interview examples included.

---

## 📄 05-group-by-having.md

Topics

* GROUP BY
* HAVING
* Aggregation
* Multiple GROUP BY columns
* Interview tricks

Difference between

* WHERE
* HAVING

---

## 📄 06-joins.md ⭐⭐⭐⭐⭐

Complete guide to SQL Joins.

Topics

* INNER JOIN
* LEFT JOIN
* RIGHT JOIN
* FULL OUTER JOIN
* SELF JOIN
* CROSS JOIN
* UNION
* UNION ALL

Visual diagrams included.

---

## 📄 07-subqueries.md

Topics

* Scalar Subquery
* Correlated Subquery
* Nested Query
* EXISTS
* NOT EXISTS
* ANY
* ALL

---

## 📄 08-window-functions.md ⭐⭐⭐⭐⭐

One of the most important interview topics.

Topics

* ROW_NUMBER()
* RANK()
* DENSE_RANK()
* NTILE()
* LEAD()
* LAG()
* FIRST_VALUE()
* LAST_VALUE()

Practical examples included.

---

## 📄 09-constraints.md

Topics

* PRIMARY KEY
* FOREIGN KEY
* UNIQUE
* CHECK
* DEFAULT
* NOT NULL

Constraint best practices.

---

## 📄 10-indexing.md ⭐⭐⭐⭐⭐

Topics

* What is an Index?
* Clustered Index
* Non-Clustered Index
* Composite Index
* Unique Index
* B-Tree
* Hash Index

Advantages

Disadvantages

Interview questions.

---

## 📄 11-normalization.md ⭐⭐⭐⭐⭐

Database Design.

Topics

* 1NF
* 2NF
* 3NF
* BCNF
* 4NF
* 5NF

Denormalization

Real-world examples.

---

## 📄 12-transactions-acid.md ⭐⭐⭐⭐⭐

Topics

* Transactions
* COMMIT
* ROLLBACK
* SAVEPOINT

ACID Properties

* Atomicity
* Consistency
* Isolation
* Durability

Isolation Levels

* Read Uncommitted
* Read Committed
* Repeatable Read
* Serializable

Locks

* Shared Lock
* Exclusive Lock
* Deadlock
* Optimistic Lock
* Pessimistic Lock

---

## 📄 13-views.md

Topics

* CREATE VIEW
* DROP VIEW
* Materialized Views
* Advantages
* Disadvantages

---

## 📄 14-stored-procedures-triggers.md

Topics

* Stored Procedures
* Functions
* Triggers
* BEFORE INSERT
* AFTER UPDATE
* BEFORE DELETE

---

## 📄 15-query-optimization.md ⭐⭐⭐⭐⭐

Topics

* EXPLAIN
* Query Execution Plan
* Index Optimization
* Avoid SELECT *
* Covering Indexes
* Joins vs Subqueries
* Pagination Optimization
* Query Performance

---

## 📄 16-common-functions.md

String Functions

* CONCAT
* LENGTH
* UPPER
* LOWER
* SUBSTRING
* REPLACE
* TRIM

Date Functions

* NOW()
* CURDATE()
* DATE_ADD()
* DATEDIFF()

Numeric Functions

* ROUND()
* FLOOR()
* CEIL()
* ABS()

CASE Expression

COALESCE()

NULLIF()

---

## 📄 17-interview-questions.md ⭐⭐⭐⭐⭐

100+ SQL Interview Questions

Examples

* DELETE vs TRUNCATE vs DROP
* WHERE vs HAVING
* CHAR vs VARCHAR
* UNION vs UNION ALL
* EXISTS vs IN
* View vs Table
* View vs Materialized View
* Clustered vs Non-Clustered Index
* Primary vs Unique Key
* ACID Properties
* Normalization
* Transactions
* Deadlock
* Joins
* Window Functions

Detailed answers included.

---

## 📄 18-top-sql-problems.md ⭐⭐⭐⭐⭐

Most frequently asked SQL interview problems.

Examples

* Second Highest Salary
* Nth Highest Salary
* Duplicate Emails
* Rank Scores
* Consecutive Numbers
* Rising Temperature
* Customers Who Never Order
* Employees Earning More Than Managers
* Department Highest Salary
* Product Sales Analysis
* User Activity
* Trips and Users
* Human Traffic of Stadium
* Median Employee Salary
* Exchange Seats
* Game Play Analysis

Solutions included.

---

## 📄 sql-cheatsheet.md

Quick revision before interviews.

Contains

* Common Commands
* Joins
* Aggregate Functions
* Window Functions
* Constraints
* Transactions
* Indexes
* Views
* Execution Order
* ACID
* SQL Syntax
* Frequently Used Queries

Perfect for 15-minute interview revision.

---

# 🎯 Recommended Learning Order

1. SQL Basics
2. DDL & DML
3. Filtering & Sorting
4. Aggregate Functions
5. GROUP BY & HAVING
6. Joins
7. Subqueries
8. Window Functions
9. Constraints
10. Indexing
11. Transactions & ACID
12. Views
13. Stored Procedures
14. Query Optimization
15. Interview Questions
16. Practice Problems

---

# ⭐ Interview Focus Areas

If you're preparing for Software Engineering interviews, prioritize these topics:

* ⭐⭐⭐⭐⭐ Joins
* ⭐⭐⭐⭐⭐ Window Functions
* ⭐⭐⭐⭐⭐ Indexing
* ⭐⭐⭐⭐⭐ Transactions & ACID
* ⭐⭐⭐⭐⭐ Query Optimization
* ⭐⭐⭐⭐⭐ SQL Execution Order
* ⭐⭐⭐⭐ GROUP BY & HAVING
* ⭐⭐⭐⭐ Subqueries
* ⭐⭐⭐⭐ Constraints
* ⭐⭐⭐ Normalization

---

# 🚀 Goal

After completing this handbook, you should be able to:

* Write efficient SQL queries.
* Design relational databases.
* Optimize slow queries.
* Explain database internals.
* Solve common SQL interview questions.
* Perform well in SDE and backend interviews.
* Confidently work with MySQL, PostgreSQL, SQL Server, Oracle, and other relational databases.
