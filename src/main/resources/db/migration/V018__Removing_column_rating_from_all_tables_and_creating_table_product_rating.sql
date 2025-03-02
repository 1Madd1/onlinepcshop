ALTER TABLE public.motherboard
    DROP COLUMN rating;

ALTER TABLE public.cpu
    DROP COLUMN rating;

ALTER TABLE public.gpu
    DROP COLUMN rating;

ALTER TABLE public.power_supply
    DROP COLUMN rating;

ALTER TABLE public.computer_case
    DROP COLUMN rating;

ALTER TABLE public.ram
    DROP COLUMN rating;

ALTER TABLE public.storage
    DROP COLUMN rating;

ALTER TABLE public.cooler
    DROP COLUMN rating;

ALTER TABLE public.case_fan
    DROP COLUMN rating;

ALTER TABLE public.computer
    DROP COLUMN rating;

create table if not exists public.product_rating(
    id UUID not null,
    product_id UUID not null,
    user_id UUID not null,
    product_type VARCHAR(20) not null,
    rating INTEGER not null,
    primary key (id),
    foreign key (user_id) references public.user (id)
);