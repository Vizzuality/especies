package especies

class Taxon {
    String kingdomName
    String phylumName
    String orderName
    String className
    String familyName
    String genusName
    String scientificName
	String gbifName
    Integer sourceId
    Integer gbifId
	Integer speciesPlusId

    static constraints = {
		phylumName nullable: true
		orderName nullable: true
		className nullable: true
		familyName nullable: true
		gbifName nullable: true
		gbifId nullable: true
		speciesPlusId nullable: true
		sourceId unique: true, nullable: true
    }
}
