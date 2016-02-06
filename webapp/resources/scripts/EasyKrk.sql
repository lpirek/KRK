CREATE SCHEMA easykrkdb;
USE easykrkdb;
CREATE TABLE `ProgramKsztalcenia` (
  `id`                int(11) NOT NULL AUTO_INCREMENT, 
  `aktualnyOd`        timestamp NOT NULL, 
  `typStudiow`        varchar(15) NOT NULL, 
  `formaStudiow`      varchar(15) NOT NULL, 
  `stopienStudiow`     varchar(15) NOT NULL, 
  `KierunekStudiowid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `ObszarKsztalcenia` (
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `KierunekStudiow` (
  `id`        int(11) NOT NULL AUTO_INCREMENT, 
  `nazwa`     varchar(255) NOT NULL, 
  `Wydzialid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `ProgramStudiow` (
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `ProgramKsztalceniaid`  int(11), 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `PlanStudiow` (
  `id`                   int(11) NOT NULL AUTO_INCREMENT, 
  `ProgramKsztalceniaid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `Wydzial` (
  `id`    int(11) NOT NULL AUTO_INCREMENT, 
  `nazwa` varchar(255) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `Specjalizacja` (
  `id`                int(11) NOT NULL AUTO_INCREMENT, 
  `nazwa`             varchar(255) NOT NULL, 
  `KierunekStudiowid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `MinisterialnyEfektKsztalcenia` (
  `id`                  int(11) NOT NULL AUTO_INCREMENT, 
  `zakres`              varchar(15) NOT NULL, 
  `numer`               varchar(255) NOT NULL, 
  `opis`                varchar(255) NOT NULL, 
  `ObszarKsztalceniaid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `KierunkowyEfektKsztalcenia` (
  `id`                int(11) NOT NULL AUTO_INCREMENT, 
  `zakres`            varchar(15) NOT NULL, 
  `numer`             varchar(255) NOT NULL, 
  `opis`              varchar(255) NOT NULL, 
  `KierunekStudiowid` int(11) NOT NULL, 
  `Specjalizacjaid`   int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `ModulKsztalcenia` (
  `id`               int(11) NOT NULL AUTO_INCREMENT, 
  `typModulu`        varchar(15) NOT NULL, 
  `nazwa`            varchar(255) NOT NULL, 
  `ProgramStudiowid` int(11) NOT NULL, 
  `Nadmodulid`       int(11), 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `Uzytkownik` (
  `id`       int(11) NOT NULL AUTO_INCREMENT, 
  `nazwisko` varchar(255) NOT NULL, 
  `imie`     varchar(255) NOT NULL, 
  `login`    varchar(255) NOT NULL, 
  `haslo`    varchar(255) NOT NULL, 
  `email`    varchar(255) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `Semestr` (
  `id`    int(11) NOT NULL AUTO_INCREMENT, 
  `numer` smallint(2) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `RaportSyntetyczny` (
  `id`           int(11) NOT NULL AUTO_INCREMENT, 
  `data`         timestamp NOT NULL, 
  `Przedmiotid`  int(11) NOT NULL, 
  `Uzytkownikid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `Przedmiot` (
  `id`                 int(11) NOT NULL AUTO_INCREMENT, 
  `rodzaj`             varchar(31) NOT NULL, 
  `nazwaPL`            varchar(255) NOT NULL, 
  `nazwaEN`            varchar(255) NOT NULL, 
  `kod`                varchar(255) NOT NULL, 
  `Specjalizacjaid`    int(11), 
  `ModulKsztalceniaid` int(11) NOT NULL, 
  `Uzytkownikid`       int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `OcenaOsiagieciaPEK` (
  `id`                int(11) NOT NULL AUTO_INCREMENT, 
  `rodzajOceny`       varchar(15) NOT NULL, 
  `numer`             varchar(255) NOT NULL, 
  `opis`              varchar(255) NOT NULL, 
  `sposobOceny`       varchar(255) NOT NULL, 
  `KartaPrzedmiotuid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `KartaPrzedmiotu` (
  `id`              int(11) NOT NULL AUTO_INCREMENT, 
  `jezyk`           varchar(15) NOT NULL, 
  `nazwa`           varchar(255) NOT NULL, 
  `wersja`          smallint(6) NOT NULL, 
  `dataUtworzenia`  timestamp NOT NULL, 
  `status`          varchar(31) NOT NULL, 
  `kierunekStudiow` varchar(255) NOT NULL, 
  `stopienStudiow`  varchar(15) NOT NULL, 
  `formaStudiow`    varchar(15) NOT NULL, 
  `Przedmiotid`     int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `CelPrzedmiotu` (
  `id`                int(11) NOT NULL AUTO_INCREMENT, 
  `numer`             varchar(255) NOT NULL, 
  `opis`              varchar(255) NOT NULL, 
  `KartaPrzedmiotuid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `PrzedmiotowyEfektKsztalcenia` (
  `id`                int(11) NOT NULL AUTO_INCREMENT, 
  `zakres`            varchar(15) NOT NULL, 
  `numer`             varchar(255) NOT NULL, 
  `opis`              varchar(255) NOT NULL, 
  `KartaPrzedmiotuid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `NarzedzieDydaktyczne` (
  `id`                int(11) NOT NULL AUTO_INCREMENT, 
  `numer`             varchar(255) NOT NULL, 
  `opis`              varchar(255) NOT NULL, 
  `KartaPrzedmiotuid` int(11) NOT NULL, 
  `Kursid`            int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `TrescProgramowa` (
  `id`                int(11) NOT NULL AUTO_INCREMENT, 
  `trescOd`           smallint(6) NOT NULL, 
  `trescDo`           smallint(6) NOT NULL, 
  `opis`              varchar(255) NOT NULL, 
  `liczbaGodzin`      smallint(6) NOT NULL, 
  `KartaPrzedmiotuid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `PozycjaLiteraturowa` (
  `id`                int(11) NOT NULL AUTO_INCREMENT, 
  `pozycja`           smallint(6) NOT NULL, 
  `opis`              varchar(255) NOT NULL, 
  `rodzaj`            varchar(15) NOT NULL, 
  `KartaPrzedmiotuid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `WymaganiaWstepne` (
  `id`                int(11) NOT NULL AUTO_INCREMENT, 
  `pozycja`           smallint(6) NOT NULL 			, 
  `wymaganie`         varchar(255) NOT NULL, 
  `KartaPrzedmiotuid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `Kurs` (
  `id`              int(11) NOT NULL AUTO_INCREMENT, 
  `formaZajec`      varchar(15) NOT NULL, 
  `ECTS`            smallint(6) NOT NULL, 
  `ZZU`             smallint(6) NOT NULL, 
  `CNPS`            smallint(6) NOT NULL, 
  `formaZaliczenia` varchar(31) NOT NULL, 
  `punktyP`         real NOT NULL, 
  `punktyBK`        real NOT NULL, 
  `kod`             varchar(255) NOT NULL, 
  `liczbaZajec`     smallint(6) NOT NULL, 
  `Przedmiotid`     int(11) NOT NULL, 
  `Semestrid`       int(11) NOT NULL, 
  `GrupaKursowid`   int(11), 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `GrupaKursow` (
  `id`          int(11) NOT NULL AUTO_INCREMENT, 
  `kod`         varchar(255) NOT NULL, 
  `Przedmiotid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `MEKKEK` (
  `id`                              int(11) NOT NULL AUTO_INCREMENT, 
  `KierunkowyEfektKsztalceniaid`    int(11) NOT NULL, 
  `MinisterialnyEfektKsztalceniaid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `KEKPEK` (
  `id`                             int(11) NOT NULL AUTO_INCREMENT, 
  `KierunkowyEfektKsztalceniaid`   int(11) NOT NULL, 
  `PrzedmiotowyEfektKsztalceniaid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `PEKCelPrzedmiotu` (
  `id`                             int(11) NOT NULL AUTO_INCREMENT, 
  `CelPrzedmiotuId`                int(11) NOT NULL, 
  `PrzedmiotowyEfektKsztalceniaid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `PEKNarzedzieDydaktyczne` (
  `id`                             int(11) NOT NULL AUTO_INCREMENT, 
  `NarzedzieDydaktyczneid`         int(11) NOT NULL, 
  `PrzedmiotowyEfektKsztalceniaid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `PEKTrescProgramowa` (
  `id`                             int(11) NOT NULL AUTO_INCREMENT, 
  `TrescProgramowaid`              int(11) NOT NULL, 
  `PrzedmiotowyEfektKsztalceniaid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `PEKOcenaOsiagnieciaPEK` (
  `id`                             int(11) NOT NULL AUTO_INCREMENT, 
  `OcenaOsiagieciaPEKId`           int(11) NOT NULL, 
  `PrzedmiotowyEfektKsztalceniaid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `PrzedmiotKEK` (
  `id`                           int(11) NOT NULL AUTO_INCREMENT, 
  `KierunkowyEfektKsztalceniaid` int(11) NOT NULL, 
  `Przedmiotid`                  int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `PlanStudiowSemestr` (
  `id`            int(11) NOT NULL AUTO_INCREMENT, 
  `Semestrid`     int(11) NOT NULL, 
  `PlanStudiowid` int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `ProgramKsztalceniaObszarKsztalcenia` (
  `id`                   int(11) NOT NULL AUTO_INCREMENT, 
  `ProgramKsztalceniaid` int(11) NOT NULL, 
  `ObszarKsztalceniaid`  int(11) NOT NULL, 
  PRIMARY KEY (`id`)) ENGINE=InnoDB CHARACTER SET UTF8;
ALTER TABLE `PlanStudiow` ADD INDEX `FKPlanStudio339978` (`ProgramKsztalceniaid`), ADD CONSTRAINT `FKPlanStudio339978` FOREIGN KEY (`ProgramKsztalceniaid`) REFERENCES `ProgramKsztalcenia` (`id`);
ALTER TABLE `ProgramStudiow` ADD INDEX `FKProgramStudio706035` (`ProgramKsztalceniaid`), ADD CONSTRAINT `FKProgramStudio706035` FOREIGN KEY (`ProgramKsztalceniaid`) REFERENCES `ProgramKsztalcenia` (`id`);
ALTER TABLE `PlanStudiowSemestr` ADD INDEX `FKPlanStudio821472` (`PlanStudiowid`), ADD CONSTRAINT `FKPlanStudio821472` FOREIGN KEY (`PlanStudiowid`) REFERENCES `PlanStudiow` (`id`);
ALTER TABLE `PlanStudiowSemestr` ADD INDEX `FKPlanStudio226958` (`Semestrid`), ADD CONSTRAINT `FKPlanStudio226958` FOREIGN KEY (`Semestrid`) REFERENCES `Semestr` (`id`);
ALTER TABLE `Kurs` ADD INDEX `FKKurs370540` (`Semestrid`), ADD CONSTRAINT `FKKurs370540` FOREIGN KEY (`Semestrid`) REFERENCES `Semestr` (`id`);
ALTER TABLE `ModulKsztalcenia` ADD INDEX `FKModulKszta296975` (`ProgramStudiowid`), ADD CONSTRAINT `FKModulKszta296975` FOREIGN KEY (`ProgramStudiowid`) REFERENCES `ProgramStudiow` (`id`);
ALTER TABLE `ModulKsztalcenia` ADD INDEX `FKModulKszta142733` (`Nadmodulid`), ADD CONSTRAINT `FKModulKszta142733` FOREIGN KEY (`Nadmodulid`) REFERENCES `ModulKsztalcenia` (`id`);
ALTER TABLE `ProgramKsztalcenia` ADD INDEX `FKProgramKsz719397` (`KierunekStudiowid`), ADD CONSTRAINT `FKProgramKsz719397` FOREIGN KEY (`KierunekStudiowid`) REFERENCES `KierunekStudiow` (`id`);
ALTER TABLE `KierunekStudiow` ADD INDEX `FKKierunekSt950672` (`Wydzialid`), ADD CONSTRAINT `FKKierunekSt950672` FOREIGN KEY (`Wydzialid`) REFERENCES `Wydzial` (`id`);
ALTER TABLE `Specjalizacja` ADD INDEX `FKSpecjaliza209730` (`KierunekStudiowid`), ADD CONSTRAINT `FKSpecjaliza209730` FOREIGN KEY (`KierunekStudiowid`) REFERENCES `KierunekStudiow` (`id`);
ALTER TABLE `KierunkowyEfektKsztalcenia` ADD INDEX `FKKierunkowy842387` (`KierunekStudiowid`), ADD CONSTRAINT `FKKierunkowy842387` FOREIGN KEY (`KierunekStudiowid`) REFERENCES `KierunekStudiow` (`id`);
ALTER TABLE `MinisterialnyEfektKsztalcenia` ADD INDEX `FKMinisteria806944` (`ObszarKsztalceniaid`), ADD CONSTRAINT `FKMinisteria806944` FOREIGN KEY (`ObszarKsztalceniaid`) REFERENCES `ObszarKsztalcenia` (`id`);
ALTER TABLE `MEKKEK` ADD INDEX `FKMEKKEK415676` (`MinisterialnyEfektKsztalceniaid`), ADD CONSTRAINT `FKMEKKEK415676` FOREIGN KEY (`MinisterialnyEfektKsztalceniaid`) REFERENCES `MinisterialnyEfektKsztalcenia` (`id`);
ALTER TABLE `MEKKEK` ADD INDEX `FKMEKKEK143788` (`KierunkowyEfektKsztalceniaid`), ADD CONSTRAINT `FKMEKKEK143788` FOREIGN KEY (`KierunkowyEfektKsztalceniaid`) REFERENCES `KierunkowyEfektKsztalcenia` (`id`);
ALTER TABLE `KEKPEK` ADD INDEX `FKKEKPEK890233` (`KierunkowyEfektKsztalceniaid`), ADD CONSTRAINT `FKKEKPEK890233` FOREIGN KEY (`KierunkowyEfektKsztalceniaid`) REFERENCES `KierunkowyEfektKsztalcenia` (`id`);
ALTER TABLE `KEKPEK` ADD INDEX `FKKEKPEK9702` (`PrzedmiotowyEfektKsztalceniaid`), ADD CONSTRAINT `FKKEKPEK9702` FOREIGN KEY (`PrzedmiotowyEfektKsztalceniaid`) REFERENCES `PrzedmiotowyEfektKsztalcenia` (`id`);
ALTER TABLE `Przedmiot` ADD INDEX `FKPrzedmiot203109` (`ModulKsztalceniaid`), ADD CONSTRAINT `FKPrzedmiot203109` FOREIGN KEY (`ModulKsztalceniaid`) REFERENCES `ModulKsztalcenia` (`id`);
ALTER TABLE `Przedmiot` ADD INDEX `FKPrzedmiot159546` (`Specjalizacjaid`), ADD CONSTRAINT `FKPrzedmiot159546` FOREIGN KEY (`Specjalizacjaid`) REFERENCES `Specjalizacja` (`id`);
ALTER TABLE `KierunkowyEfektKsztalcenia` ADD INDEX `FKKierunkowy221877` (`Specjalizacjaid`), ADD CONSTRAINT `FKKierunkowy221877` FOREIGN KEY (`Specjalizacjaid`) REFERENCES `Specjalizacja` (`id`);
ALTER TABLE `PrzedmiotKEK` ADD INDEX `FKPrzedmiotK840234` (`Przedmiotid`), ADD CONSTRAINT `FKPrzedmiotK840234` FOREIGN KEY (`Przedmiotid`) REFERENCES `Przedmiot` (`id`);
ALTER TABLE `PrzedmiotKEK` ADD INDEX `FKPrzedmiotK336815` (`KierunkowyEfektKsztalceniaid`), ADD CONSTRAINT `FKPrzedmiotK336815` FOREIGN KEY (`KierunkowyEfektKsztalceniaid`) REFERENCES `KierunkowyEfektKsztalcenia` (`id`);
ALTER TABLE `RaportSyntetyczny` ADD INDEX `FKRaportSynt933592` (`Uzytkownikid`), ADD CONSTRAINT `FKRaportSynt933592` FOREIGN KEY (`Uzytkownikid`) REFERENCES `Uzytkownik` (`id`);
ALTER TABLE `RaportSyntetyczny` ADD INDEX `FKRaportSynt367580` (`Przedmiotid`), ADD CONSTRAINT `FKRaportSynt367580` FOREIGN KEY (`Przedmiotid`) REFERENCES `Przedmiot` (`id`);
ALTER TABLE `KartaPrzedmiotu` ADD INDEX `FKKartaPrzed41583` (`Przedmiotid`), ADD CONSTRAINT `FKKartaPrzed41583` FOREIGN KEY (`Przedmiotid`) REFERENCES `Przedmiot` (`id`);
ALTER TABLE `OcenaOsiagieciaPEK` ADD INDEX `FKOcenaOsiag875304` (`KartaPrzedmiotuid`), ADD CONSTRAINT `FKOcenaOsiag875304` FOREIGN KEY (`KartaPrzedmiotuid`) REFERENCES `KartaPrzedmiotu` (`id`);
ALTER TABLE `PEKOcenaOsiagnieciaPEK` ADD INDEX `FKPEKOcenaOs298228` (`OcenaOsiagieciaPEKId`), ADD CONSTRAINT `FKPEKOcenaOs298228` FOREIGN KEY (`OcenaOsiagieciaPEKId`) REFERENCES `OcenaOsiagieciaPEK` (`id`);
ALTER TABLE `PEKOcenaOsiagnieciaPEK` ADD INDEX `FKPEKOcenaOs252483` (`PrzedmiotowyEfektKsztalceniaid`), ADD CONSTRAINT `FKPEKOcenaOs252483` FOREIGN KEY (`PrzedmiotowyEfektKsztalceniaid`) REFERENCES `PrzedmiotowyEfektKsztalcenia` (`id`);
ALTER TABLE `PrzedmiotowyEfektKsztalcenia` ADD INDEX `FKPrzedmioto368719` (`KartaPrzedmiotuid`), ADD CONSTRAINT `FKPrzedmioto368719` FOREIGN KEY (`KartaPrzedmiotuid`) REFERENCES `KartaPrzedmiotu` (`id`);
ALTER TABLE `CelPrzedmiotu` ADD INDEX `FKCelPrzedmi444052` (`KartaPrzedmiotuid`), ADD CONSTRAINT `FKCelPrzedmi444052` FOREIGN KEY (`KartaPrzedmiotuid`) REFERENCES `KartaPrzedmiotu` (`id`);
ALTER TABLE `PozycjaLiteraturowa` ADD INDEX `FKPozycjaLit304101` (`KartaPrzedmiotuid`), ADD CONSTRAINT `FKPozycjaLit304101` FOREIGN KEY (`KartaPrzedmiotuid`) REFERENCES `KartaPrzedmiotu` (`id`);
ALTER TABLE `WymaganiaWstepne` ADD INDEX `FKWymaganiaW61956` (`KartaPrzedmiotuid`), ADD CONSTRAINT `FKWymaganiaW61956` FOREIGN KEY (`KartaPrzedmiotuid`) REFERENCES `KartaPrzedmiotu` (`id`);
ALTER TABLE `TrescProgramowa` ADD INDEX `FKTrescProgr527318` (`KartaPrzedmiotuid`), ADD CONSTRAINT `FKTrescProgr527318` FOREIGN KEY (`KartaPrzedmiotuid`) REFERENCES `KartaPrzedmiotu` (`id`);
ALTER TABLE `NarzedzieDydaktyczne` ADD INDEX `FKNarzedzieD916437` (`KartaPrzedmiotuid`), ADD CONSTRAINT `FKNarzedzieD916437` FOREIGN KEY (`KartaPrzedmiotuid`) REFERENCES `KartaPrzedmiotu` (`id`);
ALTER TABLE `NarzedzieDydaktyczne` ADD INDEX `FKNarzedzieD40365` (`Kursid`), ADD CONSTRAINT `FKNarzedzieD40365` FOREIGN KEY (`Kursid`) REFERENCES `Kurs` (`id`);
ALTER TABLE `Kurs` ADD INDEX `FKKurs480839` (`Przedmiotid`), ADD CONSTRAINT `FKKurs480839` FOREIGN KEY (`Przedmiotid`) REFERENCES `Przedmiot` (`id`);
ALTER TABLE `GrupaKursow` ADD INDEX `FKGrupaKurso315654` (`Przedmiotid`), ADD CONSTRAINT `FKGrupaKurso315654` FOREIGN KEY (`Przedmiotid`) REFERENCES `Przedmiot` (`id`);
ALTER TABLE `Kurs` ADD INDEX `FKKurs500732` (`GrupaKursowid`), ADD CONSTRAINT `FKKurs500732` FOREIGN KEY (`GrupaKursowid`) REFERENCES `GrupaKursow` (`id`);
ALTER TABLE `PEKCelPrzedmiotu` ADD INDEX `FKPEKCelPrze722136` (`CelPrzedmiotuId`), ADD CONSTRAINT `FKPEKCelPrze722136` FOREIGN KEY (`CelPrzedmiotuId`) REFERENCES `CelPrzedmiotu` (`id`);
ALTER TABLE `PEKCelPrzedmiotu` ADD INDEX `FKPEKCelPrze778784` (`PrzedmiotowyEfektKsztalceniaid`), ADD CONSTRAINT `FKPEKCelPrze778784` FOREIGN KEY (`PrzedmiotowyEfektKsztalceniaid`) REFERENCES `PrzedmiotowyEfektKsztalcenia` (`id`);
ALTER TABLE `PEKNarzedzieDydaktyczne` ADD INDEX `FKPEKNarzedz9035` (`PrzedmiotowyEfektKsztalceniaid`), ADD CONSTRAINT `FKPEKNarzedz9035` FOREIGN KEY (`PrzedmiotowyEfektKsztalceniaid`) REFERENCES `PrzedmiotowyEfektKsztalcenia` (`id`);
ALTER TABLE `PEKNarzedzieDydaktyczne` ADD INDEX `FKPEKNarzedz703771` (`NarzedzieDydaktyczneid`), ADD CONSTRAINT `FKPEKNarzedz703771` FOREIGN KEY (`NarzedzieDydaktyczneid`) REFERENCES `NarzedzieDydaktyczne` (`id`);
ALTER TABLE `PEKTrescProgramowa` ADD INDEX `FKPEKTrescPr323176` (`TrescProgramowaid`), ADD CONSTRAINT `FKPEKTrescPr323176` FOREIGN KEY (`TrescProgramowaid`) REFERENCES `TrescProgramowa` (`id`);
ALTER TABLE `PEKTrescProgramowa` ADD INDEX `FKPEKTrescPr426595` (`PrzedmiotowyEfektKsztalceniaid`), ADD CONSTRAINT `FKPEKTrescPr426595` FOREIGN KEY (`PrzedmiotowyEfektKsztalceniaid`) REFERENCES `PrzedmiotowyEfektKsztalcenia` (`id`);
ALTER TABLE `ProgramKsztalceniaObszarKsztalcenia` ADD INDEX `FKProgramKsz868421` (`ProgramKsztalceniaid`), ADD CONSTRAINT `FKProgramKsz868421` FOREIGN KEY (`ProgramKsztalceniaid`) REFERENCES `ProgramKsztalcenia` (`id`);
ALTER TABLE `ProgramKsztalceniaObszarKsztalcenia` ADD INDEX `FKProgramKsz682593` (`ObszarKsztalceniaid`), ADD CONSTRAINT `FKProgramKsz682593` FOREIGN KEY (`ObszarKsztalceniaid`) REFERENCES `ObszarKsztalcenia` (`id`);
ALTER TABLE `Przedmiot` ADD INDEX `FKPrzedmiot697913` (`Uzytkownikid`), ADD CONSTRAINT `FKPrzedmiot697913` FOREIGN KEY (`Uzytkownikid`) REFERENCES `Uzytkownik` (`id`);
