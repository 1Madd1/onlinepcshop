ALTER TABLE public.motherboard
    ADD rating INTEGER DEFAULT 0;

ALTER TABLE public.cpu
    ADD rating INTEGER DEFAULT 0;

ALTER TABLE public.gpu
    ADD rating INTEGER DEFAULT 0;

ALTER TABLE public.power_supply
    ADD rating INTEGER  DEFAULT 0;

ALTER TABLE public.computer_case
    ADD rating INTEGER DEFAULT 0;

ALTER TABLE public.ram
    ADD rating INTEGER DEFAULT 0;

ALTER TABLE public.storage
    ADD rating INTEGER DEFAULT 0;

ALTER TABLE public.cooler
    ADD rating INTEGER DEFAULT 0;

ALTER TABLE public.case_fan
    ADD rating INTEGER DEFAULT 0;

ALTER TABLE public.computer
    ADD rating INTEGER DEFAULT 0;