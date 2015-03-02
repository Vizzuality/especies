package org.unepwcmc.taxonify

import net.kaleidos.hibernate.usertype.JsonMapType

/**
 * Created by Simao on 02/03/15.
 */
class MetaData {
    
    String value
    String type
    Map data

    static belongsTo = [taxon: Taxon]
    
    static constraints = {
    }
    
    static mapping = {
        data type: JsonMapType
    }
}
