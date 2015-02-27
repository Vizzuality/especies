package especies

import grails.converters.JSON

class TaxaController {
	
	def taxonService
	def importDataService
	
    def index() {
        def taxa = taxonService.list(params)
        [taxa: taxa[0], taxaCount: taxa[1]]
    }
    
    def importTaxa() {
		importDataService.importData()
		def taxa = taxonService.list([:])
		render taxa[0] as JSON
    }
}
