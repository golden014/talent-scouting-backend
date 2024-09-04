package org.enrichment.talent_scouting_backend.api.dao.job_vacancy;

import org.enrichment.talent_scouting_backend.api.model.JobVacancy;
import org.enrichment.talent_scouting_backend.api.request.JobVacancyFilter;

import java.util.List;

public interface JobVacancyDAO {

    JobVacancy addJobVacancy(JobVacancy jobVacancy);

    void deleteJobVacancy(JobVacancy jobVacancy);

    JobVacancy getJobVacancyByID(Long jobVacancyID);

    List<JobVacancy> getJobVacanciesByFilters(JobVacancyFilter jobVacancyFilter);
}
