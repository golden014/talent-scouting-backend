package org.enrichment.talent_scouting_backend.service.job_vacancy;

import org.enrichment.talent_scouting_backend.api.dto.JobVacancyAllAttributes;
import org.enrichment.talent_scouting_backend.api.model.JobVacancy;
import org.enrichment.talent_scouting_backend.api.dto.InsertJobVacancy;
import org.enrichment.talent_scouting_backend.api.dto.JobVacancyFilter;

import java.util.List;

public interface JobVacancyService {

    JobVacancy addJobVacancy(JobVacancy jobVacancy);

    void deleteJobVacancy(JobVacancy jobVacancy);

    JobVacancy addJobVacancy(InsertJobVacancy data);

    List<JobVacancy> getJobVacanciesByFilters(JobVacancyFilter jobVacancyFilter);

    List<JobVacancy> getJobVacancyByCompanyId(Long companyID);

    JobVacancyAllAttributes getJobVacancyById(Long id);
    List<JobVacancy> getTopJobVacancy(Long topCount);

}
