create table if not exists Local_Entity(
    id identity,
    name varchar (50) not null
    );

create table if not exists Special_Offer(
    id identity,
    name varchar (50) not null,
    description varchar (255) not null
    );


create table if not exists Local_Special_Offer(
    local_id bigint not null,
    special_offer_id bigint not null
);

alter table Local_Special_Offer
    add foreign key (local_id) references Local_Entity(id);
alter table Local_Special_Offer
    add foreign key (special_offer_id) references Special_Offer(id);
