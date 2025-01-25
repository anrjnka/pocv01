package com.pocv01.model;

import java.util.List;

public class HeaderBahan {

    private String id;
    private List<Header> header;

    // Getter and Setter for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter and Setter for header
    public List<Header> getHeader() {
        return header;
    }

    public void setHeader(List<Header> header) {
        this.header = header;
    }

    // Inner class for Header items
    public static class Header {

        private String label;
        private String value;
        private String isLookup;
        
		public String getIsLookup() {
			return isLookup;
		}

		public void setIsLookup(String isLookup) {
			this.isLookup = isLookup;
		}

		private String lookupName;
        private String type;
        private String colspan;

        // Getter and Setter for label
        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        // Getter and Setter for value
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

       

        // Getter and Setter for lookupName
        public String getLookupName() {
            return lookupName;
        }

        public void setLookupName(String lookupName) {
            this.lookupName = lookupName;
        }

        // Getter and Setter for type
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        // Getter and Setter for colspan
        public String getColspan() {
            return colspan;
        }

        public void setColspan(String colspan) {
            this.colspan = colspan;
        }
    }
}
