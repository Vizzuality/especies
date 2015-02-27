package especies

import grails.converters.JSON

class TaxaController {
	
	def taxonService
	def importDataService
	
    def index() {
        def taxa = taxonService.list(params)
        [taxa: taxa, taxaCount: Taxon.count()]
    }
    
    def importTaxa() {
		importDataService.importData()
		def taxa = taxonService.list([:])
		render taxa as JSON
    }
}
