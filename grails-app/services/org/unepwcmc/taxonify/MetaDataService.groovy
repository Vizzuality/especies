package org.unepwcmc.taxonify

import grails.transaction.Transactional

@Transactional
class MetaDataService {

    def list(params) {
        params = params + [max: 50]

        return [MetaData.list(params), MetaData.count()]
    }
}