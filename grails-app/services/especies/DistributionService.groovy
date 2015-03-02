package especies

import grails.transaction.Transactional

@Transactional
class DistributionService {

	def list(params) {
		params = params + [max: 50]
		return [Distribution.list(params), Distribution.count()]
    }
}
