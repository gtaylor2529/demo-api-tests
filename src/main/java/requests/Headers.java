package requests;

import java.util.HashMap;
import java.util.Map;

public class Headers {

    Map<String, String> headers;

    public enum Header {

        AUTH("Authorization"),
        CONTENT_TYPE("Content-Type");

        private String headerName;

        Header(String headerName) {
            this.headerName = headerName;
        }

        public String fieldName() {
            return headerName;
        }
    }

    public Headers() {
        this.headers = new HashMap<>();
    }

    public Headers(Map<String, String> headers) {
        this.headers = new HashMap<>();
    }

    public Map<String, String> map() {
        return this.headers;
    }

    public void addHeader(Header key, String value) {
        headers.put(key.fieldName(), value);
    }

    public void removeHeader(Header key) {
        headers.remove(key.fieldName());
    }
}
