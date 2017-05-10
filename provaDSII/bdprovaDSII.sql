create database db_ProvaDSI
go
use db_ProvaDSI
go
create table tbl_Produto
(
	id int primary key identity,
	marca varchar(100),
	produto varchar(50),
	quantidade int,
	preco	smallmoney,
	caminho varchar(100)
)


insert into tbl_Produto values ('marca qualquer', 'notebook', 3, 1230.0, null)
u

select * from tbl_Produto
truncate table tbl_Produto