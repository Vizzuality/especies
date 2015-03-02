package org.unepwcmc.taxonify

/**
 * Created by Simao on 02/03/15.
 */
class MetaData {
    
    String value
    String type
    String details
    
    static belongsTo = [taxon: Taxon]
    
    static constraints = {
    }
}
