create table if not exists public.user(
    id UUID not null,
    email VARCHAR(50) not null,
    first_name VARCHAR(50) not null,
    last_name VARCHAR(50) not null,
    telephone VARCHAR(50) not null,
    principal_id VARCHAR(50) not null,
    primary key (id)
);

-- create table if not exists public.component(
--     id UUID not null,
--     component_name VARCHAR(50) not null,
--     amount_available INTEGER not null,
--     price DECIMAL not null,
--     component_type VARCHAR(50) not null,
--     description VARCHAR(255),
--     image VARCHAR(255),
--     brand VARCHAR(50) not null,
--     primary key (id)
-- );

create table if not exists public.motherboard(
    id UUID not null,
    component_name VARCHAR(50) not null,
    quantity INTEGER not null,
    price DECIMAL not null,
    currency VARCHAR(3) not null,
    socket_type VARCHAR(50) not null,-- enum
    memory_type VARCHAR(50) not null,-- enum
    tdp INTEGER not null,
    description VARCHAR(255),
    image VARCHAR(255),
    manufacturer VARCHAR(50) not null,-- enum
    primary key (id)
);

create table if not exists public.pcie_interface(
    id UUID not null,
    pcie_type VARCHAR(30) not null,-- enum
    primary key (id)
);

create table if not exists public.storage_interface(
    id UUID not null,
    storage_type VARCHAR(30) not null,-- enum
    primary key (id)
);

create table  if not exists public.motherboard_pcie_interface(
    id UUID not null,
    motherboard_id UUID not null,
    pcie_interface_id UUID not null,
    primary key (id),
    UNIQUE (motherboard_id, pcie_interface_id),
    foreign key (motherboard_id) references public.motherboard (id),
    foreign key (pcie_interface_id) references public.pcie_interface (id)
);

create table  if not exists public.motherboard_storage_interface(
    id UUID not null,
    motherboard_id UUID not null,
    storage_interface_id UUID not null,
    primary key (id),
    UNIQUE (motherboard_id, storage_interface_id),
    foreign key (motherboard_id) references public.motherboard (id),
    foreign key (storage_interface_id) references public.storage_interface (id)
);

create table if not exists public.cpu(
    id UUID not null,
    component_name VARCHAR(50) not null,
    quantity INTEGER not null,
    price DECIMAL not null,
    currency VARCHAR(3) not null,
    socket_type VARCHAR(50) not null,-- enum
    core_count INTEGER not null,
    performance_core_clock VARCHAR(10),
    performance_core_boost_clock VARCHAR(10),
    description VARCHAR(255),
    image VARCHAR(255),
    manufacturer VARCHAR(50) not null,-- enum
    tdp INTEGER not null,
    includes_cooler boolean not null,
    includes_integrated_gpu boolean not null,
    primary key (id)
);

create table if not exists public.gpu(
    id UUID not null,
    component_name VARCHAR(50) not null,
    quantity INTEGER not null,
    price DECIMAL not null,
    currency VARCHAR(3) not null,
    pcie_type VARCHAR(50) not null,-- enum
    tdp INTEGER not null,
    description VARCHAR(255),
    image VARCHAR(255),
    manufacturer VARCHAR(50) not null,-- enum
    primary key (id)
);

create table if not exists public.ram(
    id UUID not null,
    component_name VARCHAR(50) not null,
    quantity INTEGER not null,
    price DECIMAL not null,
    currency VARCHAR(3) not null,
    memory_type VARCHAR(30) not null,-- enum
    ram_speed INTEGER not null,
    ram_storage INTEGER not null,
    tdp INTEGER not null,
    description VARCHAR(255),
    image VARCHAR(255),
    manufacturer VARCHAR(50) not null,-- enum
    primary key (id)
);

create table if not exists public.storage(
    id UUID not null,
    component_name VARCHAR(50) not null,
    quantity INTEGER not null,
    price DECIMAL not null,
    currency VARCHAR(3) not null,
    storage_type VARCHAR(30) not null,-- enum
    capacity INTEGER not null,
    tdp INTEGER not null,
    description VARCHAR(255),
    image VARCHAR(255),
    manufacturer VARCHAR(50) not null,-- enum
    primary key (id)
);

create table if not exists public.computer_case(
    id UUID not null,
    component_name VARCHAR(50) not null,
    quantity INTEGER not null,
    price DECIMAL not null,
    currency VARCHAR(3) not null,
    case_type VARCHAR(30) not null,-- enum
    color VARCHAR(30) not null,-- enum
    description VARCHAR(255),
    image VARCHAR(255),
    manufacturer VARCHAR(50) not null,-- enum
    primary key (id)
);

create table if not exists public.cooler(
    id UUID not null,
    component_name VARCHAR(50) not null,
    quantity INTEGER not null,
    price DECIMAL not null,
    currency VARCHAR(3) not null,
    socket_type VARCHAR(30) not null,-- enum
    tdp INTEGER not null,
    water_cooled boolean not null,
    description VARCHAR(255),
    image VARCHAR(255),
    manufacturer VARCHAR(50) not null,-- enum
    primary key (id)
);

