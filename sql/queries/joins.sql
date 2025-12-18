-- Basic join patterns (generic SQL)

-- Inner join
SELECT c.id, c.name, o.id AS order_id, o.created_at
FROM customers c
JOIN orders o ON o.customer_id = c.id;

-- Left join (keep customers without orders)
SELECT c.id, c.name, o.id AS order_id
FROM customers c
LEFT JOIN orders o ON o.customer_id = c.id;
