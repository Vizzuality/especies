package especies

class TaxaController {

    def index() {
        def taxa = Taxon.findAll()
		System.out.println(taxa)
        [taxa: taxa]
    }
    
    def importTaxa() {

        def file = new File('data/species_list_CITES_copy.csv')
        file.toCsvReader(['charset':'UTF-8', 'skipLines': 1]).eachLine { tokens ->
            System.out.println(tokens[4].toString())
            new Taxon(
                kingdomName: tokens[5],
                phylumName: tokens[7],
                className: tokens[2],
                orderName: tokens[6],
                familyName: tokens[3],
                genusName: tokens[4],
                scientificName: tokens[8],
                source: tokens[9],
                sourceId: Integer.parseInt(tokens[10])
            ).save(failOnError: true)
        }
    }
}
