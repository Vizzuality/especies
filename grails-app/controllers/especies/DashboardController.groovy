package especies

class DashboardController {

    def index() {
		def stats = [
				'jbrjPlants': [
					'title': 'JBRJ IPT - Flora',
					'total': Taxon.where {
						kingdomName == 'Plants'
					}.count()
				],
				'jbrjAnimals': [
					'title': 'JBRJ IPT - Fauna',
					'total': Taxon.where {
						kingdomName == 'Animals'
					}.count()
				],
				'speciesPlus': [
					'title': 'WCMC SP+',
					'total': Taxon.where {
						speciesPlusId != null
					}.count()
				],
				'gbif': [
					'title': 'GBIF',
					'total': Taxon.where {
						gbifId != null
					}.count()
				]
				
			]
		def auxStats = [
			'distributions': [
				'title': 'Distributions',
				'total': Distribution.count()
			]
		]
		[stats: stats, auxStats: auxStats]
	}
}
