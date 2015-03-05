package org.unepwcmc.taxonify

/**
 * Created by Simao on 02/03/15.
 */
class CommonNamesController {
    def importDataService
    def metaDataService

    def index() {
        def results = metaDataService.list(params, 'COMMON_NAME')
        [commonNames: results[0], commonNamesCount: results[1]]
    }

    def importData() {
        importDataService.importMetaData()
    }

}
