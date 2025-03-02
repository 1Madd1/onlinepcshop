create table if not exists public.purchase_history(
    id UUID not null,
    product_id UUID not null,
    user_id UUID not null,
    product_type VARCHAR(20) not null,
    date_of_purchase DATE not null,
    amount INTEGER not null,
    total_price DECIMAL not null,
    primary key (id),
    foreign key (user_id) references public.user (id)
);