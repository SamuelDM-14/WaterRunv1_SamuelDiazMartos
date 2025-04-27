Drop database if exists WaterRun;
Create database if not exists WaterRun;

USE waterrun;
drop table if exists Partidas;
Create table if not exists Partidas(
	id_Partida int auto_increment,
    fecha_Inicio date,
    fecha_Fin date,
    hora_inicio time,
    hora_fin time,
    respuestas_Acertadas int,
    nivel_Pasado boolean,
    dificultad int,
    Constraint PK_Partidas Primary key (id_Partida)
);

drop table if exists Jugador;
Create table if not exists Jugador(
	id_Jugador int auto_increment,
    nombre varchar(100),
    contrasena varchar(20),
    Constraint PK_Jugador Primary key (id_Jugador)
);

drop table if exists Partidas_Jugador;
Create table if not exists Partidas_Jugador(
	id_Jugador int,
	id_Partida int,
    constraint PK_partidasJugador Primary key (id_partida, id_jugador),
    constraint FK_IdJugador foreign key (id_jugador) references Jugador(id_jugador) on delete cascade on update cascade,
    constraint FK_IdPartida foreign key (id_partida) references Partidas(id_partida) on delete cascade on update cascade    
);
