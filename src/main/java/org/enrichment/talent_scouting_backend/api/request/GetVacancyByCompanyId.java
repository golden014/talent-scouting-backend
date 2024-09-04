package org.enrichment.talent_scouting_backend.api.request;

public class GetVacancyByCompanyId {
    private Long companyId;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
