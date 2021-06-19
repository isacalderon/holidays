INSERT INTO public.cat_status(
	id, description, active)
	VALUES (1, 'pending', true);
	
INSERT INTO public.cat_status(
	id, description, active)
	VALUES (2, 'rejected', true);
	
INSERT INTO public.cat_status(
	id, description, active)
	VALUES (3, 'approved', true);
	

select * 
from public.cat_status