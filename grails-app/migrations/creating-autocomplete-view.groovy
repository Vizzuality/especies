databaseChangeLog = {

    changeSet(author: "Simao (generated)", id: "1425637930341-7") {
        createView("""
            SELECT DISTINCT taxon.id, taxon.scientific_name
            FROM taxon
            UNION
            SELECT DISTINCT taxon_id, value
            FROM meta_data
            WHERE type = 'COMMON_NAME'
        """, viewName: 'taxon_search_view')
    }
}
