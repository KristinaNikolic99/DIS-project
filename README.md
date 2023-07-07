# DIS-project
## Opis poslovne logike
Aplikacija implementirana u okviru ovog projektnog zadatka ima namenu prikaza rada razlicitih mikroservisa i njihove međusobne komunikacije. U okviru ovog projektnog zadatka implementirano je ukupno osam mikroservisa, a glavna logika razvijena je oko mikroservisa employee koji komunicira sa mikroservisima education, healthcard, sector i company i u okviru kog su implementirane sve bezbednosne provere kako bi servis uspešno komunicirao sa ostalim mikroservisima iz kojih izvlači
neophodne informacije. Za navedene mikroservise su implementirane i test metode za svaki kontroler.

Takođe, implementirani su i mikroservisi naming servera na kojem su registrovane instance svakog mikroservisa i koji ima ulogu load balancinga,
odnosno hendlovanja zahteva upućenih od strane korisnika kao i mikroservis API Gateway koji ima ulogu rutiranja svakog mikroservisa, kao i implementirane
circuit breaker funkcionalnosti koji u slučaju zahteva koji je upućen nekom mikroservisu ne vraća odgovor (mikroservis nije u funkciji) vraća fallback metode koje obaveštavaju da navedeni mikroservis nije u funkciji. Isto tako, dodat je i rate limiter koji ogranicava koliko puta u određenom vremenskom periodu 
možemo pozvati određene funkcionalnosti mikroservisa kao i bulkhead mehanizam koji ograničava broj konkurentnih poziva. 

Takođe, na samom početku obezbeđena je i jwt autentikacija korišćenjem spring cloud gateway-a i kreiran je identity service koji omogućava uspešnu autentikaciju kao i autorizaciju korisnika koji žele da pristupe ostalim mikroservisima. Prilikom pristupa svakom mikroservisu preko api gateway-a potrebno je izvršiti uspešnu autorizaciju korisnika. 

Pored toga, implementiran je i tracing sistem koji je odgovoran za praćenje toka izvršavanja jedne konkretne instance nekog mikroservisa, odnosno praćenje requesta koji prolazi kroz ostale mikroservise. Ovaj sistem je povezan za svakim mikroservisom i svaki od njega mu šalje određene informacije kada request dođe do njega, a tracing sistem nam onda tačno prikazuje gde se dogodila greška(ako je do nje došlo) i celokupan tok izvršavanja što pruža pomoć prilikom monitoringa.

Isto tako, implementiran je i docker koji nam omogućava da pokrenemo bilo koju aplikacjiu na bilo kojem računaru. Za svaki mikroservis (projekat) je napravljen kao image i dodat na docker hub kako bi se omogućio uspešan build svih komponenti aplikacije sa različitih računara, a u okviru docker-compose.yaml fajla dodate su sve neophodne instrukcije kako bi to pokretanje na kraju bilo uspešno.

## Class diagram
![Class diagram](class-diagram (1).jpeg)
