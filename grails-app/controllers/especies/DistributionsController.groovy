package especies

import grails.converters.JSON

class DistributionsController {

	def importDataService
	
    def index() {
		def distributions = Distribution.list()
		[distributions: distributions[0], distributionsCount: distributions[1]]
	}
	
	def importData() {
		importDataService.importDistributions()
		def distributions = Distribution.list()
		render distributions[0]  as JSON
	}
	
}
