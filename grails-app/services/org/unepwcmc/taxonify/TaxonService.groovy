package org.unepwcmc.taxonify

import grails.transaction.Transactional

@Transactional
class TaxonService {

    def list(params) {
		params = params + [max: 50]
		params = params + [sort: "scientificName", order: "asc"]
        def query = Taxon.createCriteria()
        def results = query.list(params) {
            switch(params.get('collection')) {
                case 'speciesplus':
                    isNotNull("speciesPlusId")
                    break
                case 'gbif':
                    isNotNull("gbifId")
                    break
                default:
                    isNotNull("sourceId")
            }
            if(!params.get('query').isEmpty()) {
                def searchQ = params.get("query")+"%"
                ilike("scientificName", searchQ)
            }
        }
		return [results, results.totalCount]
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
