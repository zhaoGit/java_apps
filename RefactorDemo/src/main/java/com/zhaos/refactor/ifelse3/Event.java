package com.zhaos.refactor.ifelse3;

public class Event {

	private String changeType;
	
	private DocType docType;

	public DocType getDocType() {
		return docType;
	}

	public void setDocType(DocType docType) {
		this.docType = docType;
	}

	public String getChangeType() {
		return changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
}
