package especies

class Distribution {

	static belongsTo = [taxa: Taxon, geoEntity: GeoEntity]
	
    static constraints = {
    }
}
