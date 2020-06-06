package com.syntra.tristanyannick.model.statuses;

public enum StatusDescription {

    CRITICAL("CRITICAL"), LOW("LOW"), NORMAL("NORMAL"), HIGH("HIGH");

    /**
     * The description of the status
     */
    private String description;

    StatusDescription(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
