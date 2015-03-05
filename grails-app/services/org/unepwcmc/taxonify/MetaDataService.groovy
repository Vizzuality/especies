package org.unepwcmc.taxonify

import grails.transaction.Transactional

@Transactional
class MetaDataService {

    def list(params, type) {
        params = params + [max: 50]
        
        def query = MetaData.where {
            type == type
        }

        return [query.list(params), query.count()]
    }
}