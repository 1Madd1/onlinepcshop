create table if not exists public.credit_card(
    id UUID not null,
    card_number VARCHAR(19) not null,
    name_on_card VARCHAR(40) not null,
    expiry_date VARCHAR(5) not null,
    cvv VARCHAR(3) not null,
    primary key (id)
);

alter table public.user
    add column credit_card_id UUID
    constraint user_credit_card_id_fkey
    references public.credit_card (id);