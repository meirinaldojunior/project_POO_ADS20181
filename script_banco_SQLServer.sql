--CREATE DATABASE PROJETO;
--USE PROJETO;


--create table Usuario (
                     
     
--	  Nome                  VARCHAR(30) NOT NULL,          
--      Cpf                   INT PRIMARY KEY NOT NULL
	  
--	   );

--create table Atendente (

--      Id_atendente          INT  IDENTITY PRIMARY KEY,
--	  Nome                  VARCHAR(30) NOT NULL,          
--      Cpf                   INT  NOT NULL
	  
--	  );

--create table Autor  (

--      Id_Autor           INT  IDENTITY PRIMARY KEY,
--	  Nome                  VARCHAR(30) NOT NULL,          
--   );

--create table Categoria (
     
--	 Nome_categoria                 VARCHAR(30) PRIMARY KEY NOT NULL  

--	   );

create table Livro (
      
	  Id_livro          INT IDENTITY (100,1) PRIMARY KEY, 
	  Nome_livro        VARCHAR(30) NOT NULL,
	  Nome_categoria    VARCHAR(30) FOREIGN KEY  REFERENCES (Nome_categoria),
	  Id_Autor          INT FOREIGN KEY REFERENCES   (Id_Autor));
	


create table exemplar(
      Id_exemplar       INT PRIMARY KEY,
      Id_livro          INT FOREIGN KEY REFERENCES livro (Id_livro),
	  Nome_categoria    VARCHAR(30) FOREIGN KEY  REFERENCES (Nome_categoria),
	  Id_Autor          INT FOREIGN KEY REFERENCES   (Id_Autor));
	 
	  
 create table aluguel (
       Id_Aluguel        INT PRIMARY KEY IDENTITY (500,1),
	   Id_atendente      INT FOREIGN KEY REFERENCES  (Id_atendente), 
	   Id_exemplar       INT FOREIGN KEY REFERENCES (Id_exemplar),
	   Cpf               INT FOREIGN KEY REFERENCES (Cpf),
       Valor             FLOAT NOT NULL);
     

