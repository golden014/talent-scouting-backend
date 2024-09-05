package org.enrichment.talent_scouting_backend.api.dao.job_vacancy;

import org.enrichment.talent_scouting_backend.api.dto.JobVacancyAllAttributes;
import org.enrichment.talent_scouting_backend.api.model.JobVacancy;
import org.enrichment.talent_scouting_backend.api.dto.JobVacancyFilter;

import java.util.List;

public interface JobVacancyDAO {

    JobVacancy addJobVacancy(JobVacancy jobVacancy);

    void deleteJobVacancy(JobVacancy jobVacancy);

    JobVacancyAllAttributes getJobVacancyByID(Long jobVacancyId);

    List<JobVacancy> getJobVacanciesByFilters(JobVacancyFilter jobVacancyFilter);

    List<JobVacancy> getJobVacancyByCompanyId(Long companyID);

    List<JobVacancy> getTopJobVacancy(Long topCount);
}