create table if not exists public.case_fan(
    id UUID not null,
    component_name VARCHAR(50) not null,
    quantity INTEGER not null,
    price DECIMAL not null,
    currency VARCHAR(3) not null,
    fan_size INTEGER not null,
    color VARCHAR(30) not null,
    rpm VARCHAR(60) not null,
    noise_level VARCHAR(60) not null,
    tdp INTEGER not null,
    description VARCHAR(255),
    image VARCHAR(255),
    manufacturer VARCHAR(50) not null,-- enum
    primary key (id)
);

create table if not exists public.power_supply(
    id UUID not null,
    component_name VARCHAR(50) not null,
    quantity INTEGER not null,
    price DECIMAL not null,
    currency VARCHAR(3) not null,
    efficiency_rating VARCHAR(40) not null,
    wattage INTEGER not null,
    color VARCHAR(30) not null,
    description VARCHAR(255),
    image VARCHAR(255),
    manufacturer VARCHAR(50) not null,-- enum
    primary key (id)
);

create table if not exists public.computer(
    id UUID not null,
    computer_name VARCHAR(50) not null,
    price DECIMAL not null,
    currency VARCHAR(3) not null,
    computer_type VARCHAR(50) not null,
    tdp INTEGER not null,
    description VARCHAR(255),
    image VARCHAR(255),
    computer_case_id UUID not null,
    gpu_id UUID not null,
    cpu_id UUID not null,
    cooler_id UUID not null,
    motherboard_id UUID not null,
    power_supply_id UUID not null,
    primary key (id),
    foreign key (computer_case_id) references public.computer_case (id),
    foreign key (gpu_id) references public.gpu (id),
    foreign key (cpu_id) references public.cpu (id),
    foreign key (cooler_id) references public.cooler (id),
    foreign key (motherboard_id) references public.motherboard (id),
    foreign key (power_supply_id) references public.power_supply (id)
);

create table if not exists public.computer_ram(
    id UUID not null,
    computer_id UUID not null,
    ram_id UUID not null,
    quantity INTEGER not null,
    primary key (id),
    UNIQUE (computer_id, ram_id),
    foreign key (computer_id) references public.computer (id),
    foreign key (ram_id) references public.ram (id)
);

create table if not exists public.computer_storage(
    id UUID not null,
    computer_id UUID not null,
    storage_id UUID not null,
    quantity INTEGER not null,
    primary key (id),
    UNIQUE (computer_id, storage_id),
    foreign key (computer_id) references public.computer (id),
    foreign key (storage_id) references public.storage (id)
);

create table if not exists public.computer_case_fan(
    id UUID not null,
    computer_id UUID not null,
    case_fan_id UUID not null,
    quantity INTEGER not null,
    primary key (id),
    UNIQUE (computer_id, case_fan_id),
    foreign key (computer_id) references public.computer (id),
    foreign key (case_fan_id) references public.case_fan (id)
);
--
-- CREATE UNIQUE INDEX uidx_tip_posebnog_dela_oznaka_drzava_id
--     ON public.tip_posebnog_dela USING btree
--     (drzava_id ASC NULLS LAST, oznaka ASC NULLS LAST)
--     WITH (deduplicate_items=False);
--
-- create table if not exists public.posebni_deo (
--                                     id UUID not null,
--                                     naziv VARCHAR(255) not null,
--                                     tip_posebnog_dela_id UUID not null,
--                                     stambena_zajednica_id UUID not null,
--                                     valuta VARCHAR(3) not null,
--                                     dug DECIMAL not null,
--                                     primary key (id),
--                                     foreign key (stambena_zajednica_id) references public.stambena_zajednica (id),
--                                     foreign key (tip_posebnog_dela_id) references public.tip_posebnog_dela(id)
-- );
--
-- create table if not exists public.posebni_deo_stanar(
--     id UUID not null,
--     stanar_od DATE not null,
--     stanar_do DATE,
--     stanar_id UUID not null,
--     posebni_deo_id UUID not null,
--     primary key (id),
--     foreign key (stanar_id) references public.stanar(id),
--     foreign key (posebni_deo_id) references public.posebni_deo(id)
-- );
--
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Stan', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'ST');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Poslovni prostor', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'PP');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Pomoćni prostor', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'PO');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Garaža', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'GA');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Garažno mesto', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'GM');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Garažni boks', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'GB');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Parking mesto', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'PM');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Stepenište', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'SP');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Ulazni prostor i vetrobrani', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'UV');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Zajednički hodnik i galerija', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'ZH');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Tavanski prostor', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'TP');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Podrum', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'PD');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Biciklarnica', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'BI');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Sušionica za veš', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'SV');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Zajednička terasa', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'ZT');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Sala za sastanke Skupštine stanara', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'SS');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Prostorija sa tehničkim uređajima', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'PT');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Prostorija transformatorske stanice', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'PS');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Skloništa', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'SK');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Plato', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'PL');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Trotoar oko zgrade', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'TO');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Bazen', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'BA');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Igrališta', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'IG');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Teretana', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'TE');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Ostali prostori sa pripadajućim elementima', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'OP');
-- insert into tip_posebnog_dela (id, naziv, drzava_id, oznaka) values (gen_random_uuid(), 'Ostali objekti sa pripadajućim opremom', 'e2b48fb8-9074-484c-ba6e-445beddbf025', 'OO');
