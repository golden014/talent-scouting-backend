package org.enrichment.talent_scouting_backend.service.job_vacancy;

import org.enrichment.talent_scouting_backend.api.model.JobVacancy;

public interface JobVacancyService {

    JobVacancy addJobVacancy(JobVacancy jobVacancy);

    void deleteJobVacancy(JobVacancy jobVacancy);
}
