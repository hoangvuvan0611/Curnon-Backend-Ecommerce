# CURNON ECOMMERCE
## About project
- Curnon project is a ecommerce webapp 
## Build with
- Java 17
- Spring Framework
- PostGreSQL
- ReactJs
## Requirements
1. Products: View, filter, search, sort and buy. 
2. Create Account: User can create account and login to the website
3. Contact Detail: User can store their first and lastname, contact detail such as email, phone number ....
4. Set up Address: User can add one or more addresses to their account and set a default shipping address.
5. Payment method: User can use one or more payment method to their account and set a default payment method.
6. Product variations: Each product can have different variations, such as colors (gold, grey...) and sizes (40MM, 28MM...)
7. Number in stock: Track of the number of each product in stock.
8. Shopping cart: Visitors(Anounymou user) can add one or more products to their shopping cart as part of their shopping
experience, Shopping cart are not saved in the database unless they are logged in.
9. Payment detail for Order: user need to provide their payment detail, address detail as a part of placing an order.
10. shipping method: The user can select a shipping method from a list of method.
11. Order status: Show status of order such as payment process, shipping....
12. Promotions: Allows for promotions or sale to be run.
## Overview
### Database Design (https://dbdesigner.page.link/omHMfsfVVKkzAD2E6)
1. admin_user
   Fields:
   id: Primary key, integer.
   role_id: Foreign key referencing role(id), integer.
   username: Username of the admin user, varchar.
   first_name: First name of the admin user, varchar.
   last_name: Last name of the admin user, varchar.
   last_login: Timestamp of the last login.
   create_at: Timestamp when the user was created.
   update_at: Timestamp when the user was last updated.
2. role
   Fields:
   id: Primary key, integer.
   permissions: Permissions assigned to the role, varchar or JSON.
   create_at: Timestamp when the role was created.
   update_at: Timestamp when the role was last updated.
3. user
   Fields:
   id: Primary key, integer.
   avatar: Avatar image, bytea.
   username: Username of the user, varchar.
   first_name: First name of the user, varchar.
   last_name: Last name of the user, varchar.
   email: Email of the user, varchar.
   date_of_birth: Date of birth of the user, date.
   phone_number: Phone number of the user, varchar.
   password: Encrypted password, varchar.
   create_at: Timestamp when the user was created.
   update_at: Timestamp when the user was last updated.
4. user_address
   Fields:
   id: Primary key, integer.
   user_id: Foreign key referencing user(id), integer.
   address_line1: Address line 1, varchar.
   address_line2: Address line 2, varchar.
   country: Country, varchar.
   city: City, varchar.
   postal_code: Postal code, varchar.
   phone_number: Phone number, varchar.
   create_at: Timestamp when the address was created.
5. product
   Fields:
   id: Primary key, integer.
   name: Product name, varchar.
   desc: Product description, text.
   image: Product image, bytea.
   image_thumb: Product thumbnail image, bytea.
   category_id: Foreign key referencing category(id), integer.
   discount_id: Foreign key referencing discount(id), integer.
   create_at: Timestamp when the product was created.
   update_at: Timestamp when the product was last updated.
6. category
   Fields:
   id: Primary key, integer.
   name: Category name, varchar.
   desc: Category description, text.
   create_at: Timestamp when the category was created.
   update_at: Timestamp when the category was last updated.
7. discount
   Fields:
   id: Primary key, integer.
   name: Discount name, varchar.
   desc: Discount description, text.
   discount_percent: Discount percentage, integer.
   active: Discount status, boolean.
   create_at: Timestamp when the discount was created.
   update_at: Timestamp when the discount was last updated.
8. product_sku
   Fields:
   id: Primary key, integer.
   product_id: Foreign key referencing product(id), integer.
   size_attribute_id: Foreign key referencing product_attribute(id), integer.
   color_attribute_id: Foreign key referencing product_attribute(id), integer.
   quantity: Quantity available, integer.
   price: Price, integer.
   create_at: Timestamp when the SKU was created.
   update_at: Timestamp when the SKU was last updated.
9. product_attribute
   Fields:
   id: Primary key, integer.
   type: Attribute type (e.g., size, color), varchar.
   value: Attribute value, varchar.
   create_at: Timestamp when the attribute was created.
   update_at: Timestamp when the attribute was last updated.
10. cart
    Fields:
    id: Primary key, integer.
    user_id: Foreign key referencing user(id), integer.
    create_at: Timestamp when the cart was created.
    update_at: Timestamp when the cart was last updated.
11. cart_item
    Fields:
    id: Primary key, integer.
    cart_id: Foreign key referencing cart(id), integer.
    product_sku_id: Foreign key referencing product_sku(id), integer.
    quantity: Quantity of the product, integer.
    create_at: Timestamp when the item was added to the cart.
    update_at: Timestamp when the item was last updated.
12. order_detail
    Fields:
    id: Primary key, integer.
    user_id: Foreign key referencing user(id), integer.
    total: Total amount of the order, integer.
    create_at: Timestamp when the order was created.
    update_at: Timestamp when the order was last updated.
13. order_item
    Fields:
    id: Primary key, integer.
    order_detail_id: Foreign key referencing order_detail(id), integer.
    product_sku_id: Foreign key referencing product_sku(id), integer.
    quantity: Quantity of the product, integer.
    create_at: Timestamp when the item was added to the order.
    update_at: Timestamp when the item was last updated.
14. payment_detail
    Fields:
    id: Primary key, integer.
    order_detail_id: Foreign key referencing order_detail(id), integer.
    amount: Payment amount, integer.
    provider: Payment provider, varchar.
    status: Payment status, varchar.
    create_at: Timestamp when the payment was created.
    update_at: Timestamp when the payment was last updated.
