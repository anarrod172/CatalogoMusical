DROP DATABASE catalogoMusica;
CREATE DATABASE catalogoMusica;
USE catalogoMusica;


-- Datos de Discográfica
DELETE FROM discografica;
INSERT INTO discografica VALUES(1, 'Calle Alfonso Fraile, 12' ,'Warner Spain', '435667778');
INSERT INTO discografica VALUES (2, 'Avenida de la Música, 15', 'Sony Music', '434567889');
INSERT INTO discografica VALUES (3, 'Calle del Sol, 25', 'Universal Music', '431234567');
INSERT INTO discografica VALUES (4,  'Plaza Mayor, 18', 'EMI Records','436789012');
INSERT INTO discografica VALUES(5,  'Avenida Libertad, 30','Island Records', '432345678');

-- Datos de Album
INSERT INTO album VALUES(1, 2013 ,'Pólvora', 1);
INSERT INTO album VALUES (2, 2016, 'Mismo Sitio, Distinto Lugar', 2);
INSERT INTO album VALUES (3, 2004, 'Estados de Ánimo',3);
INSERT INTO album VALUES (4, 2019, 'Nuclear', 4);
INSERT INTO album VALUES(5,  '2009','Un día en el mundo', 5);

-- Datos de Canciones
INSERT INTO cancion VALUES(1, 230 ,'Todo lo que importa', 1);
INSERT INTO cancion VALUES (2, 187, 'Los Espíritus', 2);
INSERT INTO cancion VALUES (3, 175, 'La madre de José', 3);
INSERT INTO cancion VALUES (4,  320, 'La Reina del Río', 5);
INSERT INTO cancion VALUES(5,  250, 'Copenhague', 6);
                                
                               