/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Aluno
 * Created: 16/05/2018
 */

root
sYH1Hi1Tqp5W

 
create database scalar;
use scalar;
create or replace table users(
    idUser int auto_increment primary key,
    user varchar(50) unique,
    email varchar(100) unique,
    pass varchar(100),
    address varchar(100)
);

create or replace table posts(
    idPost int auto_increment primary key,
    hora timestamp default current_timestamp,
    title varchar(100),
    content text(1000),
    video varchar(150),
    img varchar(150),
    idUser int,
    foreign key(idUser) references users(idUser)
);

