# Polunetsintä Helsingin kaupunkipyöräverkossa

Tiralabrani aiheena on polunetsintäalgoritmit ja niiden vertailu.
Kyseisiä algoritmeja varten ohjelmani muodostaa Helsingin
kaupunkipyöräverkosta verkon.

Inspiraatio aiheeseen löytyi Lauri Hartikan blogikirjoituksesta, jossa
hän on tehnyt hyvin vastaavaa työtä:

[https://medium.com/@lhartikk/solving-graph-problems-with-city-bikes-of-helsinki-c02a90584814]

Koodaan tämän harjoitustyön Kotlinilla joka on JetBrainsin kehittämä
staattisesti tyypitetty ohjelmointikieli. Kotlin on suunniteltu
käytettäväksi Javan rinnalla, jolloin Kotlinista voi kutsua Java-koodia
ja Java-koodista voi kutsua Kotlin-koodia. Tämän takia Kotlinin
semantiikka on hyvin samankaltainen Javan kanssa.

Kotlinista löytyy Java-kääntäjän lisäksi myös LLVM- sekä
JavaScript-kääntäjät. Käyttöliittymän tulen Kotlinin sijaan
koodaamaan HTML-teknologioilla, jolloin voin kääntää Kotlin-koodini
JavaScriptiksi ja hyödyntää sitä selaimessa suoraan.


## Ongelma

Polunetsintäalgoritmejä käytetään usein muun muassa navigaattoreissa.
Niiden avulla pyritään löytämään lyhin reitti paikasta A paikkaan B.
Esimerkiksi navigaattoeissa karttadatasta muodostetaan verkko jota
algoritmi käy lävitse löytääkseen lyhyimmän reitin. Verkko muodostuu
solmuista ja niiden välillä olevista kaarista. Solmulla voi olla
useampi kaari. Jokaiselle kaarella määritetään paino, joka tässä
yhteydessä merkitsee kahden solmun välistä etäisyyttä.

Polunetsintää hyödynnetään myös muissa yhteyksissä. Esimerkiksi
tietoliikenneverkoissa käytetään vastaavia algoritmeja löytämään
vähiten latenssia aiheuttavia reittejä.

(Lähde: https://en.wikipedia.org/wiki/Shortest_path_problem#Applications)

## Syötteet

Kuten aiemmin mainitsin, niin ohjelma hyödyntää Helsingin
kaupunkipyöräverkostosta mielivaltaisesti painotetun verkon.

Jokaisesta pysäkistä muodostetaan kaaret seitsemään lähimpään
pysäkkiin.

Polunetsinnässä syötteinä on kaksi parametriä: lähtöpiste ja
maalipiste.

Esimerkiksi ohjelmaltani voi kysyä lyhimmän reitin Arabian
kauppakeskuksen ja Kampin metroaseman välillä.

## Ongelman ratkaiseminen ja algoritmit

Ongelman ratkaisuun on kehitetty useampi algoritmi, joista osa toimii
nopeasti ja osa ei. Jotkut ei myöskään sovellu verkoille, jotka
sisältää kaaria negatiivisilla painoilla. Olen valinnut seuraavat
algoritmit vertailuun, koska niitä on käsitelty Tietorakenteet ja
algoritmit-kurssilla.

Seuraavissa alakappaleissa esitetään myös algoritmien O-notaatioita.
Näissä S merkitsee solmujen lukumäärää ja K kaarien lukumäärää.


### Dijkstra

Dijkstran algoritmi on yksi tunnetuimmista algoritmeista. Algoritmi
käy verkkoa läpi kierroksittain aloittaen annetusta aloitussolmusta.

Ensin algoritmi käy läpi aloitussolmun naapurien etäisyydet. Näistä
sitten valitaan naapuri johon on lyhin etäisyys seuraavalle
kierrokselle. Tätä jatketaan niin kauan kunnes algoritmi kohtaa
annetun maalisolmun.

Dijkstrasta on olemassa useampi toteutus joissa käytetään eri
tietorakenteita. Toteutuksessa jossa kaaret ovat taulukossa ja
lyhyimmän etäisyyden etsinnässä käytetään lineaarista hakua
O-notaatio on O(K + S^2). Tämä on myös todennäköisesti
minun tavoiteaika. Dijkstrasta on myös mahdollista saada tehokkaampi
käyttämällä esimerkiksi kekoa.

Lähde: https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm

### Bellman-Ford

Bellman-Ford on Wikipedian mukaan 1958 julkaistu algoritmi, joka on
hiukan hitaampi. Huonoimmassa tapauksessa se suoriutuu operaatiosta
ajassa O(S*K) ja parhaimmassa tapauksessa ajassa O(K). Tilaa
algoritmi käyttää O(S).

Toisin kuin Dijkstra, Bellman-Ford suoriutuu operaatiosta myös
sellaisten verkkojen kanssa jotka sisältävät kaaria negatiivisella
painolla.

Bellman-Ford käyttää ainoastaan taulukkoja tietorakenteina.
Tietyn alkion hakeminen taulukosta tapahtuu ajassa O(1) ja
haku/lisääminen ajassa O(n). (n = taulukon koko)

Lähde: https://en.wikipedia.org/wiki/Bellman%E2%80%93Ford_algorithm

### A*

A* on vuonna 1968 julkaistu algoritmi, joka toimii laajennuksena
Dijkstran algoritmille. Se toimii hyvin samantapaisesti kuin Dijkstra,
mutta jokaisen seuraavan kierroksen solmu määritetään arvioimalla
kierroksen naapurisolmujen ja maalisolmun välinen kustannus. Näistä
jokaiselle kierrokselle valitaan solmu jolla arvioitu kustannus on
pienin. Navigoinnissa tähän voi hyödyntää esimerkiksi euklidisen
etäisyyden kaavaa.

Tyypillisessä A* toteutuksessa käytetään prioriteettijonoa vähiten
kustannusta aiheuttavan solmun löytämiseen.

Parhaimman tapauksen O-notaatio on hankala määritellä, sillä se
riippuu muun muassa siitä miten solmun ja maalisolmun kustannusarvio
tehdään. Huonoimmassa tapauksessa A* suoriutuu operaatiosta ajassa
O(K). Algoritmin tilavaativuus huonoimmassa tapauksessa on O(S).

Lähde: https://en.wikipedia.org/wiki/A*_search_algorithm

