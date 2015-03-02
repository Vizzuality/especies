package org.unepwcmc.taxonify

import grails.converters.JSON

class DistributionsController {

	def importDataService
	def distributionService
	
    def index() {
		def distributions = distributionService.list(params)
		[distributions: distributions[0], distributionsCount: distributions[1]]
	}
	
	def importData() {
		importDataService.importDistributions()
		def distributions = Distribution.list()
		render distributions[0]  as JSON
	}
	
}
