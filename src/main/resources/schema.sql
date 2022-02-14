create table if not exists Local_Entity(
    id identity,
    name varchar (50) not null
    );

create table if not exists Special_Offer(
    id identity,
    name varchar (50) not null,
    description varchar (255) not null,
    local_id bigint not null,
    Foreign Key (local_id) references Local_Entity(id)
    );
