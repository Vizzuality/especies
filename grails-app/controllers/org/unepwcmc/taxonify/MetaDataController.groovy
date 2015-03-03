package org.unepwcmc.taxonify

/**
 * Created by Simao on 02/03/15.
 */
class MetaDataController {
    def importDataService
    def metaDataService

    def index() {
        def results = metaDataService.list(params)
        [metaData: results[0], metaDataCount: results[1]]
    }

    def importData() {
        importDataService.importMetaData()
    }

}
