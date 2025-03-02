create table if not exists public.purchase_transaction_product(
    id UUID not null,
    product_id UUID not null,
    purchase_transaction_id UUID not null,
    product_type VARCHAR(20) not null,
    amount INTEGER not null,
    price_at_the_time DECIMAL not null,
    primary key (id),
    foreign key (purchase_transaction_id) references public.purchase_transaction (id)
);