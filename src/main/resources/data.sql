delete from Special_Offer;
delete from Local_Entity;

insert into Local_Entity (name) values ('Pierwszy lokal');
insert into Special_Offer (name, description, local_id)
values ('Pierwsza oferta', 'Jaki przykładowy opis!', 1);
