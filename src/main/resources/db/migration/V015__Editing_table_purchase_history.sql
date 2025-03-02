alter table public.purchase_history
drop column amount,
drop column product_type,
drop column product_id;

alter table public.purchase_history
add buyer_first_name VARCHAR(60) not null,
add buyer_last_name VARCHAR(60) not null,
add buyer_street VARCHAR(60) not null,
add buyer_postal_code VARCHAR(30) not null,
add buyer_email VARCHAR(60) not null,
add buyer_phone_number VARCHAR(30) not null,
add payment_type VARCHAR(30) not null;

alter table public.purchase_history
alter column user_id drop not null;

alter table public.purchase_history
rename to purchase_transaction;