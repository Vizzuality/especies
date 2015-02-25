package especies

import grails.converters.JSON

class TaxaController {

    def index() {
        def taxa = Taxon.list(max:50)
        [taxa: taxa]
    }
    
    def importTaxa() {

		// import Brazil's species
        def file = new File('data/species_list_Brazil.csv')
        file.toCsvReader(['charset':'UTF-8', 'skipLines': 1]).eachLine { tokens ->			
            new Taxon(
                kingdomName: tokens[0] ? tokens[0] : "",
                phylumName: tokens[1] ? tokens[1] : "",
                className: tokens[2] ? tokens[2] : "",
                orderName: tokens[3] ? tokens[3] : "",
                familyName: tokens[4] ? tokens[4] : "",
                genusName: tokens[5] ? tokens[5] : "",
                scientificName: tokens[5] + ' ' + tokens[6],
                sourceId: Integer.parseInt(tokens[7])
            ).save(failOnError: true)
        }
		def taxa = Taxon.list(max: 50)
		render taxa as JSON
    }
	
	def addSpeciesPlusData() {
		
		def file = new File('data/species_list_CITES.csv')
		Taxon taxon
		file.toCsvReader(['charset': 'UTF-8', 'skiplines': 1]).eachLine { tokens ->
			taxon = Taxon.findByScientificName(tokens[5] + ' ' + tokens[6])
			if(taxon != null) {
				taxon.speciesPlusId = tokens[7]
				taxon.save(failOnError: true)
			}
		}
		render "SpeciesPlus Done!"
    }
}
