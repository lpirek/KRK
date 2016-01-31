INSERT INTO easykrkdb.uzytkownik(nazwisko, imie, login, haslo, email)
VALUES ('Pirek','Łukasz', 'lpirek', 'pass', 'lukasz_pirek@wp.pl');

INSERT INTO easykrkdb.wydzial(nazwa)
VALUES ('Wydział Informatyki i Zarządzania');

INSERT INTO easykrkdb.kierunekstudiow(nazwa, Wydzialid)
VALUES ('informatyka', 1);

INSERT INTO easykrkdb.programstudiow(id) 
VALUES (null);

INSERT INTO easykrkdb.programksztalcenia(aktualnyOd, typStudiow, formaStudiow, stopienStudiow, KierunekStudiowid, ProgramStudiowid)
VALUES ('2015-10-01', 'inżynierskie', 'stacjonarne', 'I stopień', 1, 1);

INSERT INTO easykrkdb.modulksztalcenia(typModulu, nazwa, ProgramStudiowid, Nadmodulid)
VALUES ('obowiązkowy', 'Przedmioty obowiązkowe kierunkowe', 1, null);

INSERT INTO easykrkdb.przedmiot(rodzaj, nazwaPL, nazwaEN, kod, Specjalizacjaid, ModulKsztalceniaid, Uzytkownikid)
VALUES ('obowiązkowy','Projektowanie Oprogramowania', 'Software design', 'INZ003838W', null, 1, 1);