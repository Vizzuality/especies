package especies
import grails.plugins.rest.client.RestBuilder

class TaxaController {

    def index(String query) {
        def url = "https://simbiotica.cartodb.com/api/v1/sql"
        def my_q
        if(query != null) {
            my_q = "SELECT * FROM species_list_merged where genus_name iLIKE "+
                    "'%"+query+"%' OR scientific_name iLIKE '" + query + "%' " +
                    "ORDER BY scientific_name"
        } else {
            my_q = "SELECT * FROM species_list_merged LIMIT 100"
        }

        def result =  new RestBuilder().post(url+"?q={q}", [q: my_q]).json
        def taxa
        if(result.containsKey('rows')) {
            taxa = result.get('rows')
        } else {
            taxa = []
        }
        render view: 'list', model: [ taxa: taxa ]
    }
}