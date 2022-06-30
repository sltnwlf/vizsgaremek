# Portio weboldal tesztelése

Az alkalmazás a [Portio](https://lennertamas.github.io/portio/) weboldal felületét teszteli, változatos szempontok alapján.


## Követelmények:

- Adatkezelési nyilatkozat használata
- Regisztráció
- Bejelentkezés
- Kijelentkezés
- Több oldalas lista bejárása
- Adatok listázása
- Új adat bevitel
- Ismételt és sorozatos adatbevitel adatforrásból
- Adatok lementése felületről
- Meglévő adat módosítás
- Adat vagy adatok törlése


## Tesztek futtatása:

- Klónozzuk le a repót: [Vizsgaremek GitHub link](https://github.com/sltnwlf/vizsgaremek)
- A választott integrált fejlesztői környezetünkben (ajánlott: IntelliJ IDEA) futtathatjuk a teszeseteket.
- Miután megnyitottuk a projektet, a java teszt fájlra jobb gombbal kattintva kiválaszthatjuk a futtatást.
- ![Szemléltetés](https://user-images.githubusercontent.com/70565508/176660079-14d05b52-8bf4-4b6f-a063-ec2b2697156a.jpg)


Az alkalmazás programnyelve a Java.

A teszek manuális változata itt érhető el: [Tesztmenedzser](https://docs.google.com/spreadsheets/d/1WtmtIIeiKt6JyAhC4ozFHMczu5a7kk5kagEljPkhrGE/edit#gid=1257095171)

Az átfogó Allure reportot, a projekt github linken keresztüli klónozása után, a projekt mappájából megnyitott, terminálba beírt "mvn allure:serve" parancs segítségével tekinthetjük meg.
