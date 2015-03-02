package org.unepwcmc.taxonify

class Distribution {

	static belongsTo = [taxon: Taxon, geoEntity: GeoEntity]
	
    static constraints = {
    }
}
