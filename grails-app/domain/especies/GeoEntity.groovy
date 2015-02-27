package especies

class GeoEntity {
	String name
	String isoCode

	static hasMany = [distributions: Distribution]
    static constraints = {
		name nullable: true
		isoCode nullable: true
    }
}
