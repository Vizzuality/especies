package org.unepwcmc.taxonify

class DistributionsController {

	def importDataService
	def metaDataService
	
    def index() {
		def distributions = metaDataService.list(params, 'DISTRIBUTION')
		[distributions: distributions[0], distributionsCount: distributions[1]]
	}
	
	def importData() {
		importDataService.importDistributions()
        render "success"
	}
	
}
