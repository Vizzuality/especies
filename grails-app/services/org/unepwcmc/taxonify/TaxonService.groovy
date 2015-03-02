package org.unepwcmc.taxonify

import grails.transaction.Transactional

@Transactional
class TaxonService {

    def list(params) {
		params = params + [max: 50]
		params = params + [sort: "scientificName", order: "asc"]
		def query
		switch(params.get('collection')) {
			case 'speciesplus':
				query = Taxon.where {
					speciesPlusId != null
				}
				break
			case 'gbif':
				query = Taxon.where {
					gbifId != null
				}
				break
			default:
				query = Taxon.where {
					sourceId != null
				}
		}
		if(params.get('query') != null) {
			query = query.where {
				scientificName =~ params.get('query')+'%'
			}
		}
		return [query.list(params), query.count()]
    }
	
	Taxon save(taxon) {
		taxon.save()
	}
	
	Taxon addGbifDetails(scientificName, sourceId, gbifId, gbifName) {
		Taxon taxon
		if(sourceId == "#N/A") {
			taxon = Taxon.findByScientificNameLike(scientificName)
		} else {
			taxon = Taxon.findBySourceId(sourceId)
		}
		if(taxon != null && gbifId != "NULL") {
			taxon.gbifId = Integer.parseInt(gbifId)
			taxon.gbifName = gbifName
			taxon.save()
		}
		taxon
	}
	
	Taxon addSpeciesPlusId(gbifId, speciesPlusId) {
		Taxon taxon = Taxon.findByGbifId(gbifId)
		if(taxon != null) {
			taxon.speciesPlusId = speciesPlusId
			taxon.save()
		}
		taxon
	}
}
