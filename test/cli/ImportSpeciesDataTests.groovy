import grails.test.AbstractCliTestCase

class ImportSpeciesDataTests extends AbstractCliTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testImportSpeciesData() {

        execute(["import-species-data"])

        assertEquals 0, waitForProcess()
        verifyHeader()
    }
}
