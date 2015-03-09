databaseChangeLog = {

	changeSet(author: "Simao (generated)", id: "1425637930341-1") {
		dropTable(tableName: "tmp_brazil_data")
	}

	changeSet(author: "Simao (generated)", id: "1425637930341-2") {
		dropTable(tableName: "tmp_cites_data")
	}

	changeSet(author: "Simao (generated)", id: "1425637930341-3") {
		dropTable(tableName: "tmp_common_names")
	}

	changeSet(author: "Simao (generated)", id: "1425637930341-4") {
		dropTable(tableName: "tmp_distributions")
	}

	changeSet(author: "Simao (generated)", id: "1425637930341-5") {
		dropTable(tableName: "tmp_gbif_brazil_data")
	}

	changeSet(author: "Simao (generated)", id: "1425637930341-6") {
		dropTable(tableName: "tmp_gbif_species_data")
	}

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
