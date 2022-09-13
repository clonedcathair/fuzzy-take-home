package misc;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("acceptance"),
        @WithTag("sort")
})
public class FlattenJson {
        String json = "{\n" +
                "   \"Port\":\n" +
                "   {\n" +
                "       \"Alias\": \"defaultHttp\",\n" +
                "       \"Enabled\": \"true\",\n" +
                "       \"Number\": \"10092\",\n" +
                "       \"Protocol\": \"http\",\n" +
                "       \"KeepAliveTimeout\": \"20000\",\n" +
                "       \"ThreadPool\":\n" +
                "       {\n" +
                "           \"enabled\": \"false\",\n" +
                "           \"Max\": \"150\",\n" +
                "           \"ThreadPriority\": \"5\"\n" +
                "       },\n" +
                "       \"ExtendedProperties\":\n" +
                "       {\n" +
                "           \"Property\":\n" +
                "           [                         \n" +
                "               {\n" +
                "                   \"name\": \"connectionTimeout\",\n" +
                "                   \"result\": \"20000\"\n" +
                "               }\n" +
                "           ]\n" +
                "       }\n" +
                "   }\n" +
                "}";

        @Test
        public void testFlatteningJSONObjectTree() throws JsonProcessingException {
            Map<String, String> flattened = new HashMap();
            parseTree("", new ObjectMapper().readTree(json), flattened);

            // print out
            System.out.println("\n" + flattened);
            for (Map.Entry<String, String> entry : flattened.entrySet())
                System.out.println(entry.getKey() + ":" + entry.getValue());
        }


        private void parseTree(String currentPath, JsonNode jsonNode, Map<String, String> result) {
            // parent node
            if (jsonNode.isObject()) {
                ObjectNode objNode = (ObjectNode) jsonNode;
                Iterator<Map.Entry<String, JsonNode>> it = objNode.fields();
                String pathPrefix = currentPath.isEmpty() ? "" : currentPath + ".";

                while (it.hasNext()) {
                    Map.Entry<String, JsonNode> entry = it.next();
                    parseTree(pathPrefix + entry.getKey(), entry.getValue(), result);
                }
            }
            // child nodes
            else if (jsonNode.isArray()) {
                ArrayNode arrayNode = (ArrayNode) jsonNode;
                for (int i = 0; i < arrayNode.size(); i++)
                    parseTree(currentPath + "[" + i + "]", arrayNode.get(i), result);
            }
            // end node the value
            else if (jsonNode.isValueNode()) {
                ValueNode valueNode = (ValueNode) jsonNode;
                result.put(currentPath, valueNode.asText());
            }
        }
}