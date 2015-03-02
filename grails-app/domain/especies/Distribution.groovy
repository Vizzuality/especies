package especies

class Distribution {

	static belongsTo = [taxon: Taxon, geoEntity: GeoEntity]
	
    static constraints = {
    }
}
