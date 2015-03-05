package org.unepwcmc.taxonify

class DashboardController {

    def index() {
		def stats = [
				'jbrjPlants': [
					'title': 'JBRJ IPT - Flora',
                    'total': Taxon.where {
                        kingdomName == 'Plants'
                    }.count(),
					'totalAccepted': Taxon.where {
						kingdomName == 'Plants' && nameStatus == 'NOME_ACEITO'
					}.count(),
                    'totalSynonyms': Taxon.where {
                        kingdomName == 'Plants' && nameStatus == 'SINONIMO'
                    }.count()
				],
				'jbrjAnimals': [
					'title': 'JBRJ IPT - Fauna',
					'total': Taxon.where {
						kingdomName == 'Animals'
                    }.count(),
                    'totalAccepted': Taxon.where {
                        kingdomName == 'Animals' && nameStatus == 'NOME_ACEITO'
                    }.count(),
                    'totalSynonyms': Taxon.where {
                        kingdomName == 'Animals' && nameStatus == 'SINONIMO'
                    }.count()
                ],
				'speciesPlus': [
					'title': 'WCMC SP+',
					'total': Taxon.where {
						speciesPlusId != null
                    }.count(),
                    'totalAccepted': Taxon.where {
                        speciesPlusId != null && nameStatus == 'NOME_ACEITO'
                    }.count(),
                    'totalSynonyms': Taxon.where {
                        speciesPlusId != null && nameStatus == 'SINONIMO'
                    }.count()
                ],
				'gbif': [
					'title': 'GBIF',
					'total': Taxon.where {
						gbifId != null
                    }.count(),
                    'totalAccepted': Taxon.where {
                        gbifId != null && nameStatus == 'NOME_ACEITO'
                    }.count(),
                    'totalSynonyms': Taxon.where {
                        gbifId != null && nameStatus == 'SINONIMO'
                    }.count()
				]
				
			]
		def auxStats = [
			'distributions': [
				'title': 'Distributions',
				'total': MetaData.where {
                    type == 'DISTRIBUTION'
                }.count()
			]
		]
		[stats: stats, auxStats: auxStats]
	}
}
