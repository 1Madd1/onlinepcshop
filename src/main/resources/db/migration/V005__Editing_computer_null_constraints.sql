ALTER TABLE public.computer
    ALTER COLUMN gpu_id DROP NOT NULL;

ALTER TABLE public.computer
    ALTER COLUMN cooler_id DROP NOT NULL;