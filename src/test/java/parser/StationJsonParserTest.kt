package parser
import main.java.parser.Station
import main.java.parser.StationJsonParser
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec


class StationJsonParserTest : StringSpec() {
    val exampleJson = "[{\"name\":\"Sammonpuistikko\",\"stationId\":\"070\",\"lat\":60.1731473,\"lon\":24.9224112},{\"name\":\"Hietaniemenkatu\",\"stationId\":\"071\",\"lat\":60.17263,\"lon\":24.911406}]"
    val sammonpuistikko = Station("Sammonpuistikko", "070", 60.1731473, 24.9224112)
    val hietaniemenkatu = Station("Hietaniemenkatu", "071", 60.17263, 24.911406)
    val endResult: List<Station> = listOf(sammonpuistikko, hietaniemenkatu)

    init {
        "StationJsonParser.parse should return a list of stations" {
            StationJsonParser().parse(exampleJson) shouldBe endResult
        }
    }
}