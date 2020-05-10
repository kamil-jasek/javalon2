alter table customer_orders add column account_id binary not null;
alter table customer_orders add constraint fk_customer_orders_accounts foreign key (account_id) references accounts;
