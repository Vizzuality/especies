package org.unepwcmc.taxonify

class Taxon {
    String kingdomName
    String phylumName
    String orderName
    String className
    String familyName
    String genusName
    String scientificName
	String nameStatus
	String gbifName
    Integer sourceId
    Integer gbifId
	Integer speciesPlusId
    String citesListing
    String description

	static hasMany = [distributions: Distribution]
	
    static constraints = {
		phylumName nullable: true
		orderName nullable: true
		className nullable: true
		familyName nullable: true
		nameStatus nullable: true
		gbifName nullable: true
		gbifId nullable: true
		speciesPlusId nullable: true
		sourceId unique: true, nullable: true
        citesListing nullable: true
        description nullable: true
    }
}
