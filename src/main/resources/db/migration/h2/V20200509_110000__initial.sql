create table accounts (id binary not null, customer_id binary, primary key (id));
create table accounts_orders (account_id binary not null, orders_id binary not null);
create table addresses (id binary not null, city varchar(255), country varchar(255), street varchar(255), zip_code varchar(255), primary key (id));
create table customer_orders (id binary not null, status varchar(255), discount_id binary, primary key (id));
create table customer_orders_items (order_id binary not null, items_id binary not null);
create table customers (customer_type varchar(31) not null, id binary not null, name varchar(255), tax_id varchar(255), vat_number varchar(255), first_name varchar(255), last_name varchar(255), primary key (id));
create table customers_addresses (customer_id binary not null, addresses_id binary not null);
create table order_discount (discount_type varchar(31) not null, id binary not null, discount double not null, coupon varchar(255), primary key (id));
create table order_items (id binary not null, name varchar(255), price decimal(19,2), quantity integer not null, primary key (id));
