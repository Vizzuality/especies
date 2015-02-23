import com.opencsv.CSVReader
import especies.Taxon

includeTargets << grailsScript("_GrailsInit")

target(importSpeciesData: "The description of the script goes here!") {
    def PATH_TO_FILES = "grails-app/utils/data-dumps/"
    CSVReader reader = new CSVReader(new FileReader(PATH_TO_FILES+"species_list_Brazil.csv"))
    String [] nextLine

    while ((nextLine = reader.readNext()) != null) {
        new Taxon(
            sourceId: nextLine[0],
            source: 'Species+',
            kingdomName: nextLine[2],
            phylumName: nextLine[3],
            className: nextLine[4],
            orderName: nextLine[5],
            familyName: nextLine[6],
            genusName: nextLine[7],
            scientificName: nextLine[8]
        ).save()
    }
}

setDefaultTarget(importSpeciesData)
