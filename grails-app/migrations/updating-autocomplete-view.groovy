databaseChangeLog = {

    changeSet(author: "Simao (generated)", id: "1425637930341-8") {
        dropView(viewName: 'taxon_search_view')
        createView("""
            SELECT DISTINCT taxon.id, taxon.scientific_name
            FROM taxon
            WHERE name_status = 'NOME_ACEITO'
            UNION
            SELECT DISTINCT taxon_id, value
            FROM meta_data
            WHERE type = 'COMMON_NAME'
        """, viewName: 'taxon_search_view')
    }
}
