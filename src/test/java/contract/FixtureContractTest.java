package contract;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.dish.ofm.commonutils.ResourceReader.readFixture;
import static com.dish.ofm.commonutils.ResourceReader.readSchema;
import static org.junit.Assert.assertTrue;

public class FixtureContractTest {
    private static Logger LOGGER = LoggerFactory.getLogger(FixtureContractTest.class);

    @Ignore
    @Test
    public void validateFIXTURE_NAME() throws Exception {
        validateFixtureAgainstSchema(
            "CONTRACT_NAME.json",
            "request/FIXTURE_NAME.json");
    }

    private void validateFixtureAgainstSchema(String schemaFilename, String fixtureFilename) throws Exception {
        JsonNode schemaNode = JsonLoader.fromString(readSchema(schemaFilename));
        JsonNode fixture = JsonLoader.fromString(readFixture(fixtureFilename));

        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema schema = factory.getJsonSchema(schemaNode);

        ProcessingReport report = schema.validate(fixture);

        if (!report.isSuccess()) {
            LOGGER.error(report.toString());
        }

        assertTrue(report.isSuccess());
    }
}