package org.enrichment.talent_scouting_backend.api.dto;

import java.util.List;

public class CompanyFilter {
    private String searchKeyword;
    private String location;
    private List<String> jobPosition;

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(List<String> jobPosition) {
        this.jobPosition = jobPosition;
    }
}
