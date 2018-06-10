1. User Wallet API - retrieve information in the user’s wallet
GET /wallet/{id}

Response: 200 OK
{
“id” : 123,
“balance” : 450,
“currency” : “SGD”
}
The company’s wallet id =1. The rest of the users have IDs incrementally from 2.

2. Purchase Product API - allowing users to purchase products under flash sale on the website.
POST /products/{id}/purchase
{
“user_id” : 123
}
This operation moves the invested money from users wallet to the company’s wallet.

3. Get Current Flash Sale API - allowing users to view current flash sale.
GET /sales/current?country=SG
Response: 200 OK
{
“sales”:
[
{
“product_id” : 123,
“price” : 35.50,
“currency” : “SGD”,
“total_items” : 1000,
“items_left” : 450,
“time_left” : 100000
},
.....
]
}
You can assume the product ids vary from 1-50.
