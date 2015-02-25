package especies

import grails.converters.JSON

class TaxaController {

    def index() {
        def taxa = Taxon.list(max:50)
        [taxa: taxa]
    }
    
    def importTaxa() {

		// import Brazil's species
		// File format:
		// kingdom, phylum, class, order, family, genus, scientific_name, source_id
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
	
	def linkGbifAndSpeciesPlusData() {
		// File format
		// GBIF taxon key, GBIF scientific_name, rank, provided spp name, Brazil's id
		def file = new File('data/GBIF_Brazil_species_lookup.csv')
		
		Taxon taxon
		file.toCsvReader(['charset': 'UTF-8', 'skipLines': 1]).eachLine { tokens ->
			System.out.println(tokens[4]+ " " + tokens[0])
			taxon = Taxon.findBySourceId(tokens[4])
			if(taxon != null) {
				taxon.gbifId = Integer.parseInt(tokens[0])
				taxon.gbifName = tokens[1]
				taxon.save(failOnError: true)
			}
		}
		// File format
		// GBIF taxon key, GBIF scientific_name, rank, kingdom, provided spp name, species+ id
		file = new File('data/GBIF_CITES_species_lookup.csv')
		
		file.toCsvReader(['charset': 'UTF-8', 'skipLines': 1]).eachLine { tokens ->
			taxon = Taxon.findByGbifId(tokens[0])
			if(taxon != null) {
				taxon.speciesPlusId = Integer.parseInt(tokens[5])
				taxon.save(failOnError: true)
			}
		}
		
		def taxa = Taxon.list(max: 50)
		render taxa as JSON	
	}
	
	def addSpeciesPlusData() {
		
		// File format:
		// kingdom, phylum, class, order, family, genus, scientific_name, speciesplus_id
		def file = new File('data/species_list_CITES.csv')
		Taxon taxon
		file.toCsvReader(['charset': 'UTF-8', 'skiplines': 1]).eachLine { tokens ->
			taxon = Taxon.findByScientificNameLike(tokens[5] + ' ' + tokens[6])
			System.out.println(tokens[5] + ' ' + tokens[6])
			if(taxon != null) {
				taxon.speciesPlusId = tokens[7]
				taxon.save(failOnError: true)
			}
		}
		def taxa = Taxon.list(max: 50)
		render taxa as JSON
	}
}
