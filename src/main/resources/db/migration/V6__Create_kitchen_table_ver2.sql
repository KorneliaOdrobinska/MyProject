create table kitchen(
                          id int unsigned primary key auto_increment,
                          element varchar(100) not null,
                          link varchar(400) not null,
                          description varchar(100),
                          author varchar(100) not null,
                          type int not null

);