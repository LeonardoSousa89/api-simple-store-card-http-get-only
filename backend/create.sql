create table card_info (
     id int8 generated by default as identity,
     descricao varchar(255),
     preco float8 not null, 
     titulo varchar(255), 
     primary key (id)
);