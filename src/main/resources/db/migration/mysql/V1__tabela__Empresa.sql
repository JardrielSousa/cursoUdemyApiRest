create table if not exists empresa(
id int auto_increment not null,
razao_social VARCHAR(100) not null unique ,
cnpj VARCHAR(100) not null unique , 
data_criacao datetime not null ,
data_atualizacao datetime not null,
primary key(id)
)ENGINE=INNODB default CHARSET=utf8;